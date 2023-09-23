package com.alura.hotelalura.springboottres.persitence.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class ValueSuperEntity 
{
    private Integer activo = 1;
}
