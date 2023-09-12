package com.alura.hotelalura.springboottres.persitence.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.hotelalura.springboottres.persitence.entity.HabitacionEntity;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Integer> 
{   
    @Query(value = JPQLValues.FIND_FIRST_HABITACION)
    Optional<HabitacionEntity> findFirstHabitacionAvailable(String categoria);
}


class JPQLValues
{   

    private static final String CONSULTA_BASE 
    = "SELECT H FROM HabitacionEntity H JOIN FETCH H.habitacionTipo HT  ";
       
    public static final String FIND_FIRST_HABITACION
    = CONSULTA_BASE + 
      "WHERE H.reservado = false "+
      "AND HT.activo = true "+
      "AND HT.categoria = :categoria "+
      "ORDER BY H.id LIMIT 1";
}
