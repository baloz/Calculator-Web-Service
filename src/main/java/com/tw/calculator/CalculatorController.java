package com.tw.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorConfiguration calculatorConfiguration;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getAdditionResult(@RequestBody Params params) {
        return new CalculatorService().add(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getMultiplicationResult(@RequestBody Params params) {
        return new CalculatorService().multiply(params.getValueOne(), params.getValueTwo());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public double getDivisionResult(@RequestBody Params params) {
        return new CalculatorService().divide(params.getValueOne(), params.getValueTwo());
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
