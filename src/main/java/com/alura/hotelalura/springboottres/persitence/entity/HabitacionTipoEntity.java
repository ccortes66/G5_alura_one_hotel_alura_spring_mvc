package com.alura.hotelalura.springboottres.persitence.entity;

import java.math.BigDecimal;

import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoModel;

import jakarta.persistence.Entity;
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
public class HabitacionTipoEntity extends ValueSuperEntity
{
    @Id
    @NonNull
    private String categoria;
    @NonNull
    private BigDecimal percioUnitario;
    @NonNull
    private Integer puntosUnitario;
     
    public HabitacionTipoEntity(HabitacionTipoModel dto)
    {
        this(dto.categoria(), 
             dto.percioUnitario(), 
             dto.puntosUnitario());
    }
       
}
