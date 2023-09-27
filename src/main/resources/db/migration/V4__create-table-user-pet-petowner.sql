CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pet_owners (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    species INT NOT NULL,
    age INT,
    breed VARCHAR(100),
    weight BIGINT NOT NULL,
    pet_owner_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pet_owner_id) REFERENCES pet_owners(id)
);