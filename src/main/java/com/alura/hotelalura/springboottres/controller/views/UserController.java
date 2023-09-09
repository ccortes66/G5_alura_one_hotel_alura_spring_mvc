package com.alura.hotelalura.springboottres.controller.views;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.hotelalura.springboottres.controller.requests.RegisterRequest;

import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;
import com.alura.hotelalura.springboottres.persitence.entity.RoleUser;
import com.alura.hotelalura.springboottres.service.UserServices;
import com.alura.hotelalura.springboottres.service.validate.HCatchaValidation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class UserController 
{   

    private final UserServices userServices;
    private final AuthenticationManager manager;
    private final HCatchaValidation catchaValidation;
    private LoginResponses clienteResponses = new LoginResponses("/public/ingreso",
                                                              "/img/hotelcliente.jpg",
                                                              null,
                                                              "/public/registrar",
                                                              "login");

    private LoginResponses empleadoResponses = new LoginResponses("/public/empleado/ingreso",
                                                                         "/img/hotelempleado.jpg",
                                                                    null,
                                                                "/public/empleado/registrar",
                                                                   "employer/login");
                                    
    @GetMapping
    public String loginCliente(Model model, HttpServletRequest request)
    {  
        model.addAttribute("loginResponse",clienteResponses);
        return "login";
    }

    @GetMapping("/registrar")
    public String vistaFormularioCliente(Model model,HttpServletRequest request)
    {   
        model.addAttribute("response", null);
        return "formulario";
    }


    @GetMapping("/empleado")
    public String loginEmpleado(Model model,HttpServletRequest request)
    {    
        model.addAttribute("loginResponse",empleadoResponses);
        return "employer/login";
    }

    @GetMapping("/empleado/registrar")
    public String vistaFormularioEmpleado(Model model,HttpServletRequest request)
    {   
        model.addAttribute("response", null);
        return "employer/formulario";
    }



    @PostMapping("/registrar")
    public String registroClientes(Model model,HttpServletRequest request) throws IOException
    {   
        RegisterRequest registerRequest = new RegisterRequest(request.getParameter("dni"), 
                                                              request.getParameter("nombre"), 
                                                              request.getParameter("apellido"), 
                                                              LocalDate.parse(request.getParameter("fechaNacimiento")), 
                                                              request.getParameter("username"),
                                                              request.getParameter("password"),
                                                              request.getParameter("password2"),
                                                              "formulario",
                                                              RoleUser.CLIENTE,
                                                              null);  
        
        if(!catchaValidation.validate(request.getParameter("h-captcha-response")))
          {throw new IllegalArgumentException(String.format("%s,%s"
                                                           ,"Captcha invalido"
                                                           ,registerRequest.currentUri()));
          }
        userServices.setLoginResponses(clienteResponses);                                                           
        userServices.registarUsuario(registerRequest);
        model.addAttribute("loginResponse", clienteResponses);
        return "redirect:/public";
    }


    @PostMapping("/empleado/registrar")
    public String registroEmpleado(Model model,HttpServletRequest request) throws IOException
    {   
        
        RegisterRequest registerRequest = new RegisterRequest(request.getParameter("dni"), 
                                                              request.getParameter("nombre"), 
                                                              request.getParameter("apellido"), 
                                                              LocalDate.parse(request.getParameter("fechaNacimiento")), 
                                                              request.getParameter("username"),
                                                              request.getParameter("password"),
                                                              request.getParameter("password2"),
                                                              "employer/formulario",
                                                              RoleUser.EMPLEADO,
                                                              request.getParameter("cargo"));
                                                            
        
        if(!catchaValidation.validate(request.getParameter("h-captcha-response")))
          {throw new IllegalArgumentException(String.format("%s,%s"
                                                           ,"Captcha invalido"
                                                           ,registerRequest.currentUri()));
          } 
        userServices.setLoginResponses(empleadoResponses);   
        userServices.registarUsuario(registerRequest);
        model.addAttribute("loginResponse",empleadoResponses);
        return "redirect:/public/empleado";
    }

    @PostMapping("/ingreso")
    public String ingresarSistemaCliente(Model model, HttpServletRequest request,HttpSession session) throws IOException
    {   

        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( request.getParameter("username"),
                                                                                             request.getParameter("password"));
                                                                                   
        
        if(!catchaValidation.validate(request.getParameter("h-captcha-response")))
          {throw new InternalAuthenticationServiceException(String.format("%s,%s,%s,%s,%s"
                                                                                     ,clienteResponses.linkAction()
                                                                                     ,clienteResponses.img()
                                                                                     ,"Captcha invalido"
                                                                                     ,clienteResponses.linkRegistro()
                                                                                     ,clienteResponses.currentUri()));
          }
        userServices.setLoginResponses(clienteResponses);     
        manager.authenticate(token);
        session.setAttribute("users",request.getParameter("username"));
        model.addAttribute("user", session.getAttribute("users"));
        return "redirect:/cliente";
    }


    @PostMapping("/empleado/ingreso")
    public String ingresarSistemaEmpleado(Model model, HttpServletRequest request,HttpSession session) throws IOException
    {   
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken( request.getParameter("username"),
                                                                                             request.getParameter("password"));
        
        if(!catchaValidation.validate(request.getParameter("h-captcha-response")))
          {throw new InternalAuthenticationServiceException(String.format("%s,%s,%s,%s,%s"
                                                                                     ,empleadoResponses.linkAction()
                                                                                     ,empleadoResponses.img()
                                                                                     ,"Captcha invalido"
                                                                                     ,empleadoResponses.linkRegistro()
                                                                                     ,empleadoResponses.currentUri()));
          }                                                                                     
        userServices.setLoginResponses(empleadoResponses);   
        manager.authenticate(token);
        session.setAttribute("users",request.getParameter("username"));
        model.addAttribute("user", session.getAttribute("users"));
        return "redirect:/operacion";
    }

    @GetMapping("/cerrar")
    public String cerrarSession(HttpSession session)
    {  
        session.removeAttribute("users");
        return "redirect:/public";
    }

    @GetMapping("/empleado/cerrar")
    public String cerrarSessionEmpleado(HttpSession session)
    {  
        session.removeAttribute("users");
        return "redirect:/public/empleado";
    }

    


}
