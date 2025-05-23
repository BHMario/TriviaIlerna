-- BORRAR Y CREAR BASE DE DATOS
DROP DATABASE IF EXISTS trivia;
CREATE DATABASE IF NOT EXISTS trivia;
USE trivia;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL
);

-- Tabla de categorías
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

-- Tabla de preguntas
CREATE TABLE preguntas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enunciado TEXT NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    dificultad VARCHAR(20) NOT NULL
);

-- Tabla de respuestas
CREATE TABLE respuestas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pregunta INT NOT NULL,
    texto TEXT NOT NULL,
    es_correcta BOOLEAN NOT NULL,
    FOREIGN KEY (id_pregunta) REFERENCES preguntas(id) ON DELETE CASCADE
);

-- Tabla de partidas
CREATE TABLE partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha DATE NOT NULL,
    puntaje INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- INSERTAR USUARIOS
INSERT INTO usuarios (nombre, contrasena, tipo_usuario) VALUES 
('admin', 'admin123', 'admin'),
('jugador1', 'clave123', 'jugador');

-- INSERTAR CATEGORÍAS
INSERT INTO categorias (nombre) VALUES 
('Historia'),
('Ciencia'),
('Geografía'),
('Deportes')
('Anime');

-- INSERTAR PREGUNTAS Y RESPUESTAS

-- Preguntas Historia

