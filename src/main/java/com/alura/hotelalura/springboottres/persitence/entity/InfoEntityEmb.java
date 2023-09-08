package com.alura.hotelalura.springboottres.persitence.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class InfoEntityEmb 
{
   @NonNull 
   private String nombre;
   @NonNull 
   private String apellido;
   @NonNull 
   private LocalDate fechaNacimiento;
   private String telefono;

}
