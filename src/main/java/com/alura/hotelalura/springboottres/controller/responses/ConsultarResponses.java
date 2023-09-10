package com.alura.hotelalura.springboottres.controller.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ConsultarResponses(
     LocalDate checkIn,
     LocalDate checkOut,
     String categoria,
     BigDecimal precio
)
{}
