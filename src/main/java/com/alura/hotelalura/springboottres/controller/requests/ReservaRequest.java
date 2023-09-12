package com.alura.hotelalura.springboottres.controller.requests;

import java.time.LocalDate;

public record ReservaRequest(
    LocalDate checkIn,
    LocalDate checkOut,
    String categoria,
    String currentUri,
    String metodoPago,
    String username
) 
{}
