CREATE TABLE habitacion_entity
(
    id SERIAL,
    numero INT NOT NULL,
    reservado TINYINT(1) UNSIGNED,
    habitacion_tipo VARCHAR(50) NOT NULL,
    activo TINYINT(1) UNSIGNED,
    PRIMARY KEY(numero)

);