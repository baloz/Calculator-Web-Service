package com.tw.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    public static boolean divisionViewFlag = false;

    @Autowired
    private CalculatorConfiguration calculatorConfiguration;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getAdditionResult(@RequestBody Params params) {
        return new Calculator().add(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getMultiplicationResult(@RequestBody Params params) {
        return new Calculator().multiply(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public ResponseEntity<Double> getDivisionResult(@RequestBody Params params) {
        final double divide = new Calculator().divide(params.getValueOne(), params.getValueTwo());
        if (divisionViewFlag) return new ResponseEntity<Double>(divide, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/enablefeature", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String enablefeature() {
        calculatorConfiguration.setMultiply(true);
        return "Multiply Is enabled";
    }

    @RequestMapping(value = "/disablefeature", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String disablefeature() {
        calculatorConfiguration.setMultiply(false);
        return "Multiply is Disabled";
    }

}
