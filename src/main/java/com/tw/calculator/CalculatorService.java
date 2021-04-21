package com.tw.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorService {



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


 }
