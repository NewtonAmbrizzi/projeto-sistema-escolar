package com.sistemaescolar.sistemaescolar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.sistemaescolar.sistemaescolar.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findByStatus(String status);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndPassword(String email, String password);

    UserDetails findByEmail(String email);
    
}
