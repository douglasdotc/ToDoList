import { AppStatus } from './interface/app-status';
import { Component, OnInit } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { startWith, catchError } from 'rxjs/operators';
import { BoardService } from './service/board.service';
import { CustomResponse } from './interface/custom-response';
import { DataStatus } from './enum/data-status.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  // The status of the app at any moment
  appStatus$: Observable<AppStatus<CustomResponse>>; // $ denotes Observables

  // constructor with service injection
  constructor(private boardService: BoardService) {}

  // Application initialize (reactive approach):
  ngOnInit(): void {
    this.appStatus$ = this.boardService.boards$ // subscribe to board service
    .pipe(
      // Whenever we get a response from the server we want to execute a app status callback function:
      // Map response to callback function:
      map(response => {
        return {
          dataStatus: DataStatus.LOADED_STATE, // We got a response, so loaded
          appData: response
        }
      }),
      startWith({
        dataStatus: DataStatus.LOADING_STATE, // subscribe to board service with init status LOADING_STATE
      }),
      catchError((error: string) => {
        return of({
          dataStatus: DataStatus.ERROR_STATE, // subscribe to board service with error
          error: error
        })
      })
    )
  }
}
