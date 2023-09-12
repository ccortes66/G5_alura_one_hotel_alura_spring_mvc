package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.alura.hotelalura.springboottres.persitence.entity.MetodoEntity;

public interface MetodoRepository extends CrudRepository<MetodoEntity,String>
{   
    @Query(value = JPQLValues.FIND_BY_METODOS)
    List<String> buscarMetodoPagos();
}

class JPQLValues
{
    public static final String FIND_BY_METODOS
    = "SELECT M.metodo "+
      "FROM MetodoEntity " + 
      "M WHERE M.activo = true";
}



