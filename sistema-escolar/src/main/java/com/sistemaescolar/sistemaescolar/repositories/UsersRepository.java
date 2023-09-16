package com.sistemaescolar.sistemaescolar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.sistemaescolar.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findByStatus(String status);

    Boolean existByEmail(String email);
    
}
