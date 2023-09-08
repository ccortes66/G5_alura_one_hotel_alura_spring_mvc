package com.alura.hotelalura.springboottres.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/operacion")
public class EmpleadoController 
{
    @GetMapping
    public String index(Model model,HttpServletRequest request,HttpSession session)
    {   
        model.addAttribute("user", session.getAttribute("users"));
        return "employer/index";
    }
}
