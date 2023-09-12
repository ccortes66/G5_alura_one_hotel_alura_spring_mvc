package com.alura.hotelalura.springboottres.controller.responses;

import java.util.List;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.ListarReservacion;


public record ReservaClienteResponses(
    String username,
    List<String> listarCategoria,
    List<String> listaMetodoPago,
    ListarReservacion listarReservacion
) 
{

}
