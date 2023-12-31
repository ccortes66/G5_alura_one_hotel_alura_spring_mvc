package com.alura.hotelalura.springboottres.persitence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class HabitacionEntity extends ValueSuperEntity
{   
    @Setter(AccessLevel.NONE)
    private Long id;
    @Id
    @NonNull
    private Integer numero;
    private Boolean reservado = false;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habitacion_tipo",
                referencedColumnName = "categoria")
    private HabitacionTipoEntity habitacionTipo;

}
