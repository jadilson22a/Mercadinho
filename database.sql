CREATE DATABASE IF NOT EXISTS mercadinho;

USE mercadinho;

CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade DOUBLE,
    um ENUM('m', 'mm', 'm2', 'm3', 'l', 'g', 'kg', 'mil', 'un') NOT NULL
);