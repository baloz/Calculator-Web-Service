package com.tw.exceptions;

import com.tw.Errorcodes.ErrorCodes;

public class CalculatorException extends Exception{
    ErrorCodes code;
    String message;

    public CalculatorException(ErrorCodes code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCodes getCode() {
        return code;
    }
}
