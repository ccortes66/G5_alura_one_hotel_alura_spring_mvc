package com.alura.hotelalura.springboottres.persitence.repository;

import org.springframework.data.repository.CrudRepository;

import com.alura.hotelalura.springboottres.persitence.entity.EmpleadoEntity;

public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity,String>
{}
