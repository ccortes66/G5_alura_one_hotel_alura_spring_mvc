CREATE TABLE empleado_entity
(
    id SERIAL,
    username  VARCHAR(50) NOT NULL,
    cargo VARCHAR(100),
    PRIMARY KEY(username)

);