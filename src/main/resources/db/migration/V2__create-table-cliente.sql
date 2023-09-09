CREATE TABLE cliente_entity
(
    id SERIAL,
    username  VARCHAR(50) NOT NULL,
    puntos INT UNSIGNED,
    vip TINYINT(2) UNSIGNED,
    nacionalida VARCHAR(100),
    PRIMARY KEY(username)

);