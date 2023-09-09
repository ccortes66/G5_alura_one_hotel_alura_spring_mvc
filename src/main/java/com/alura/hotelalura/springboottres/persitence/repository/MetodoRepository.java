package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.alura.hotelalura.springboottres.persitence.dto.metodo.MetodoListar;
import com.alura.hotelalura.springboottres.persitence.entity.MetodoEntity;

public interface MetodoRepository extends CrudRepository<MetodoEntity,String>
{
    List<MetodoListar> findByActivoTrue();
}
