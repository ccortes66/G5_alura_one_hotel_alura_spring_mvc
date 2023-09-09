package com.alura.hotelalura.springboottres.persitence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class MetodoEntity extends ValueSuperEntity
{   
    @Id
    @NonNull
    private String metodo;

}
