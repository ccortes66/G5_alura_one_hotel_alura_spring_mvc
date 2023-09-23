package com.alura.hotelalura.springboottres.persitence.dto.reserva;


import com.alura.hotelalura.springboottres.persitence.entity.ReservaEntity;

public record ListarReservacion(
    String reservaId,
    Integer habitacion,
    Float precio
) 
{
    public ListarReservacion(ReservaEntity entity)
    {
        this(entity.getReservaId(),
             entity.getHabitacion().getNumero(),
             entity.getHabitacion().getHabitacionTipo().getPercioUnitario());
    }
}
