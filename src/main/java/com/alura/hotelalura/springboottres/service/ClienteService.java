package com.alura.hotelalura.springboottres.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.persitence.dto.user.ClienteModel;
import com.alura.hotelalura.springboottres.persitence.entity.ClienteEntity;
import com.alura.hotelalura.springboottres.persitence.repository.ClienteRepository;
import com.alura.hotelalura.springboottres.persitence.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService 
{ 
    private final ClienteRepository repository;
    private final UserRepository userRepository;
   
    public ClienteModel myCliente(String username)
    {
        return new ClienteModel(repository.findById(username).get());
    }
    
    @Transactional
    public ClienteModel ActualizarDatos(String username, String Numero)
    {
        ClienteEntity entity = repository.findById(username).get();
        entity.getUserEntity()
              .getInfoPersonal()
              .setTelefono(Numero);
        return new ClienteModel(entity);
        
    }

    @Transactional
    public void eliminarCliente(String username)
    {
        userRepository.findById(username)
                                   .ifPresent((data) -> {data.setIsDisabled(true);
                                                         data.setLocked(true);});
        
        
    }
    
}
