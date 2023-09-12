package com.alura.hotelalura.springboottres.controller.responses;

import java.util.List;



public record ReservaResponses(
    String username,
    List<String> listarCaregoria,
    ConsultarResponses consultaResponses
    
) 
{}
