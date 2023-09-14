package com.alura.hotelalura.springboottres.controller.responses;

import java.util.List;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.ConsultaCriteria;

public record BuscarClienteResponses(
    String username,
    List<ConsultaCriteria> listarCriteria,
    List<String> listarCategoria

)
{}
