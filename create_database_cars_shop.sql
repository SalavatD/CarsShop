CREATE DATABASE cars_shop;

USE cars_shop;

CREATE TABLE marks (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mark VARCHAR(32)
);
CREATE UNIQUE INDEX mark ON marks (mark);

CREATE TABLE cars (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mark_id INT NOT NULL,
    model VARCHAR(32) NOT NULL,
    price INT NOT NULL,
    CONSTRAINT cars_ibfk_1 FOREIGN KEY (mark_id)
        REFERENCES marks (id)
);
CREATE INDEX mark_id ON cars (mark_id);

CREATE TABLE clients (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    age INT,
    phone VARCHAR(16)
);

CREATE TABLE orders (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    car_id INT NOT NULL,
    client_id INT NOT NULL,
    CONSTRAINT orders_ibfk_1 FOREIGN KEY (car_id)
        REFERENCES cars (id),
    CONSTRAINT orders_ibfk_2 FOREIGN KEY (client_id)
        REFERENCES clients (id)
);
CREATE INDEX car_id ON orders (car_id);
CREATE INDEX client_id ON orders (client_id);
