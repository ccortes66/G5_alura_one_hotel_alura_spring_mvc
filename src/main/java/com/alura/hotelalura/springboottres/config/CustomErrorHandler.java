package com.alura.hotelalura.springboottres.config;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alura.hotelalura.springboottres.controller.responses.ErrorResponses;
import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;


@ControllerAdvice
public class CustomErrorHandler 
{   
    @ExceptionHandler(RuntimeException.class)
    public String error404(Model model)
    {   
        model.addAttribute("loginResponse", new LoginResponses("/ingreso",
                                                                                     "/img/hotelcliente.jpg",
                                                                                null,
                                                                            "/registrar",
                                                                                 "login"));
        return "login";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String error400(Model model,IllegalArgumentException ex)
    {   
       String[] args = ex.getMessage().split(","); 
       model.addAttribute("response", new ErrorResponses("400", args[0]));
       return args[1];  
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public String authenticationError400(Model model,InternalAuthenticationServiceException ex)
    {
        String[] args = ex.getMessage().split(","); 
        model.addAttribute("loginResponse", new LoginResponses(args[0]
                                                                            ,args[1]
                                                                            ,new ErrorResponses("400",args[2])
                                                                            ,args[3]
                                                                            ,args[4]));
        return args[4];
    }
}
