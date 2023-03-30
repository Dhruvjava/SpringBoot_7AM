package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/login","home","/"})
    public String loginPage(){
        return "LoginPage";
    }
}
