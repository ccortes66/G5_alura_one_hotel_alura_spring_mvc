package com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo;
import java.math.BigDecimal;


public record HabitacionTipoModel(
    String categoria,
    BigDecimal percioUnitario,
    Integer puntosUnitario
){}
