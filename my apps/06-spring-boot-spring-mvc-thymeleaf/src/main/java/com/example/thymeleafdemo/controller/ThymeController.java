package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }
}
