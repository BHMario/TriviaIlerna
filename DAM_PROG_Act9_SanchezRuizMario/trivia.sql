-- COMANDO PARA BORRAR LA BASE DE DATOS EN CASO DE QUE EXISTA --
DROP DATABASE IF EXISTS trivia;

-- COMANDO PARA CREAR LA BASE DE DATOS EN CASO DE QUE NO EXISTA --
CREATE DATABASE IF NOT EXISTS trivia;

-- COMANDO PARA USAR LA BASE DE DATOS --
USE trivia;

CREATE TABLE Usuario (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	nombre_usuario VARCHAR (220) NOT NULL,
	contrasena VARCHAR (20) NOT NULL,
	tipo VARCHAR (10) NOT NULL
);

CREATE TABLE Pregunta (
	id_pregunta INT AUTO_INCREMENT PRIMARY KEY,
    enunciado VARCHAR (220),
    categoria VARCHAR (220),
    dificultad VARCHAR (220)
);

CREATE TABLE Respuesta (
	id_respuesta INT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta INT,
    texto VARCHAR (220),
    esCorrecta BOOLEAN,
    FOREIGN KEY (id_pregunta) REFERENCES Pregunta(id_pregunta)
);

CREATE TABLE Partida (
	id_partida INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha DATE,
    puntuaje INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);


INSERT INTO Usuario (nombre_usuario, contrasena, tipo) VALUES
("usuario1", "IlernaSevilla", "normal"),
("admin", "AdminIlerna", "admin");

INSERT INTO Pregunta (enunciado, categoria, dificultad) VALUES
(),
(),
(),
();

INSERT INTO Respuesta (texto, esCorrecta) VALUES
(),
(),
(),
();

INSERT INTO Partida (fecha, puntuaje) VALUES
(),
(),
(),
();