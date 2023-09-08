CREATE TABLE user_entity
(
    id SERIAL,
    documento VARCHAR(20) NOT NULL,
    username  VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    locked TINYINT(1) UNSIGNED DEFAULT 0,
    is_disabled TINYINT(1) UNSIGNED DEFAULT 0,
    roles VARCHAR(100),
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(20),
    PRIMARY KEY(documento),
    UNIQUE(username)

);