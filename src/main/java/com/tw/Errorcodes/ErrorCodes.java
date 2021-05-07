package com.tw.Errorcodes;

@SuppressWarnings("unused")
public enum ErrorCodes {

    ZERO_DIVISION_ERROR("404", "divisor can't be zero in division"),
    INVALID_VALUE("400", "invalid values passed");

    private final String code;
    private final String description;
    ErrorCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
