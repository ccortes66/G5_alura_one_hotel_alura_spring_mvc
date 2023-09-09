package com.alura.hotelalura.springboottres.controller.responses;

import java.util.List;

import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoCategoria;

public record CreacionResponses(
    String username,
    Boolean[] confirmaciones,
    List<HabitacionTipoCategoria> listarCaregoria 
) 
{}
