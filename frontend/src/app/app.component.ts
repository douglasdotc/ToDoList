import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { map, Observable, of } from 'rxjs';
import { startWith, catchError } from 'rxjs/operators';

import { IconSetService } from '@coreui/icons-angular';
import { iconSubset } from './icons/icon-subset';
import { Title } from '@angular/platform-browser';

import { BoardService } from './service/board.service';
import { CustomResponse } from './interface/custom-response';
import { DataStatus } from './enum/data-status.enum';
import { AppStatus } from './interface/app-status';

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'body',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  title = 'CoreUI Free Angular Admin Template';
  // The status of the app at any moment
  appStatus$: Observable<AppStatus<CustomResponse>>; // $ denotes Observables

  constructor(
    private router: Router,
    private titleService: Title,
    private iconSetService: IconSetService,
    private boardService: BoardService
  ) {
    titleService.setTitle(this.title);
    // iconSet singleton
    iconSetService.icons = { ...iconSubset };
  }

  ngOnInit(): void {
    this.router.events.subscribe((evt) => {
      if (!(evt instanceof NavigationEnd)) {
        return;
      }
    });

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
