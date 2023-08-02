package com.example.springbootmvccrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoThymeController {

    public DemoThymeController(){
        System.out.println("Creating Thyme Controller!");
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }

}
