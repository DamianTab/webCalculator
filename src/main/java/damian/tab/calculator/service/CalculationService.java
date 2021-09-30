package damian.tab.calculator.service;

import damian.tab.calculator.exception.CalculationResultOutOfBoundException;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double add(double first, double second){
        double result = first + second;
        throwExceptionWhenOutOfBound(result);
        return result;
    }

    public double subtract(double first, double second){
        double result = first - second;
        throwExceptionWhenOutOfBound(result);
        return result;
    }

    public double multiply(double first, double second){
        double result = first * second;
        throwExceptionWhenOutOfBound(result);
        return result;
    }

    public double divide(double first, double second){
        double result = first / second;
        throwExceptionWhenOutOfBound(result);
        return result;
    }

    private void throwExceptionWhenOutOfBound(double result){
        if (Double.isInfinite(result)){
            throw new CalculationResultOutOfBoundException();
        }
    }
}
