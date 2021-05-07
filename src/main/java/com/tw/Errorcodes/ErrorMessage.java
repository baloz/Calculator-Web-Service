package com.tw.Errorcodes;

public class ErrorMessage {
    ErrorCodes code;
    String description;

    public ErrorMessage(ErrorCodes code, String description) {
        super();
        this.code = code;
        this.description = description;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public void setCode(ErrorCodes code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
