package com.alura.hotelalura.springboottres.persitence.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.hotelalura.springboottres.persitence.entity.HabitacionEntity;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Integer> 
{   
    @Query(value = """
                    SELECT H FROM HabitacionEntity H JOIN FETCH H.habitacionTipo HT  
                    WHERE H.reservado = false 
                    AND HT.activo = true 
                    AND HT.categoria = :categoria 
                    ORDER BY H.id LIMIT 1     
          """)
    Optional<HabitacionEntity> findFirstHabitacionAvailable(String categoria);
}




