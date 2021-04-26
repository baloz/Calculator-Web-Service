package com.tw.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
public class CalculatorController {



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



}
