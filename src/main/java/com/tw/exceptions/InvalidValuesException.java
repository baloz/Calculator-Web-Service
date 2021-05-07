package com.tw.exceptions;

import com.tw.Errorcodes.ErrorCodes;

public class InvalidValuesException extends CalculatorException {
    public InvalidValuesException(ErrorCodes code, String s) {
        super(code, s);
    }
}
