package com.alura.hotelalura.springboottres.persitence.dto.user;


import com.alura.hotelalura.springboottres.persitence.entity.ClienteEntity;
import com.alura.hotelalura.springboottres.persitence.entity.UserEntity;

public record ClienteModel(
    String username,
    Integer puntos, 
    Byte vip,
    String nacionalidad,
    UserEntity userEntity

) 
{
   public ClienteModel(ClienteEntity entity)
    {
        this(entity.getUsername(), 
             entity.getPuntos(), 
             entity.getVip(), 
             entity.getNacionalida(), 
             entity.getUserEntity());
    }
}
