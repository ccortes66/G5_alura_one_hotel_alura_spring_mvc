package com.alura.hotelalura.springboottres.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alura.hotelalura.springboottres.controller.requests.ConsultaCriteriaRequest;
import com.alura.hotelalura.springboottres.persitence.dto.reserva.ConsultaCriteria;
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

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
    private final EntityManager manager;
    
    public List<MostrarReservacion> listarReservacionCliente(String username)
    {
        return reservaRepository.mostrarReservacionCliente(username);
    }
    
    public List<ConsultaCriteria> listaCriteriaCliente(ConsultaCriteriaRequest request)
    {

          CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
          CriteriaQuery<ReservaEntity> query = criteriaBuilder.createQuery(ReservaEntity.class);
          Root<ReservaEntity> root = query.from(ReservaEntity.class);

          List<Predicate> predicate = new ArrayList<>();
          predicate.add(criteriaBuilder.equal(root.get("cliente").get("username"), request.username()));
          predicate.add(
                  criteriaBuilder.equal(root.get("habitacion")
                          .get("habitacionTipo")
                          .get("categoria"),request.categoria().get())

          );

          if(request.checkIn().isPresent())
            {predicate.add(criteriaBuilder.equal(root.get("checkIn"),request.checkIn().get()));}
          if(request.precio().isPresent())
            {predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("valorReserva"),request.precio().get()));}

            Predicate finalPredicate = criteriaBuilder.and(predicate.toArray(new Predicate[0]));
            query.select(root).where(finalPredicate);

          return manager.createQuery(query).setMaxResults(10)
                                           .getResultList()
                                           .stream()
                                           .map(ConsultaCriteria::new)
                                           .toList();
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
