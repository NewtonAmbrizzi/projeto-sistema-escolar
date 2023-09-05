package com.sistemaescolar.sistemaescolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.sistemaescolar.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

    
}
