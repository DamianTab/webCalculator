package damian.tab.calculator.api;

import damian.tab.calculator.api.model.CalculationInputData;
import damian.tab.calculator.api.model.CalculationResult;
import damian.tab.calculator.service.CalculationService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequestMapping("/api/calculator")
@RestController
public class CalculatorController {
    private final CalculationService calculationService;

    @GetMapping("/addition")
    public CalculationResult executeAddition(CalculationInputData inputData) {
        double result = calculationService.add(inputData.getFirstNumber(), inputData.getSecondNumber());
        return new CalculationResult(result);
    }

    @GetMapping("/subtraction")
    public CalculationResult executeSubtraction(CalculationInputData inputData) {
        double result = calculationService.subtract(inputData.getFirstNumber(), inputData.getSecondNumber());
        return new CalculationResult(result);
    }

    @GetMapping("/multiplication")
    public CalculationResult executeMultiplication(CalculationInputData inputData) {
        double result = calculationService.multiply(inputData.getFirstNumber(), inputData.getSecondNumber());
        return new CalculationResult(result);
    }

    @GetMapping("/division")
    public CalculationResult executeDivision(CalculationInputData inputData) {
        double result = calculationService.divide(inputData.getFirstNumber(), inputData.getSecondNumber());
        return new CalculationResult(result);
    }
}
