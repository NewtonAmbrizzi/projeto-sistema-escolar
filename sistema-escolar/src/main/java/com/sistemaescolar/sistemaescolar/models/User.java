package com.sistemaescolar.sistemaescolar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    private String nome;
    
}
