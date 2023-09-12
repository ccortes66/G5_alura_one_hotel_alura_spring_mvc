CREATE TABLE reserva_entity
(
    id SERIAL,
    reserva_id VARCHAR(255) NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    valor_reserva DECIMAL(10,2),
    username VARCHAR(50) NOT NULL,         
    metodo VARCHAR(50) NOT NULL,
    numero  INT NOT NULL ,
    activo TINYINT(1) UNSIGNED,
    PRIMARY KEY(reserva_id),
    INDEX(reserva_id)

);