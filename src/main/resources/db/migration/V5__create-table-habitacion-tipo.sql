CREATE TABLE habitacion_tipo_entity
(
    id SERIAL,
    categoria VARCHAR(50) NOT NULL,
    percio_unitario DECIMAL(10,2),
    puntos_unitario INT,
    activo TINYINT(1) UNSIGNED,
    PRIMARY KEY(categoria)

);