package com.alura.hotelalura.springboottres.controller.responses;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.ConsultaCriteria;

import java.util.List;


public record BuscarResponsesEmpleado(
        String username,
        List<ConsultaCriteria> listarCriteria     
)
{}
