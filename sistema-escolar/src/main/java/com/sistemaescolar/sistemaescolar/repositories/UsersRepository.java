package com.sistemaescolar.sistemaescolar.repositories;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    
}
