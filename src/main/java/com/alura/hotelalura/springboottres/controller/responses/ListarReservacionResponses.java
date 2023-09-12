package com.alura.hotelalura.springboottres.controller.responses;


import java.util.List;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.MostrarReservacion;

public record ListarReservacionResponses(
    String username,
    List<MostrarReservacion> listarReservacion
)

{
}
