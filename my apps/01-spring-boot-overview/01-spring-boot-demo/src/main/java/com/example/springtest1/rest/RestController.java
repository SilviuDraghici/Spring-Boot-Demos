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
}
