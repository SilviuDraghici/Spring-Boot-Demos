package com.example.util;

import org.springframework.stereotype.Component;

@Component
public class FieldInjectionExample {
    public String returnHTMLString(){
        return "<br>Field injection is not recommended because it makes unit testing harder";
    }
}
