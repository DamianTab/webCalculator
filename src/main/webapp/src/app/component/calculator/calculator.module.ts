import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CalculatorComponent} from "./calculator.component";
import {ButtonModule} from "primeng/button";
import {InputNumberModule} from "primeng/inputnumber";
import {CardModule} from "primeng/card";
import {SplitterModule} from "primeng/splitter";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [CalculatorComponent],
  exports: [
    CalculatorComponent
  ],
  imports: [
    CommonModule,
    ButtonModule,
    InputNumberModule,
    CardModule,
    SplitterModule,
    FormsModule
  ]
})
export class CalculatorModule {
}
