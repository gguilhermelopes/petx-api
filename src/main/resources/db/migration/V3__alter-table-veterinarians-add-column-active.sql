ALTER TABLE veterinarians
ADD active tinyint;

UPDATE veterinarians SET active = 1;

