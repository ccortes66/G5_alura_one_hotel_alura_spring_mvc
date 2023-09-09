package com.alura.hotelalura.springboottres.service;

import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.persitence.entity.EmpleadoEntity;
import com.alura.hotelalura.springboottres.persitence.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoService 
{ 
    private final EmpleadoRepository repository;
   

    public EmpleadoEntity myEmpleado(String username)
    {
        return repository.findById(username).get();
    }
    
    @Transactional
    public EmpleadoEntity ActualizarDatos(String username, String Numero)
    {
        EmpleadoEntity entity = this.myEmpleado(username);
        entity.getUserEntity()
              .getInfoPersonal()
              .setTelefono(Numero);
        return entity;
    }
    
}
