package com.sistemaescolar.sistemaescolar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class LoginController {

    @GetMapping(value = {"/login"})
    public String index(Model model){
        return "login/index";
    }
    
}
