package com.sistemaescolar.sistemaescolar.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;
import com.sistemaescolar.sistemaescolar.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UsersService usersService;

    @GetMapping(value = {"/users"})
    public String index(Model model){
        model.addAttribute("users", usersService.findUsersByStatus("Ativo"));
        return "users/index";
    }

    @GetMapping(value = {"/users/inactives"})
    public String inactive(Model model){
        model.addAttribute("users", usersService.findUsersByStatus("Inativo"));
        return "users/inactives";
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

    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Optional<User> user = repository.findById(id);
        model.addAttribute("user", user.get());
        if (user.get().getStatus().toString().equalsIgnoreCase("ativo")){
            return "users/edit";
        } else {
            return "redirect:/users/inactives";
        }
    }

    @DeleteMapping(value = {"/users/delete/{id}"})
    public String delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "redirect:/users";
    }
}
