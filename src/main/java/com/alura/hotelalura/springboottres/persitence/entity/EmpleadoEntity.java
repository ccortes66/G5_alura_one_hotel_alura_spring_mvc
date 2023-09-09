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
@NoArgsConstructor
@RequiredArgsConstructor
public class EmpleadoEntity 
{
    @Id
    @Setter(AccessLevel.NONE)
    @NonNull
    private String username;
    @NonNull
    private String cargo;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "username",
                referencedColumnName = "username",
                insertable = false,
                updatable = false
     )
    private UserEntity userEntity;

}
