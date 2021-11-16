import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Result} from "../component/calculator/model/result";

@Injectable({
  providedIn: 'root'
})
export class CalculationService {
  // readonly API_URL = 'http://localhost:8080/api/calculator/'
  readonly API_URL = '/api/calculator/'

  constructor(private httpClient: HttpClient) {
  }

  sendCalculationRequest(operation: string, first: number, second: number): Observable<Result> {
    const params = new HttpParams({
      fromObject: {
        firstNumber: first,
        secondNumber: second
      }})
    return this.httpClient.get<Result>(this.API_URL+operation,  {params})
  }
}
