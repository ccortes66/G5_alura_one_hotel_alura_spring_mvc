package com.alura.hotelalura.springboottres.service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;



import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;
import com.alura.hotelalura.springboottres.controller.responses.ConsultarResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaResponses;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionTipoRepository;
import com.alura.hotelalura.springboottres.persitence.repository.MetodoRepository;
import com.alura.hotelalura.springboottres.service.validate.ReservaValidation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicService 
{

    private final HabitacionTipoRepository habitacionTipoRepository;
    private final List<ReservaValidation> reservaValidation;
    private final MetodoRepository metodoRepository;
  
     
    @Cacheable("listarPorCategoria")
    public List<String> listarPorCategoria()
    {   
        return habitacionTipoRepository.findByActivoTrue();
    }

    public ReservaResponses ConsultarReserva (ReservaRequest request)
    { 
       reservaValidation.forEach((validar) -> validar.validate(request));
       BigDecimal precioUnitario = habitacionTipoRepository.findById(request.categoria())
                                                                                       .get()
                                                                                       .getPercioUnitario();
          
       Long dias = ChronoUnit.DAYS.between(request.checkIn(), request.checkOut());
       return new ReservaResponses(request.username(), 
                                   this.listarPorCategoria(), 
                                   new ConsultarResponses(request.checkIn(), 
                                                          request.checkOut(), 
                                                          request.categoria(), 
                                                          precioUnitario.multiply(new BigDecimal(dias))
                                                          ));
    }
    
    @Cacheable("listarMetodoPago")
    public List<String> listarMetodoPago()
    {
      return metodoRepository.buscarMetodoPagos();
    }

}
