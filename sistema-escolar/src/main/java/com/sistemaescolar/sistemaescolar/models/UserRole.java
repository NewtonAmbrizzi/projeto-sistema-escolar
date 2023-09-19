package com.sistemaescolar.sistemaescolar.models;

public enum UserRole {

    ADMINISTRADOR("administrador"),
    PROFESSOR("professor"),
    RESPONSAVEL("responsavel");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
