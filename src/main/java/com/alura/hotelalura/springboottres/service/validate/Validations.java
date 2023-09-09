package com.alura.hotelalura.springboottres.service.validate;


import java.time.LocalDate;
import java.time.Period;


import org.springframework.stereotype.Component;

import com.alura.hotelalura.springboottres.controller.requests.RegisterRequest;


public interface Validations 
{
   void validate(RegisterRequest request);    
}

@Component
class ValidationUserOld implements Validations
{

    @Override
    public void validate(RegisterRequest request) 
    {
        int year = Period.between(request.fechaNacimiento(),LocalDate.now()).getYears();
        if(year<=17)
          {throw new IllegalArgumentException(String.format("%s,%s"
                                                                   ,"Eres menor de edad"
                                                                   ,request.currentUri()));}
    }

}

@Component
class ValidationEqualsPassword implements Validations
{

    @Override
    public void validate(RegisterRequest request) 
    {   String info = null;

        if(!request.password().equals(request.verifyPassword()))
          { info = String.format("%s,%s"
                                    ,"Contraseñas no coinciden"
                                    ,request.currentUri());

          }else if(request.password().length()<8)
          {info = String.format("%s,%s"
                                    ,"Largo Contraseña minima es de 8 caracteres"
                                    ,request.currentUri());

          }
          
          if(info != null)
          {throw new IllegalArgumentException(info);}  
        
        
    }

}

@Component
class ValidationMatchesField implements Validations
{

    @Override
    public void validate(RegisterRequest request) 
    {    
        if (!request.dni().matches("^[0-9A-Za-z]+$") || !request.nombre().matches("^[0-9A-Za-z ]+$") ||
            !request.apellido().matches("^[0-9A-Za-z ]+$") || !request.username().matches("^[0-9A-Za-z]+$"))
            {throw new IllegalArgumentException(String.format("%s,%s"
                                                                   ,"Campos llevan caracteres especiales"
                                                                   ,request.currentUri()));
            }
    }

}







