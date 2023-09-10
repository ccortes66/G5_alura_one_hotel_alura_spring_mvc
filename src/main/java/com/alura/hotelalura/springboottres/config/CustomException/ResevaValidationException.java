package com.alura.hotelalura.springboottres.config.CustomException;

public class ResevaValidationException extends RuntimeException
{
    public ResevaValidationException(String value)
    {
        super(value);
    }
}
