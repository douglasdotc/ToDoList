import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { Board } from '../interface/board';
import { CustomResponse } from '../interface/custom-response';

@Injectable({
  providedIn: 'root'
})
export class BoardService {
  private readonly apiUrl = 'http://localhost:8080/api/v1/board';

  constructor(private http: HttpClient) { }

  // backend: getBoards()
  boards$ = <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/getBoards`)
  .pipe(
    tap(console.log), // Log to console
    catchError(this.handleError) // catch any error
  );

  // backend: createBoard()
  create$ = (board: Board) => <Observable<CustomResponse>>
  this.http.post<CustomResponse>(`${this.apiUrl}/createBoard`, board)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  // backend: updateBoard()
  update$ = (board: Board) => <Observable<CustomResponse>>
  this.http.put<CustomResponse>(`${this.apiUrl}/updateBoard`, board)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  // backend: deleteBoard()
  delete$ = (boardId: number) => <Observable<CustomResponse>>
  this.http.delete<CustomResponse>(`${this.apiUrl}/deleteBoard/${boardId}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  // Error handling function
  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(() => new Error(`An error occurred - Error code: ${error.status}`));
  }
}
