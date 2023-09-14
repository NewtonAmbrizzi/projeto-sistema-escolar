package com.sistemaescolar.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void changeStatus(Integer id) {
        User user = usersRepository.findById(id).get();
        if (user.getStatus().equalsIgnoreCase("ativo")){
            user.setStatus("inativo");
        } else {
            user.setStatus("ativo");
        }
        
        usersRepository.save(user);
    }

    @Transactional
    public void createUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void updateUser(Integer id, User user){
       if (usersRepository.existsById(id)) {
        usersRepository.save(user);
       } 
    }
    
    @Transactional
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }
}
