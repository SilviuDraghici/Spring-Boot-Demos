package com.example.springtest1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${test.value1}")
    private String value1;

    @Value("${test.num1}")
    private int num1;

    @GetMapping("/")
    public String sayHello(){
        return "HelloWorld!<br>value1: " + value1 + "<br>num1:"+ num1;
    }

    @GetMapping("/workout")
    public String workout(){
        return "Run a HARD 5k!<br>value1: " + value1 + "<br>num1:"+ num1;
    }

    @GetMapping("/intro")
    public String intro1984(){
        return "It was a bright cold day in April, and the clocks were striking thirteen.<br>"
                + value1 + "<br>num1:"+ num1;
    }
}
