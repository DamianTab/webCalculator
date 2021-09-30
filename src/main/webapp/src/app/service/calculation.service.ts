import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {

  constructor() {
  }

  sendCalculationRequest(operation: string) {
    switch (operation) {
      case "+": {
        break;
      }
      case "-": {
        break;
      }
      case "*": {
        break;
      }
      case "/": {
        break;
      }
    }
  }

}
