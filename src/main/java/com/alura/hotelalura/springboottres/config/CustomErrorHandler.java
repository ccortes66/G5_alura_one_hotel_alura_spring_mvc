package com.alura.hotelalura.springboottres.config;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alura.hotelalura.springboottres.config.CustomException.ResevaValidationException;
import com.alura.hotelalura.springboottres.controller.responses.ErrorResponses;
import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaClienteResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaResponses;
import com.alura.hotelalura.springboottres.service.PublicService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@ControllerAdvice
@RequiredArgsConstructor
public class CustomErrorHandler 
{   
    private final PublicService service;


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
        System.out.println(ex.getMessage());
        String[] args = ex.getMessage().split(","); 
        model.addAttribute("loginResponse", new LoginResponses(args[0]
                                                                            ,args[1]
                                                                            ,new ErrorResponses("400",args[2])
                                                                            ,args[3]
                                                                            ,args[4]));

        return args[4];
    }

    @ExceptionHandler(ResevaValidationException.class)
    public String onValidationReservaError400(Model model,
                                              HttpServletRequest request,
                                              ResevaValidationException ex,
                                              HttpSession session)
    {   
       String[] args = ex.getMessage().split(","); 
       model.addAttribute("response", new ErrorResponses("400", args[0]));
       
       if(!request.getRequestURI().startsWith("/cliente/generar"))
          {model.addAttribute("reservaResponses", new ReservaResponses((String) session.getAttribute("users"),
                                                                                      service.listarPorCategoria(),
                                                                                 null));
          }
        else
          {model.addAttribute("reservaResponses", new ReservaClienteResponses((String) session.getAttribute("users"),
                                                                                            service.listarPorCategoria(),
                                                                                            service.listarMetodoPago(),
                                                                                 null));

          }                                                                       
       return args[1];  
    }

    @ExceptionHandler(LockedException.class)
    public String onLockedUserError400(Model model,LockedException ex, HttpSession session)
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


