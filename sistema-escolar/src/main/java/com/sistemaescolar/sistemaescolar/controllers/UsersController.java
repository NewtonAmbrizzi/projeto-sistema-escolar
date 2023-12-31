package com.sistemaescolar.sistemaescolar.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;
import com.sistemaescolar.sistemaescolar.services.UsersService;

@Controller
public class UsersController {

    private static final String REDIRECT_USERS = "redirect:/users";

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UsersService usersService;

    @GetMapping(value = { "/users","/users/" })
    public String index(Model model) {
        model.addAttribute("users", usersService.findUsersByStatus("Ativo"));
        return "users/index";
    }

    @GetMapping(value = { "/users/inactives" })
    public String inactive(Model model) {
        model.addAttribute("users", usersService.findUsersByStatus("Inativo"));
        return "users/inactives";
    }

    @GetMapping(value = { "/users/new-user" })
    public String newUser() {
        
        return "users/new-user";
    }

    @PostMapping("/users/create")
    public String create(User user) {
        if (usersService.createUser(user)){
        return REDIRECT_USERS;
        } else {
            return "/users/new-user";
        }
    }

    @PostMapping("/users/change-status/{id}")
    public ModelAndView changeStatus(@PathVariable("id") String id) {
        usersService.changeStatus(id);
        return new ModelAndView(REDIRECT_USERS);
    }

    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        try {
            Optional<User> user = repository.findById(id);
            model.addAttribute("user", user.get());
        
            if (user.get().getStatus().equalsIgnoreCase("ativo")) {
                return "users/edit";
            } else {
                return REDIRECT_USERS;
            }
        } catch (Exception e) {
            return REDIRECT_USERS;
        }
    }

    @PostMapping("users/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") String id, User user) {
        usersService.updateUser(id, user);
        return new ModelAndView(REDIRECT_USERS);
    }

    @PostMapping(value = { "/users/delete/{id}" })
    public String delete(@PathVariable("id") String id) {
        usersService.deleteUser(id);
        return "redirect:/users/inactives";
    }
}
