package com.alura.hotelalura.springboottres.controller.responses;

import java.util.List;

public record CreacionResponses(
    String username,
    Boolean[] confirmaciones,
    List<String> listarCaregoria 
) 
{}
