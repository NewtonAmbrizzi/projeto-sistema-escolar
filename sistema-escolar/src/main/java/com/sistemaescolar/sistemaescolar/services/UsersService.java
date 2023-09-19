package com.sistemaescolar.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaescolar.sistemaescolar.models.User;
import com.sistemaescolar.sistemaescolar.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public List<User> findUsersByStatus(String status) {
        return usersRepository.findByStatus(status);
    }

    @Transactional
    public void changeStatus(String id) {
        User user = usersRepository.findById(id).get();
        if (user.getStatus().equalsIgnoreCase("ativo")){
            user.setStatus("inativo");
        } else {
            user.setStatus("ativo");
        }
        
        usersRepository.save(user);
    }

    @Transactional
    public Boolean createUser(User user) {
        if (usersRepository.existsByEmail(user.getEmail())) {
            return false;
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            usersRepository.save(user);
            return true;
        }
    }

    @Transactional
    public void updateUser(String id, User user){
       if (usersRepository.existsById(id)) {
        usersRepository.save(user);
       } 
    }
    
    @Transactional
    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    }
}
