package com.alura.hotelalura.springboottres.persitence.dto.user;

import java.io.Serializable;
import java.time.LocalDate;

import com.alura.hotelalura.springboottres.controller.requests.RegisterRequest;
import com.alura.hotelalura.springboottres.persitence.entity.RoleUser;

public record UserModel(
    String dni,
    String nombre,
    String apellido,
    LocalDate fechaNacimiento,
    String username,
    RoleUser roleUser
) 
{    
    public UserModel(RegisterRequest request)
    {
        this(request.dni(),
             request.nombre(), 
             request.apellido(), 
             request.fechaNacimiento(),
             request.username(),
             request.roleUser());
    }
}
