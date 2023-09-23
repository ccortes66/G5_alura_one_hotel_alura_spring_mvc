package com.alura.hotelalura.springboottres.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityWeb 
{   
   private final CustomFilterSession filter;
   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception
    {
        security
             .csrf(AbstractHttpConfigurer::disable)
             .httpBasic(AbstractHttpConfigurer::disable)
             .authorizeHttpRequests(request -> request
                                                    .requestMatchers("/public/**").permitAll()
                                                    .requestMatchers("/img/**").permitAll()
                                                    .requestMatchers(HttpMethod.GET,"/cliente/**").hasRole("CLIENTE")
                                                    .requestMatchers(HttpMethod.GET,"/operacion/**").hasRole("EMPLEADO")
                                                    .anyRequest()
                                                    .authenticated())  
             .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
             .formLogin(login -> login.loginPage("/public").permitAll());
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public ObjectMapper mapper()
    {
        return new ObjectMapper();
    }

   

    
}
