package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.alura.hotelalura.springboottres.persitence.entity.HabitacionTipoEntity;

public interface HabitacionTipoRepository extends JpaRepository<HabitacionTipoEntity,String>
{   
    @Query(value = JPQLValues.FIND_BY_ACTIVOS)
    List<String> findByActivoTrue();
  
}


class JPQLValues
{   
    private static final String CONSULTA_BASE 
    = "SELECT ht.categoria "+
      "FROM HabitacionTipoEntity ht ";
     
    public static final String FIND_BY_ACTIVOS
    = CONSULTA_BASE + "WHERE ht.activo = true ";



}
