package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/customLoginPage")
    public String loginPage(){
        return "login-page";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
