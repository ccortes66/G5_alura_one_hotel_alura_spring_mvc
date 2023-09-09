package com.alura.hotelalura.springboottres.persitence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ClienteEntity 
{
    @Id
    @Setter(AccessLevel.NONE)
    @NonNull
    private String username;
    private Integer puntos = 0;
    private Byte vip = 0;
    private String nacionalida;
     

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "username",
        referencedColumnName = "username",
        insertable = false,
        updatable = false
    )
    private UserEntity userEntity;

}
