package com.alura.hotelalura.springboottres.service;


import java.util.Optional;

import org.springframework.stereotype.Service;


import com.alura.hotelalura.springboottres.persitence.dto.habitacion.HabitacionModel;
import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoModel;
import com.alura.hotelalura.springboottres.persitence.entity.HabitacionEntity;
import com.alura.hotelalura.springboottres.persitence.entity.HabitacionTipoEntity;
import com.alura.hotelalura.springboottres.persitence.entity.MetodoEntity;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionRepository;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionTipoRepository;
import com.alura.hotelalura.springboottres.persitence.repository.MetodoRepository;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitacionService 
{
    private final MetodoRepository metodoRepository;
    private final HabitacionTipoRepository habitacionTipoRepository;
    private final HabitacionRepository habitacionRepository;
   
     
    @Transactional
    public Optional<MetodoEntity> generarMetodoDePago(String metodo)
    {   
        if(metodoRepository.findById(metodo).isEmpty())
          {return Optional.ofNullable(metodoRepository.save(new MetodoEntity(metodo)));}
        return Optional.empty();
        
    }

    @Transactional
    public Optional<HabitacionTipoEntity> generarHabitacionTipo(HabitacionTipoModel model)
    {   
        if(habitacionTipoRepository.findById(model.categoria()).isEmpty())
          {return Optional.of(habitacionTipoRepository.save(new HabitacionTipoEntity(model)));}
        return Optional.empty();
    }

    @Transactional
    public Optional<HabitacionEntity> generarHabitacion(HabitacionModel model)
    {   
       if(habitacionRepository.findById(model.numero()).isEmpty())
       {
            return Optional.ofNullable(habitacionRepository.save(new HabitacionEntity(model.numero(),
                                                            habitacionTipoRepository.findById(model.habitacion_tipo()).get()
                                                            )
                                        ));
       }
       return Optional.empty();                        
    }




}
