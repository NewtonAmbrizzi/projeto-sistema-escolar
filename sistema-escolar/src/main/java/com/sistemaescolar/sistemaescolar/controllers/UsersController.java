package com.sistemaescolar.sistemaescolar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping(value = {"/users"})
    public String index(Model model){
        return "users/index";
    }
    
}
