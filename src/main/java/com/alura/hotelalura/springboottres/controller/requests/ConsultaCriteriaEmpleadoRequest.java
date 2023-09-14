package com.alura.hotelalura.springboottres.controller.requests;


import java.time.LocalDate;
import java.util.Optional;

public record ConsultaCriteriaEmpleadoRequest(
        Optional<String> reservaId,
        Optional<LocalDate> checkIn
        
)
{

}
