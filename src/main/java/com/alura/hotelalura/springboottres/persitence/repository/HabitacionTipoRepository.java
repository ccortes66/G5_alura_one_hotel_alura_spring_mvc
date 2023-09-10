package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.hotelalura.springboottres.persitence.entity.HabitacionTipoEntity;

public interface HabitacionTipoRepository extends JpaRepository<HabitacionTipoEntity,String>
{   
    @Query(value = "SELECT ht.categoria FROM HabitacionTipoEntity ht")
    List<String> findByActivoTrue();
}
