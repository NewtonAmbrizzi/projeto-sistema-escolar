package com.sistemaescolar.sistemaescolar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;

@Service
public class LoginService {

    @Autowired
    private UsersRepository userRepository;

    @Transactional
    public Boolean login(User user) {
        if (userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            return true;
        } 
        
        return false;
        
    }

}
