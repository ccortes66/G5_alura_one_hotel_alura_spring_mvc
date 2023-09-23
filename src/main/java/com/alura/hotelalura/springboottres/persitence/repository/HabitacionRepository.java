package com.alura.hotelalura.springboottres.persitence.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alura.hotelalura.springboottres.persitence.entity.HabitacionEntity;


public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Integer> 
{   
    @Query(value = """
                    SELECT H FROM HabitacionEntity H
                    WHERE H.reservado = 0 
                    AND H.habitacionTipo.activo = 1 
                    AND H.habitacionTipo.categoria = :categoria  
                    ORDER BY H.numero LIMIT 1      
          """)
    Optional<HabitacionEntity> findFirstHabitacionAvailable(@Param("categoria") String categoria);
}




