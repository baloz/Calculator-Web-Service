package com.tw.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorService {
    public static boolean divisionViewFlag = false;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getAdditionResult(@RequestBody  Params params) {
        return new Calculator().add(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getMultiplicationResult(@RequestBody  Params params) {
        return new Calculator().multiply(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public ResponseEntity<Double> getDivisionResult(@RequestBody  Params params){
        final double divide = new Calculator().divide(params.getValueOne(), params.getValueTwo());
        if (divisionViewFlag)return new ResponseEntity<Double>(divide, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/toggleDivision", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setDivisionViewFlag(@RequestBody  boolean status){
        divisionViewFlag = status;
    }
 }
