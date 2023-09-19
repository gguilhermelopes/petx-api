CREATE TABLE veterinarians (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    crmv VARCHAR(6) NOT NULL UNIQUE,
    specialization INT NOT NULL,
    street VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);