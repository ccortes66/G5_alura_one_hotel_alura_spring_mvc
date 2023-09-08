package com.alura.hotelalura.springboottres.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component
public class CustomFilterSession extends OncePerRequestFilter 
{   
    
    private final UserDetailsService userServices;
    
    @Autowired
    public CustomFilterSession(@Lazy UserDetailsService userServices) {
        this.userServices = userServices;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain)
                                    throws ServletException, IOException 
    {    
        
         Optional<HttpSession> session = Optional.ofNullable(request.getSession());
         session.ifPresent((mySession)->{
            Optional<String> username = Optional.ofNullable((String) mySession.getAttribute("users"));
                     username.ifPresent((data)->{
                           User user = (User) userServices.loadUserByUsername(data);
                           UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                           user.getUsername(), user.getPassword(), user.getAuthorities()
                           );
                           SecurityContextHolder.getContext().setAuthentication(token);
            });
         }); 
                
        filterChain.doFilter(request, response);
              
        
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException 
    {    

        List<String> whileList = Arrays.asList(
            "/empleado","/empleado/registrar",
            "/registrar","/","/empleado/ingreso","/ingreso",
            "/error","/cerrar","/empleado/cerrar"
        );
        Iterator<String> lisIterator = whileList.iterator();
        while(lisIterator.hasNext())
        {   
            if(request.getRequestURI().equals(lisIterator.next()) ||
               request.getRequestURI().startsWith("/img/"))
            {   
                return true;
            }
        }
        return false;
        
    }

    
    
}
