package com.alura.hotelalura.springboottres.persitence.dto.reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MostrarReservacion 
{
   String getReservaId();
   LocalDate getCheckIn();
   LocalDate getCheckOut();
   BigDecimal getPrecioHabitacion();
   String getCategoria();
   Integer getNumeroHabitacion();

}
