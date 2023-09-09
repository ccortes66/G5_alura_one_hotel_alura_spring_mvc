package com.alura.hotelalura.springboottres.persitence.entity;

import com.alura.hotelalura.springboottres.persitence.dto.user.UserModel;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class UserEntity 
{   
    @Id
    @NonNull
    private String username;
    @NonNull
    private String documento;
    private String password;
    private Boolean locked = false;
    private Boolean isDisabled = false;
    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleUser roles;
    @NonNull
    @Embedded
    private InfoEntityEmb infoPersonal;

    public UserEntity(UserModel dto)
    {
       this(dto.username(),
            dto.dni(), 
            dto.roleUser(),
            new InfoEntityEmb(dto.nombre(),dto.apellido(),dto.fechaNacimiento())
        );
    } 


}
