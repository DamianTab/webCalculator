import {Component, OnInit} from '@angular/core';
import {CalculationService} from "../../service/calculation.service";

@Component({
  selector: 'cal-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  first: number = 10.124;
  second: number = 2.2;
  result: number = 0;

  constructor(private calculationService: CalculationService) {
  }

  ngOnInit(): void {
  }

  calculate(operation: string) {
    this.calculationService.sendCalculationRequest(operation, this.first, this.second)?.subscribe(result => {
      this.result = result.result;
    });
  }

}
