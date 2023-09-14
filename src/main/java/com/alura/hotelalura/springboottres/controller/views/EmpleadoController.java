package com.alura.hotelalura.springboottres.controller.views;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;
import com.alura.hotelalura.springboottres.controller.responses.BuscarClienteResponses;
import com.alura.hotelalura.springboottres.controller.responses.BuscarResponses;
import com.alura.hotelalura.springboottres.controller.responses.CreacionResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaResponses;
import com.alura.hotelalura.springboottres.persitence.dto.habitacion.HabitacionModel;
import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoModel;
import com.alura.hotelalura.springboottres.service.EmpleadoService;
import com.alura.hotelalura.springboottres.service.HabitacionService;
import com.alura.hotelalura.springboottres.service.PublicService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/operacion")
@RequiredArgsConstructor
public class EmpleadoController 
{   
    private final EmpleadoService service;
    private final HabitacionService habitacionService;
    private final PublicService publicService;
    private Boolean[] confirmaciones;
    private int paginas;
    
    @GetMapping
    public String index(Model model,HttpServletRequest request,HttpSession session)
    {  
     
        if(request.getParameter("pagina") == null || 
          Integer.valueOf(request.getParameter("pagina")) <0)
          {paginas = 0;}
        else
          {paginas = Integer.valueOf(request.getParameter("pagina"));}

        model.addAttribute("buscarResponses",new BuscarResponses((String) session.getAttribute("users"),
                                                                               habitacionService.listaReservaActual(paginas)));
       
        return "employer/index";
    }
    
    @GetMapping("/generar/pagos")
    public String vistaMetodoDePago(Model model,HttpSession session)
    {   
        model.addAttribute("responses", new CreacionResponses((String) session.getAttribute("users"),
                                                                            new Boolean[] {false},
                                                                            null ));
        return "employer/pagos";
    }
    
    @PostMapping("/generar/pagos")
    public String crearMetodoDePago(Model model,HttpServletRequest request,HttpSession session)
    {   
        habitacionService.generarMetodoDePago(request.getParameter("nombre").trim())
                                             .ifPresentOrElse((data) -> {confirmaciones = new Boolean[] {true};},
                                                              () -> {confirmaciones = new Boolean[] {false};});
        model.addAttribute("responses", new CreacionResponses((String) session.getAttribute("users"),
                                                                            confirmaciones,
                                                                            null));
        return "employer/pagos";
    }
    
    @GetMapping("/generar/Habitacion")
    public String vistaHabitacion(Model model,HttpSession session)
    {   
        model.addAttribute("responses", new CreacionResponses((String) session.getAttribute("users"),
                                                                            new Boolean[] {false,false},
                                                                            publicService.listarPorCategoria()));
        return "employer/habitacion";
    }

    @PostMapping("/generar/Habitacion/tipo")
    public String generarTipoHabitacion(Model model,HttpServletRequest request,HttpSession session)
    {   

        habitacionService.generarHabitacionTipo(new HabitacionTipoModel(request.getParameter("categoria"),
                                                                        new BigDecimal(request.getParameter("precioUnitario")),  
                                                                        Integer.valueOf(request.getParameter("puntoUnitario")))
        
        ).ifPresentOrElse((data) -> {confirmaciones = new Boolean[] {true,false};},
                          () -> {confirmaciones = new Boolean[] {false,false};});

        model.addAttribute("responses", new CreacionResponses((String) session.getAttribute("users"),
                                                                             confirmaciones,
                                                                             publicService.listarPorCategoria()));
        return "employer/habitacion";
    }

    @PostMapping("/generar/Habitacion")
    public String generarHabitacion(Model model,HttpServletRequest request,HttpSession session)
    {   

        habitacionService.generarHabitacion(new HabitacionModel(Integer.valueOf(request.getParameter("numero")), 
                                                                request.getParameter("categoria"))
                                                                        
        
        ).ifPresentOrElse((data) -> {confirmaciones = new Boolean[] {false,true};},
                          () -> {confirmaciones = new Boolean[] {false,false};});

        model.addAttribute("responses", new CreacionResponses((String) session.getAttribute("users"),
                                                                            confirmaciones,
                                                                            publicService.listarPorCategoria()));
        return "employer/habitacion";
    }


    @GetMapping("/consultar/reservacion")
    public String vistaConsultas(Model model,HttpSession session)
    {   
        model.addAttribute("reservaResponses", new ReservaResponses((String) session.getAttribute("users"),
                                                                                publicService.listarPorCategoria(),
                                                                                 null));
        return "employer/consultar";
    }

    @PostMapping("/consultar/reservacion")
    public String realizarConsultas(Model model,HttpServletRequest request,HttpSession session)
    {   

        ReservaResponses reservaResponses = publicService.ConsultarReserva(new ReservaRequest(LocalDate.parse(request.getParameter("checkIn")), 
                                                                                              LocalDate.parse(request.getParameter("checkOut")), 
                                                                                              request.getParameter("categoria"),
                                                                                            "employer/consultar", 
                                                                                                "",
                                                                                                (String) session.getAttribute("users")));

        model.addAttribute("reservaResponses", reservaResponses);
        return "employer/consultar";
    }
  


    @GetMapping("/buscar/reservacion")
    public String vistaBuscar(Model model,HttpSession session)
    {
        model.addAttribute("buscarResponses",new BuscarResponses((String) session.getAttribute("users"),
                                                                   null));
        return "employer/buscar";
    }

    


    @GetMapping("/perfil")
    public String vistaPerfil(Model model,HttpSession session)
    {   
        model.addAttribute("listarPerfil", service.myEmpleado((String) session.getAttribute("users")));
        return "employer/perfil";
    }

    @PostMapping("/perfil")
    public String modificarPerfil(Model model,HttpServletRequest request,HttpSession session)
    {    
        model.addAttribute("listarPerfil", service.ActualizarDatos((String) session.getAttribute("users"), 
                                                                                          request.getParameter("telefono")) );
        return "employer/perfil";
    }
}
