ALTER TABLE users
ADD role INT NOT NULL;

UPDATE users SET role = 0;