CREATE TABLE appointments (
    id BIGINT NOT NULL AUTO_INCREMENT,
    veterinarian_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    date_time DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (veterinarian_id) REFERENCES veterinarians(id),
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);