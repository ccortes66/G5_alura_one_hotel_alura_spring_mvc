package com.alura.hotelalura.springboottres.service.validate;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.alura.hotelalura.springboottres.config.CustomException.ResevaValidationException;
import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;

public interface ReservaValidation 
{
    void validate(ReservaRequest request);
}

@Component
class isValidDate implements ReservaValidation
{

    @Override
    public void validate(ReservaRequest request) 
    {
       if(request.checkIn().isBefore(LocalDate.now()) || 
          request.checkOut().isBefore(LocalDate.now()))
         {
            throw new ResevaValidationException(String.format("%s,%s"
                                                                   ,"Las fechas pertenecen al día o días anteriores"
                                                                   ,request.currentUri()));
         }

     
    }

}

@Component
class isEqualsDate implements ReservaValidation
{

    @Override
    public void validate(ReservaRequest request) 
    {
       if(request.checkIn().isEqual(request.checkOut()))
       {
          throw new ResevaValidationException(String.format("%s,%s"
                                                                   ,"Las Fechas son iguales"
                                                                   ,request.currentUri()));
       }   
    }
    
}

@Component
class isBeforeValidCheckOut implements ReservaValidation
{

    @Override
    public void validate(ReservaRequest request) 
    {
        if(request.checkIn().isAfter(request.checkOut()))
        {
            throw new ResevaValidationException(String.format("%s,%s"
                                                                   ,"Fecha de salida está desfasada de la fecha de inicio"
                                                                   ,request.currentUri()));
        }
    }

}
