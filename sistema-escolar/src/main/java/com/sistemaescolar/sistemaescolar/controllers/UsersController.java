package com.sistemaescolar.sistemaescolar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping(value = {"/users"})
    public String index(Model model){
        List<User> users = repository.findByStatus("Ativo");
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping(value = {"/users/inactives"})
    public String inactive(Model model){
        List<User> users = repository.findByStatus("Inativo");
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping(value = {"/users/new-user"})
    public String newUser(){
        
        return "users/new-user";
    }

    @PostMapping("/users/create")
    public String create(User user){
        repository.save(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = {"/users/delete/{id}"})
    public String delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "redirect:/users";
    }
}
