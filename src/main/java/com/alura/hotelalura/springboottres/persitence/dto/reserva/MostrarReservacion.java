package com.alura.hotelalura.springboottres.persitence.dto.reserva;


import java.time.LocalDate;

public interface MostrarReservacion 
{
   String getReservaId();
   LocalDate getCheckIn();
   LocalDate getCheckOut();
   Float getPrecioHabitacion();
   String getCategoria();
   Integer getNumeroHabitacion();

}