-- Historia - Fácil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Quién fue el primer presidente de EE.UU.?', 'Historia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Abraham Lincoln', 0),
(LAST_INSERT_ID(), 'Thomas Jefferson', 0),
(LAST_INSERT_ID(), 'George Washington', 1),
(LAST_INSERT_ID(), 'John Adams', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿En qué año comenzó la Segunda Guerra Mundial?', 'Historia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), '1914', 0),
(LAST_INSERT_ID(), '1945', 0),
(LAST_INSERT_ID(), '1929', 0),
(LAST_INSERT_ID(), '1939', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál fue el imperio más extenso de la historia?', 'Historia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Imperio Romano', 0),
(LAST_INSERT_ID(), 'Imperio Británico', 1),
(LAST_INSERT_ID(), 'Imperio Español', 0),
(LAST_INSERT_ID(), 'Imperio Mongol', 0);

-- Historia - Media
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué rey firmó la Carta Magna en 1215?', 'Historia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Ricardo Corazón de León', 0),
(LAST_INSERT_ID(), 'Carlos I', 0),
(LAST_INSERT_ID(), 'Juan I de Inglaterra', 1),
(LAST_INSERT_ID(), 'Enrique VIII', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué evento provocó la caída del muro de Berlín?', 'Historia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Protestas estudiantiles en Berlín', 0),
(LAST_INSERT_ID(), 'Intervención soviética', 0),
(LAST_INSERT_ID(), 'La apertura de fronteras por Hungría', 1),
(LAST_INSERT_ID(), 'Reunificación de Alemania', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué guerra enfrentó a Esparta y Atenas?', 'Historia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Guerra de Troya', 0),
(LAST_INSERT_ID(), 'Guerra del Peloponeso', 1),
(LAST_INSERT_ID(), 'Guerras Médicas', 0),
(LAST_INSERT_ID(), 'Guerras Púnicas', 0);

-- Historia - Difícil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué país fue el primero en independizarse en América Latina?', 'Historia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'México', 0),
(LAST_INSERT_ID(), 'Argentina', 0),
(LAST_INSERT_ID(), 'Haití', 1),
(LAST_INSERT_ID(), 'Colombia', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué dinastía gobernó China durante más tiempo?', 'Historia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Dinastía Qing', 0),
(LAST_INSERT_ID(), 'Dinastía Zhou', 1),
(LAST_INSERT_ID(), 'Dinastía Ming', 0),
(LAST_INSERT_ID(), 'Dinastía Tang', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Quién lideró la revuelta de esclavos en Haití?', 'Historia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Simón Bolívar', 0),
(LAST_INSERT_ID(), 'Jean-Jacques Dessalines', 0),
(LAST_INSERT_ID(), 'Napoleón Bonaparte', 0),
(LAST_INSERT_ID(), 'Toussaint Louverture', 1);

-- Preguntas Ciencia

-- Ciencia - Fácil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el planeta más cercano al Sol?', 'Ciencia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Tierra', 0),
(LAST_INSERT_ID(), 'Marte', 0),
(LAST_INSERT_ID(), 'Venus', 0),
(LAST_INSERT_ID(), 'Mercurio', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué órgano bombea la sangre en el cuerpo?', 'Ciencia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Pulmón', 0),
(LAST_INSERT_ID(), 'Corazón', 1),
(LAST_INSERT_ID(), 'Riñón', 0),
(LAST_INSERT_ID(), 'Hígado', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el símbolo químico del agua?', 'Ciencia', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'O2', 0),
(LAST_INSERT_ID(), 'NaCl', 0),
(LAST_INSERT_ID(), 'H2O', 1),
(LAST_INSERT_ID(), 'CO2', 0);

-- Ciencia - Media
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué científico propuso la teoría de la relatividad?', 'Ciencia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Stephen Hawking', 0),
(LAST_INSERT_ID(), 'Albert Einstein', 1),
(LAST_INSERT_ID(), 'Nikola Tesla', 0),
(LAST_INSERT_ID(), 'Isaac Newton', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué partícula subatómica tiene carga negativa?', 'Ciencia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Quark', 0),
(LAST_INSERT_ID(), 'Electrón', 1),
(LAST_INSERT_ID(), 'Protón', 0),
(LAST_INSERT_ID(), 'Neutrón', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es la fórmula del ácido sulfúrico?', 'Ciencia', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'NaOH', 0),
(LAST_INSERT_ID(), 'HCl', 0),
(LAST_INSERT_ID(), 'H2SO4', 1),
(LAST_INSERT_ID(), 'HNO3', 0);

-- Ciencia - Difícil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué científico desarrolló el principio de incertidumbre?', 'Ciencia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Fermi', 0),
(LAST_INSERT_ID(), 'Werner Heisenberg', 1),
(LAST_INSERT_ID(), 'Planck', 0),
(LAST_INSERT_ID(), 'Bohr', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál fue el primer elemento sintético creado?', 'Ciencia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Curio', 0),
(LAST_INSERT_ID(), 'Radón', 0),
(LAST_INSERT_ID(), 'Polonio', 0),
(LAST_INSERT_ID(), 'Tecnecio', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué rama de la ciencia estudia los cristales?', 'Ciencia', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Cristalografía', 1),
(LAST_INSERT_ID(), 'Química inorgánica', 0),
(LAST_INSERT_ID(), 'Física de materiales', 0),
(LAST_INSERT_ID(), 'Mineralogía', 0);

-- Preguntas Geografía

-- Geografía - Fácil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el país más grande del mundo?', 'Geografía', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Canadá', 0),
(LAST_INSERT_ID(), 'China', 0),
(LAST_INSERT_ID(), 'Brasil', 0),
(LAST_INSERT_ID(), 'Rusia', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Dónde se encuentra la Torre Eiffel?', 'Geografía', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Italia', 0),
(LAST_INSERT_ID(), 'España', 0),
(LAST_INSERT_ID(), 'Francia', 1),
(LAST_INSERT_ID(), 'Reino Unido', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el océano más grande del mundo?', 'Geografía', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Atlántico', 0),
(LAST_INSERT_ID(), 'Pacífico', 1),
(LAST_INSERT_ID(), 'Ártico', 0),
(LAST_INSERT_ID(), 'Índico', 0);

-- Geografía - Media
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es la capital de Australia?', 'Geografía', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Sydney', 0),
(LAST_INSERT_ID(), 'Perth', 0),
(LAST_INSERT_ID(), 'Canberra', 1),
(LAST_INSERT_ID(), 'Melbourne', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Dónde están las cataratas del Iguazú?', 'Geografía', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Argentina y Brasil', 1),
(LAST_INSERT_ID(), 'Chile y Perú', 0),
(LAST_INSERT_ID(), 'Colombia y Venezuela', 0),
(LAST_INSERT_ID(), 'Bolivia y Paraguay', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué cordillera atraviesa Sudamérica?', 'Geografía', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Himalaya', 0),
(LAST_INSERT_ID(), 'Rocosas', 0),
(LAST_INSERT_ID(), 'Andes', 1),
(LAST_INSERT_ID(), 'Alpes', 0);

-- Geografía - Difícil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es la ciudad más alta del mundo?', 'Geografía', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Quito (Ecuador)', 0),
(LAST_INSERT_ID(), 'La Rinconada (Perú)', 1),
(LAST_INSERT_ID(), 'Lhasa (Tíbet)', 0),
(LAST_INSERT_ID(), 'La Paz (Bolivia)', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué país sin costa limita con 8 países?', 'Geografía', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Paraguay', 0),
(LAST_INSERT_ID(), 'Austria', 1),
(LAST_INSERT_ID(), 'Suiza', 0),
(LAST_INSERT_ID(), 'Mongolia', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el desierto más seco del mundo?', 'Geografía', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Gobi', 0),
(LAST_INSERT_ID(), 'Sahara', 0),
(LAST_INSERT_ID(), 'Atacama', 1),
(LAST_INSERT_ID(), 'Kalahari', 0);

-- Preguntas Deporte

-- Deportes - Fácil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuántos jugadores tiene un equipo de fútbol?', 'Deportes', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), '9', 0),
(LAST_INSERT_ID(), '7', 0),
(LAST_INSERT_ID(), '10', 0),
(LAST_INSERT_ID(), '11', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿En qué deporte se usa una raqueta?', 'Deportes', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Fútbol', 0),
(LAST_INSERT_ID(), 'Golf', 0),
(LAST_INSERT_ID(), 'Boxeo', 0),
(LAST_INSERT_ID(), 'Tenis', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuántos aros hay en el símbolo olímpico?', 'Deportes', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), '6', 0),
(LAST_INSERT_ID(), '5', 1),
(LAST_INSERT_ID(), '3', 0),
(LAST_INSERT_ID(), '4', 0);

-- Deportes - Media
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué selección ganó el Mundial 2014?', 'Deportes', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Argentina', 0),
(LAST_INSERT_ID(), 'Brasil', 0),
(LAST_INSERT_ID(), 'Alemania', 1),
(LAST_INSERT_ID(), 'España', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué deporte es originario de Japón?', 'Deportes', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Karate', 0),
(LAST_INSERT_ID(), 'Judo', 1),
(LAST_INSERT_ID(), 'Boxeo', 0),
(LAST_INSERT_ID(), 'Taekwondo', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué atleta tiene más medallas olímpicas?', 'Deportes', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Carl Lewis', 0),
(LAST_INSERT_ID(), 'Usain Bolt', 0),
(LAST_INSERT_ID(), 'Mark Spitz', 0),
(LAST_INSERT_ID(), 'Michael Phelps', 1);

-- Deportes - Difícil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Quién ganó el Tour de Francia 2022?', 'Deportes', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Chris Froome', 0),
(LAST_INSERT_ID(), 'Tadej Pogacar', 0),
(LAST_INSERT_ID(), 'Jonas Vingegaard', 1),
(LAST_INSERT_ID(), 'Egan Bernal', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuándo fue la primera Copa Mundial de fútbol?', 'Deportes', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), '1934', 0),
(LAST_INSERT_ID(), '1930', 1),
(LAST_INSERT_ID(), '1942', 0),
(LAST_INSERT_ID(), '1928', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué país ganó más veces la Copa Davis?', 'Deportes', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Francia', 0),
(LAST_INSERT_ID(), 'Australia', 0),
(LAST_INSERT_ID(), 'Estados Unidos', 1),
(LAST_INSERT_ID(), 'España', 0);

-- Preguntas Anime

-- Anime - Fácil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cómo se llama el protagonista de One Piece?', 'Anime', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Zoro', 0),
(LAST_INSERT_ID(), 'Sanji', 0),
(LAST_INSERT_ID(), 'Shanks', 0),
(LAST_INSERT_ID(), 'Monkey D. Luffy', 1);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Qué fruta del diablo comió Luffy?', 'Anime', 'Fácil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Gomu Gomu no Mi', 1),
(LAST_INSERT_ID(), 'Mera Mera no Mi', 0),
(LAST_INSERT_ID(), 'Hie Hie no Mi', 0),
(LAST_INSERT_ID(), 'Yami Yami no Mi', 0);

-- Anime - Media
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el sueño de Zoro?', 'Anime', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Encontrar el One Piece', 0),
(LAST_INSERT_ID(), 'Ser el mejor espadachín', 1),
(LAST_INSERT_ID(), 'Derrotar a Luffy', 0),
(LAST_INSERT_ID(), 'Casarse con Tashigi', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cómo se llama el barco de los Sombrero de Paja después del Going Merry?', 'Anime', 'Media');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Thousand Sunny', 1),
(LAST_INSERT_ID(), 'Red Force', 0),
(LAST_INSERT_ID(), 'Oro Jackson', 0),
(LAST_INSERT_ID(), 'Baratie', 0);

-- Anime - Difícil
INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Cuál es el nombre completo del padre de Luffy?', 'Anime', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Monkey D. Garp', 0),
(LAST_INSERT_ID(), 'Monkey D. Dragon', 1),
(LAST_INSERT_ID(), 'Dragon D. Monkey', 0),
(LAST_INSERT_ID(), 'Portgas D. Dragon', 0);

INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES 
('¿Quién fue el primer nakama que se unió a Luffy?', 'Anime', 'Difícil');
INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES 
(LAST_INSERT_ID(), 'Nami', 0),
(LAST_INSERT_ID(), 'Usopp', 0),
(LAST_INSERT_ID(), 'Zoro', 1),
(LAST_INSERT_ID(), 'Sanji', 0);
