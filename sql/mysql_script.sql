CREATE SCHEMA IF NOT EXISTS periodicals DEFAULT CHARACTER SET utf8;

USE
periodicals;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS accounts;

DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS publications;

DROP TABLE IF EXISTS users_publications;

CREATE TABLE roles
(
    role_id   INT         NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(10) NOT NULL UNIQUE,
    PRIMARY KEY (role_id)
);

CREATE TABLE users
(
    user_id    INT          NOT NULL AUTO_INCREMENT,
    role_id    INT          NOT NULL DEFAULT 2,
    first_name VARCHAR(45)  NOT NULL,
    last_name  VARCHAR(45)  NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(45)  NOT NULL,
    is_lock    TINYINT NULL DEFAULT 0,
    PRIMARY KEY (user_id),
    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id) REFERENCES roles (role_id)
            ON UPDATE RESTRICT
            ON DELETE RESTRICT
);

CREATE TABLE accounts
(
    account_id INT     NOT NULL AUTO_INCREMENT,
    amount     DECIMAL NOT NULL DEFAULT 0,
    id_user    INT     NOT NULL,
    PRIMARY KEY (account_id)
);

CREATE TABLE publications
(
    publication_id INT         NOT NULL AUTO_INCREMENT,
    name           VARCHAR(45) NOT NULL,
    theme          VARCHAR(45) NOT NULL,
    price          DECIMAL     NOT NULL DEFAULT 0,
    PRIMARY KEY (publication_id)
);

CREATE TABLE users_publications
(
    id             INT NOT NULL AUTO_INCREMENT,
    id_user        INT NOT NULL,
    id_publication INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO roles(role_id, role_name)
VALUES (1, 'admin'),
       (2, 'user');

INSERT INTO users(role_id, first_name, last_name, email, password, is_lock)
VALUES (1, 'Harry', 'Johnson', 'admin@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', false),
       (2, 'Olivia', 'Smith', 'user1@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', false),
       (2, 'Amelia', 'Brown', 'user2@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', true);

INSERT INTO accounts(amount, id_user)
VALUES (0, 1),
       (5000, 2),
       (8000, 3);

INSERT INTO publications(name, theme, price)
VALUES ('Politico', 'Politics', 280),
       ('The New York Times', 'News', 190),
       ('Financial Times', 'Economics', 200),
       ('The Daily Mail', 'News', 230),
       ('The Hollywood Reporter', 'News', 190),
       ('The Economist', 'Economics', 210),
       ('Bild', 'Economics', 270),
       ('El Mundo', 'Politics', 215),
       ('Condé Nast Traveler', 'Travel', 250);

INSERT INTO users_publications(id_user, id_publication)
VALUES (2, 2),
       (2, 3),
       (2, 1),
       (3, 1);
