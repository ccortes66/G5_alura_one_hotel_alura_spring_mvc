package com.alura.hotelalura.springboottres.service;


import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;
import com.alura.hotelalura.springboottres.controller.responses.ListarReservacionResponses;
import com.alura.hotelalura.springboottres.persitence.dto.habitacion.HabitacionModel;
import com.alura.hotelalura.springboottres.persitence.dto.habitacion_tipo.HabitacionTipoModel;
import com.alura.hotelalura.springboottres.persitence.dto.reserva.ListarReservacion;
import com.alura.hotelalura.springboottres.persitence.dto.reserva.MostrarReservacion;
import com.alura.hotelalura.springboottres.persitence.entity.ClienteEntity;
import com.alura.hotelalura.springboottres.persitence.entity.HabitacionEntity;
import com.alura.hotelalura.springboottres.persitence.entity.HabitacionTipoEntity;
import com.alura.hotelalura.springboottres.persitence.entity.MetodoEntity;
import com.alura.hotelalura.springboottres.persitence.entity.ReservaEntity;
import com.alura.hotelalura.springboottres.persitence.repository.ClienteRepository;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionRepository;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionTipoRepository;
import com.alura.hotelalura.springboottres.persitence.repository.MetodoRepository;
import com.alura.hotelalura.springboottres.persitence.repository.ReservaRepository;
import com.alura.hotelalura.springboottres.service.validate.ReservaValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitacionService 
{
    private final MetodoRepository metodoRepository;
    private final HabitacionTipoRepository habitacionTipoRepository;
    private final HabitacionRepository habitacionRepository;
    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;
    private final List<ReservaValidation> reservaValidation;
    
    public List<MostrarReservacion> listarReservacionCliente(String username)
    {
      return reservaRepository.mostrarReservacionCliente(username);
    }
   

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

    @Transactional
    public ListarReservacion generarReserva(ReservaRequest request)
    {   
       reservaValidation.forEach((validar)-> validar.validate(request));
        
      
       ReservaEntity reserva = new ReservaEntity(request.checkIn(),
                                                 request.checkOut(),
                                                 this.calcularPrecioHabitacion(request),
                                                 metodoRepository.findById(request.metodoPago()).get());

                                             
       ClienteEntity cliente = clienteRepository.findById(request.username()).get();
       HabitacionEntity habitacionAsignada =  habitacionRepository.findFirstHabitacionAvailable(request.categoria()).get();
       
       //puntos   
       cliente.setPuntos(this.agregarPuntos(cliente.getPuntos(), habitacionAsignada.getHabitacionTipo().getPuntosUnitario()));
       //reservando habitacion
       habitacionAsignada.setReservado(true);

       //agregando valores
       reserva.setHabitacion(habitacionAsignada);
       reserva.setCliente(cliente);
       
       
       return new ListarReservacion(reservaRepository.save(reserva));                        
    }


    private Integer agregarPuntos(Integer puntosCliente,Integer puntosHabitacionTipo)
    {return puntosCliente += puntosHabitacionTipo;
    }

    private Integer quitarPuntos(Integer puntosCliente,Integer puntosHabitacionTipo)
    {return puntosCliente -= puntosHabitacionTipo;
    }

    private BigDecimal calcularPrecioHabitacion(ReservaRequest request)
    {
      BigDecimal precioHabitacion = habitacionTipoRepository.findById(request.categoria())
                                                                                      .get()
                                                                                      .getPercioUnitario();


      Long diasHospedaje = ChronoUnit.DAYS.between(request.checkIn(), request.checkOut());
      return precioHabitacion.multiply(new BigDecimal(diasHospedaje));
    }




}
