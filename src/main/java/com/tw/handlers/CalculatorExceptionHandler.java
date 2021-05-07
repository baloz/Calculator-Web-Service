package com.tw.handlers;

import com.tw.Errorcodes.ErrorMessage;
import com.tw.exceptions.InvalidValuesException;
import com.tw.exceptions.ZeroDivisorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculatorExceptionHandler{

    @ExceptionHandler(ZeroDivisorException.class)
    public final ResponseEntity<ErrorMessage> handleZeroDivision(ZeroDivisorException ex){
        final ErrorMessage errorMessage = new ErrorMessage(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidValuesException.class)
    public final ResponseEntity<ErrorMessage> handleInvalidValues(InvalidValuesException exception){
        final ErrorMessage errorMessage = new ErrorMessage(exception.getCode(), exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
    }
}
