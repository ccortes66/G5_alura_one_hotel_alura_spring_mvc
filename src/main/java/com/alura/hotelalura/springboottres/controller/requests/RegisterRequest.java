package com.alura.hotelalura.springboottres.controller.requests;

import java.time.LocalDate;

import com.alura.hotelalura.springboottres.persitence.entity.RoleUser;

public record RegisterRequest(
    String dni,
    String nombre,
    String apellido,
    LocalDate fechaNacimiento,
    String username,
    String password,
    String verifyPassword,
    String currentUri,
    RoleUser roleUser

) 
{}
