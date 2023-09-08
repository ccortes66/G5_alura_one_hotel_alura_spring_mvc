package com.alura.hotelalura.springboottres.controller.responses;

public record LoginResponses(
   String linkAction, 
   String img,
   ErrorResponses responses,
   String linkRegistro,
   String currentUri
) 
{}
