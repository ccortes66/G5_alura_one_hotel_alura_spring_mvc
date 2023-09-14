package com.alura.hotelalura.springboottres.controller.responses;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.ConsultaCriteria;


import org.springframework.data.domain.Page;

public record BuscarResponses(
        String username,
        Page<ConsultaCriteria> listarCriteria     
)
{}
