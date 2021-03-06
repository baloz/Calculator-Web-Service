package com.tw.calculator.controller;

import com.tw.calculator.model.CalculatorService;
import com.tw.calculator.model.Params;
import com.tw.exceptions.InvalidValuesException;
import com.tw.exceptions.ZeroDivisorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RefreshScope

public class CalculatorController {
    @Value("${myname}")
    private String name;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Double> getAdditionResult(@RequestBody Params params) throws InvalidValuesException {
        double res = new CalculatorService().add(params.getValueOne(), params.getValueTwo());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public ResponseEntity<Double> getMultiplicationResult(@RequestBody Params params) throws InvalidValuesException {
        final double result = new CalculatorService().multiply(params.getValueOne(), params.getValueTwo());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public ResponseEntity<Double> getDivisionResult(@RequestBody Params params) throws ZeroDivisorException, InvalidValuesException {
        final double result = new CalculatorService().divide(params.getValueOne(), params.getValueTwo());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test(){

        return new ResponseEntity<>(name, HttpStatus.OK);
    }


}
