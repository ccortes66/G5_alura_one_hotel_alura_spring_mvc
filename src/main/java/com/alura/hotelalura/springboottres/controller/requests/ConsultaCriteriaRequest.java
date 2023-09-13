package com.alura.hotelalura.springboottres.controller.requests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public record ConsultaCriteriaRequest(
        String username,
        Optional<LocalDate> checkIn,
        Optional<String> categoria,
        Optional<BigDecimal> precio
)
{

}
