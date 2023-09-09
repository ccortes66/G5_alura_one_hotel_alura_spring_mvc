CREATE TABLE metodo_entity
(
    id SERIAL,
    metodo VARCHAR(50) NOT NULL,
    activo TINYINT(1) UNSIGNED,
    PRIMARY KEY(metodo)

);