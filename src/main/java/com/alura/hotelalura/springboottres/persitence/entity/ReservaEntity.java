package com.alura.hotelalura.springboottres.persitence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class ReservaEntity extends ValueSuperEntity
{   
    
   
    @Id
    @Setter(AccessLevel.NONE) 
    private String reservaId = UUID.randomUUID().toString();
    @NonNull
    private LocalDate checkIn;
    @NonNull
    private LocalDate checkOut;
    @NonNull
    private Float valorReserva;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",
                referencedColumnName = "username")
    private ClienteEntity cliente;
    
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo",
               referencedColumnName = "metodo")
    private MetodoEntity metodoPago;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero",
               referencedColumnName = "numero")
    private HabitacionEntity habitacion;
    



}
