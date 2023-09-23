CREATE TABLE habitacion_tipo_entity
(
    
    categoria VARCHAR(50) NOT NULL,
    percio_unitario DECIMAL(10,2),
    puntos_unitario INT,
    activo TINYINT(1) ,
    PRIMARY KEY(categoria)

);