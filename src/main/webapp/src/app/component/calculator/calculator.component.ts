import {Component, OnInit} from '@angular/core';
import {CalculationService} from "../../service/calculation.service";

@Component({
  selector: 'cal-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  first: number = 0;
  second: number = 0;
  result: number = 0;

  constructor(private calculationService: CalculationService) {
  }

  ngOnInit(): void {
  }

  calculate(operation: string) {
    this.calculationService.sendCalculationRequest(operation);
  }

}
