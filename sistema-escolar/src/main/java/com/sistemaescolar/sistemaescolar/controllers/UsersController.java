package com.sistemaescolar.sistemaescolar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping(value = {"/users"})
    public String index(Model model){
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping(value = {"/users/new-user"})
    public String newUser(Model model){
        
        return "users/new-user";
    }
    
}
