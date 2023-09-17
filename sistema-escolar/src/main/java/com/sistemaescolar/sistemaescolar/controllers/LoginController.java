package com.sistemaescolar.sistemaescolar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.services.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService login;

    @GetMapping(value = {"/login"})
    public String index(){
        return "login/index";
    }
    
    @PostMapping(value = {"/logar"})
    public String logar(Model model, User user, String remember){
        if (login.login(user)){
            return "redirect:/";
        } else {
            return "redirect:/login";
        }        
    }
}
