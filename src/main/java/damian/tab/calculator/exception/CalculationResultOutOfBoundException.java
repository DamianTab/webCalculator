package damian.tab.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class CalculationResultOutOfBoundException extends RuntimeException {
    public CalculationResultOutOfBoundException() {
        super("Expected result of calculation exceeded minimum or maximum bound of double.");
    }
}
