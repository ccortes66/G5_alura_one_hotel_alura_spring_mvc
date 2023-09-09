package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoCategoria;
import com.alura.hotelalura.springboottres.persitence.entity.HabitacionTipoEntity;

public interface HabitacionTipoRepository extends JpaRepository<HabitacionTipoEntity,String>
{
    List<HabitacionTipoCategoria> findByActivoTrue();
}
