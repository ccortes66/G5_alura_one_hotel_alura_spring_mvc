package com.alura.hotelalura.springboottres.persitence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.hotelalura.springboottres.persitence.dto.reserva.MostrarReservacion;
import com.alura.hotelalura.springboottres.persitence.entity.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity,String> 
{   
    @Query(value = CustomNativeQuery.LISTAR_RESERVACION_CLIENTE, nativeQuery = true)
    List<MostrarReservacion> mostrarReservacionCliente(String username);

    
}


class CustomNativeQuery
{
    public static final String LISTAR_RESERVACION_CLIENTE
    = """
    SELECT re.reserva_id as reservaId, re.check_in as checkIn,
           re.check_out as checkOut, re.valor_reserva as precioHabitacion,
           hte.categoria as categoria, re.numero as numeroHabitacion
    FROM reserva_entity re
    INNER JOIN habitacion_entity he
    ON re.numero = he.numero
    INNER JOIN habitacion_tipo_entity hte
    ON he.habitacion_tipo = hte.categoria
    WHERE re.activo = 1  AND  re.username = :username
    ORDER  BY re.id DESC LIMIT 10
    """;
   
}
