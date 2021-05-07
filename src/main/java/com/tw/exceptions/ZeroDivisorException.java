package com.tw.exceptions;

import com.tw.Errorcodes.ErrorCodes;

public class ZeroDivisorException extends CalculatorException {
    public ZeroDivisorException(ErrorCodes code, String s) {
        super(code, s);
    }
}
