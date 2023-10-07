package com.alura.hotelalura.springboottres.service;

import java.util.List;
import java.util.Optional;


import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.controller.requests.RegisterRequest;
import com.alura.hotelalura.springboottres.controller.responses.LoginResponses;
import com.alura.hotelalura.springboottres.persitence.dto.user.UserModel;
import com.alura.hotelalura.springboottres.persitence.entity.ClienteEntity;
import com.alura.hotelalura.springboottres.persitence.entity.EmpleadoEntity;
import com.alura.hotelalura.springboottres.persitence.entity.RoleUser;
import com.alura.hotelalura.springboottres.persitence.entity.UserEntity;
import com.alura.hotelalura.springboottres.persitence.repository.UserRepository;
import com.alura.hotelalura.springboottres.service.validate.Validations;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
public class UserServices implements UserDetailsService
{
    private final List<Validations> validations;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final EntityManager manager;
   
    @Setter
    private LoginResponses loginResponses;
    

    @Transactional
    public void registarUsuario(RegisterRequest request)
    { 
      validations.forEach((data) -> data.validate(request));

      Optional<UserEntity> users = repository.findById(request.username());
      users.ifPresentOrElse(
                 (data) -> {
                     throw new InternalAuthenticationServiceException(String.format("%s,%s,%s,%s,%s"
                                                                                                ,loginResponses.linkAction()
                                                                                                ,loginResponses.img()
                                                                                                ,"Usuario Ya Registrado"
                                                                                                ,loginResponses.linkRegistro()
                                                                                                ,loginResponses.currentUri())); 
                 },
                 () -> {
                      UserEntity uEntity = new UserEntity(new UserModel(request));
                      uEntity.setPassword(passwordEncoder.encode(request.password()));
                      repository.save(uEntity);
                      if(request.roleUser().equals(RoleUser.CLIENTE))
                        {manager.persist(new ClienteEntity(uEntity.getUsername(),request.nacionalidad()));}
                      else
                        {manager.persist(new EmpleadoEntity(uEntity.getUsername(),request.CargoEmpleado()));}                      
                 }
      );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {   
                                                   
        UserEntity users = repository.findById(username).orElseThrow(() -> new InternalAuthenticationServiceException(String.format("%s,%s,%s,%s,%s"
                                                                                                                                                    ,loginResponses.linkAction()
                                                                                                                                                    ,loginResponses.img()
                                                                                                                                                    ,"Usuario o Contraseña invalida"
                                                                                                                                                    ,loginResponses.linkRegistro()
                                                                                                                                                    ,loginResponses.currentUri())));
        if(users.getLocked() == 1)
          {throw new LockedException(String.format("%s,%s,%s,%s,%s"
                                                                  ,loginResponses.linkAction()
                                                                  ,loginResponses.img()
                                                                  ,"Usuario o Contraseña invalida"
                                                                  ,loginResponses.linkRegistro()
                                                                  ,loginResponses.currentUri()));}
                                                                                                                                         
        User userss = (User) User.builder()
                             .username(users.getUsername())
                             .password(users.getPassword())
                             .roles(users.getRoles().toString())
                             .accountLocked(false)
                             .disabled(false)
                             .accountExpired(false)
                             .build();                                                                                                                                     
        return userss;
    }

   
    
}
