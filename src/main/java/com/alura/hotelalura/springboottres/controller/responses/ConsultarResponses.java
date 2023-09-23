package com.alura.hotelalura.springboottres.controller.responses;


import java.time.LocalDate;

public record ConsultarResponses(
     LocalDate checkIn,
     LocalDate checkOut,
     String categoria,
     Float precio
)
{}
