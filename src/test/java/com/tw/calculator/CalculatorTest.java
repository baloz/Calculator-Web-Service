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

}
