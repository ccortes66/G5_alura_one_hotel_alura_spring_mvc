package com.alura.hotelalura.springboottres.persitence.dto.reserva;

import com.alura.hotelalura.springboottres.persitence.entity.ReservaEntity;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public record ConsultaCriteria(
        String reservaId,
        String checkIn,
        String checOut,
        BigDecimal precio,
        String categoria,
        Integer numeroDeHabitacion

)
{
   public ConsultaCriteria(ReservaEntity reservacion)
   {
       this(reservacion.getReservaId(),
            reservacion.getCheckIn().format(DateTimeFormatter.ISO_DATE),
            reservacion.getCheckOut().format(DateTimeFormatter.ISO_DATE),
            reservacion.getValorReserva(),
            reservacion.getHabitacion().getHabitacionTipo().getCategoria(),
            reservacion.getHabitacion().getNumero());
   }
}
