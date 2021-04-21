package com.tw.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorService {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double getAdditionResult(@RequestBody  Params params) {
        return new Calculator().add(params.getValueOne(), params.getValueTwo());
    }

    @GetMapping("/getParams")
    public Params getParams(){
        final Params params = new Params();
        params.setValueOne(20.0);
        params.setValueTwo(30.0);
        return params;
    }
}
