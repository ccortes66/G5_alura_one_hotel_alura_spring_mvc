package com.alura.hotelalura.springboottres.controller.views;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;
import com.alura.hotelalura.springboottres.controller.responses.ListarReservacionResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaClienteResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaResponses;
import com.alura.hotelalura.springboottres.persitence.dto.reserva.ListarReservacion;
import com.alura.hotelalura.springboottres.service.ClienteService;
import com.alura.hotelalura.springboottres.service.HabitacionService;
import com.alura.hotelalura.springboottres.service.PublicService;
import com.alura.hotelalura.springboottres.service.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController 
{   
    private final PublicService publicService;
    private final ClienteService service;
    private final UserServices userServices;
    private final HabitacionService habitacionService;

    @GetMapping
    public String mainCliente(Model model,HttpServletRequest request,HttpSession session)
    {   
        model.addAttribute("user",session.getAttribute("users"));
        return "index";
    }

    @GetMapping("/listar/reservaciones")
    public String vistaListarConsultas(Model model,HttpSession session)
    {   
        String username = (String) session.getAttribute("users");
        model.addAttribute("resultadoLista", new ListarReservacionResponses(username,
                                                                                          habitacionService.listarReservacionCliente(username)));
        return "index";
    }


    @GetMapping("/consultar/reservacion")
    public String vistaConsultas(Model model,HttpSession session)
    {   
        model.addAttribute("reservaResponses", new ReservaResponses((String) session.getAttribute("users"),
                                                                                publicService.listarPorCategoria(),
                                                                                 null));
        return "consultar";
    }

    @PostMapping("/consultar/reservacion")
    public String realizarConsultas(Model model,HttpServletRequest request,HttpSession session)
    {   

        ReservaResponses reservaResponses = publicService.ConsultarReserva(new ReservaRequest(LocalDate.parse(request.getParameter("checkIn")), 
                                                                                                  LocalDate.parse(request.getParameter("checkOut")), 
                                                                                                  request.getParameter("categoria"),
                                                                                                 "consultar",
                                                                                                 "", 
                                                                                                 (String) session.getAttribute("users")));

        model.addAttribute("reservaResponses", reservaResponses);
        return "consultar";
    }

    @GetMapping("/generar/reservacion")
    public String vistaGenerarReservacion(Model model,HttpSession session)
    {   
        
        model.addAttribute("reservaResponses", new ReservaClienteResponses((String) session.getAttribute("users"),
                                                                                         publicService.listarPorCategoria(),
                                                                                         publicService.listarMetodoPago(),
                                                                                         null));
        
        return "reservas";
    }

    @PostMapping("/generar/reservacion")
    public String generarReservacion(Model model,HttpServletRequest request,HttpSession session)
    {   
        ListarReservacion listarReservacion =  habitacionService.generarReserva(new ReservaRequest(LocalDate.parse(request.getParameter("checkIn")),
                                                                                LocalDate.parse(request.getParameter("checkOut")), 
                                                                                request.getParameter("categoria"), 
                                                                                "reservas", 
                                                                                request.getParameter("metodoPago"),
                                                                                (String) session.getAttribute("users")));

        model.addAttribute("reservaResponses", new ReservaClienteResponses((String) session.getAttribute("users"),
                                                                                         publicService.listarPorCategoria(),
                                                                                         publicService.listarMetodoPago(),
                                                                                         listarReservacion));
        
        return "reservas";
    }











    @GetMapping("/perfil")
    public String vistaPerfil(Model model,HttpSession session)
    {   
        model.addAttribute("listarPerfil", service.myCliente((String) session.getAttribute("users")));
        return "perfil";
    }

    @PostMapping("/perfil")
    public String modificarPerfil(Model model,HttpServletRequest request,HttpSession session)
    {    
        model.addAttribute("listarPerfil", service.ActualizarDatos((String) session.getAttribute("users"), 
                                                                                          request.getParameter("telefono")) );
        return "perfil";
    }

    @GetMapping("/eliminar")
    public String eliminarCliente(HttpSession session)
    {   
        userServices.deleteAllCache("cachingUserName", (String) session.getAttribute("users")); 
        service.eliminarCliente((String) session.getAttribute("users"));
        session.removeAttribute("users");
        return "redirect:/public";
    }
}
