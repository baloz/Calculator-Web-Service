package com.tw.calculator.model;

import com.tw.Errorcodes.ErrorCodes;
import com.tw.exceptions.InvalidValuesException;
import com.tw.exceptions.ZeroDivisorException;

public class CalculatorService {
    public double add(double valueOne, double valueTwo) throws InvalidValuesException {
        checkValidValues(valueOne, valueTwo);
        return valueOne + valueTwo;
    }

    private void checkValidValues(double valueOne, double valueTwo) throws InvalidValuesException {
        if (valueOne == Double.POSITIVE_INFINITY || valueTwo == Double.POSITIVE_INFINITY)
            throw new InvalidValuesException(ErrorCodes.INVALID_VALUE, "Values can't be infinity");
        if (valueOne == Double.NEGATIVE_INFINITY || valueTwo == Double.NEGATIVE_INFINITY)
            throw new InvalidValuesException(ErrorCodes.INVALID_VALUE, "Values can't be infinity");
        if (valueOne == Double.MAX_VALUE || valueTwo == Double.MAX_VALUE)
            throw new InvalidValuesException(ErrorCodes.INVALID_VALUE, "Boundary values can't be given");
        if (valueOne == Double.MIN_VALUE || valueTwo == Double.MIN_VALUE)
            throw new InvalidValuesException(ErrorCodes.INVALID_VALUE,"Boundary values can't be given");
    }

    public double multiply(double valueOne, double valueTwo) throws InvalidValuesException {
        checkValidValues(valueOne, valueTwo);
        return valueOne * valueTwo;
    }

    public double divide(double dividend, double divisor) throws ZeroDivisorException, InvalidValuesException {
        checkValidValues(dividend, divisor);
        if (divisor == 0.0) throw new ZeroDivisorException(ErrorCodes.ZERO_DIVISION_ERROR, "Can't divide with zero, given non-zero divisor");
        return dividend / divisor;
    }
}
