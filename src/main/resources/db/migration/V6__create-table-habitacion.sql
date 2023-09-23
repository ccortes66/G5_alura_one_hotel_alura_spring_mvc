CREATE TABLE habitacion_entity
(
    
    numero INT NOT NULL,
    reservado TINYINT(1) ,
    habitacion_tipo VARCHAR(50) NOT NULL,
    activo TINYINT(1) ,
    PRIMARY KEY(numero)

);