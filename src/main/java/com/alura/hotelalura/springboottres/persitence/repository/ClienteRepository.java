package com.alura.hotelalura.springboottres.persitence.repository;

import org.springframework.data.repository.CrudRepository;

import com.alura.hotelalura.springboottres.persitence.entity.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity,String>
{
    
}
