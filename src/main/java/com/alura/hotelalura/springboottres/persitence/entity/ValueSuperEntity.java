package com.alura.hotelalura.springboottres.persitence.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class ValueSuperEntity 
{
    private Boolean activo = true;
}
