package com.tw.calculator;

import com.tw.exceptions.InvalidValuesException;
import com.tw.exceptions.ZeroDivisorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorServiceTest {
    @Test
    void shouldReturnExpectedAdditionResultIfInputsAreValid() throws InvalidValuesException {
        final CalculatorService calculator = new CalculatorService();
        final double result = calculator.add(4.0, 5.0);
        final double expected = 9.0;
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnExpectedMultiplicationResultIfInputsAreValid() throws InvalidValuesException {
        final CalculatorService calculator = new CalculatorService();
        final double result = calculator.multiply(4.0, 5.0);
        final double expected = 20.0;
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnExpectedDivisionResultIfInputsAreValid() throws ZeroDivisorException, InvalidValuesException {
        final CalculatorService calculator = new CalculatorService();
        final double result = calculator.divide(20.0, 5.0);
        final double expected = 4.0;
        assertEquals(expected, result);
    }
}
