package damian.tab.calculator.service;

import damian.tab.calculator.exception.CalculationResultOutOfBoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationServiceTest {

    private static CalculationService calculationService = new CalculationService();

    @Test
    void shouldDivideWhenNormalNumbers() {
        double first = 12345;
        double second = 15;
        assertEquals(823, calculationService.divide(first, second));
    }

    @Test
    void shouldDivideWhenDecimalFraction() {
        double first = 10.5;
        double second = 4;
        assertEquals(2.625, calculationService.divide(first, second));
    }

    @Test
    void shouldThrowExceptionWhenNumbersOutOfBound() {
        double first = Double.POSITIVE_INFINITY;
        double second = 15;
        assertThrows(CalculationResultOutOfBoundException.class, () -> calculationService.divide(first, second));
    }
}