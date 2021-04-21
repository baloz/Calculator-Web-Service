package com.tw.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    @Test
    void shouldReturnExpectedAdditionResultIfInputsAreValid() {
        final Calculator calculator = new Calculator();
        final double result = calculator.add(4.0, 5.0);
        final double expected = 9.0;
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnExpectedMultiplicationResultIfInputsAreValid() {
        final Calculator calculator = new Calculator();
        final double result = calculator.multiply(4.0, 5.0);
        final double expected = 20.0;
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnExpectedDivisionResultIfInputsAreValid() {
        final Calculator calculator = new Calculator();
        final double result = calculator.divide(20.0, 5.0);
        final double expected = 4.0;
        assertEquals(expected, result);
    }
}
