CREATE DATABASE IF NOT EXISTS appJuegosdb;

USE appJuegosdb;

CREATE TABLE juegos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(255),
  genero VARCHAR(50),
  plataforma VARCHAR(50),
  fecha_lanzamiento DATE,
  calificacion DECIMAL(3, 1),
  descripcion TEXT
);

CREATE TABLE desarrolladoras (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  pais VARCHAR(50)
);

CREATE TABLE desarrolladores_juegos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_juego INT,
  id_desarrolladora INT,
  FOREIGN KEY (id_juego) REFERENCES juegos(id),
  FOREIGN KEY (id_desarrolladora) REFERENCES desarrolladoras(id)
);

CREATE TABLE jugadores (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE compras (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_jugador INT,
  id_juego INT,
  fecha_compra DATETIME,
  FOREIGN KEY (id_jugador) REFERENCES jugadores(id),
  FOREIGN KEY (id_juego) REFERENCES juegos(id)
);


-- Inserciones en la tabla "juegos"
INSERT IGNORE INTO juegos (titulo, genero, plataforma, fecha_lanzamiento, calificacion, descripcion)
VALUES
  ('The Legend of Zelda: Breath of the Wild', 'Aventura', 'Nintendo Switch', '2017-03-03', 9.5, 'Explora el vasto mundo abierto de Hyrule.'),
  ('Super Mario Odyssey', 'Plataformas', 'Nintendo Switch', '2017-10-27', 9.2, 'Únete a Mario en una aventura por diferentes reinos del mundo.'),
  ('Red Dead Redemption 2', 'Acción y aventura', 'PlayStation 4', '2018-10-26', 9.8, 'Conviértete en un forajido en el Viejo Oeste y vive la aventura de tu vida.'),
  ('Fortnite', 'Battle Royale', 'PC', '2017-07-25', 8.5, 'Lucha en línea en este juego de batalla real gratuito.'),
  ('Minecraft', 'Aventura y construcción', 'Xbox One', '2011-11-18', 9.3, 'Crea y explora tu propio mundo virtual en este juego de construcción.') ;

-- Inserciones en la tabla "desarrolladoras"
INSERT IGNORE INTO desarrolladoras (nombre, pais)
VALUES
  ('Nintendo', 'Japón'),
  ('Rockstar Games', 'Estados Unidos'),
  ('Epic Games', 'Estados Unidos'),
  ('Mojang Studios', 'Suecia');

-- Inserciones en la tabla "desarrolladores_juegos"
INSERT IGNORE INTO desarrolladores_juegos (id_juego, id_desarrolladora)
VALUES
  (1, 1),
  (2, 1),
  (3, 2),
  (4, 3),
  (5, 4);

-- Inserciones en la tabla "jugadores"
INSERT IGNORE INTO jugadores (nombre, email)
VALUES
  ('Juan Pérez', 'juanperez@email.com'),
  ('María Gómez', 'mariagomez@email.com'),
  ('Pedro Rodríguez', 'pedrorodriguez@email.com');

-- Inserciones en la tabla "compras"
INSERT IGNORE INTO compras (id_jugador, id_juego, fecha_compra)
VALUES
  (1, 1, '2022-03-15 12:30:00'),
  (1, 3, '2022-03-20 09:45:00'),
  (2, 2, '2022-03-21 15:20:00'),
  (2, 4, '2022-03-23 10:10:00'),
  (3, 5, '2022-03-25 18:00:00');

-- Segunda tanda de inserciones en la tabla "juegos"
INSERT IGNORE INTO juegos (titulo, genero, plataforma, fecha_lanzamiento, calificacion, descripcion)
VALUES
  ('Grand Theft Auto V', 'Acción y aventura', 'PlayStation 4', '2014-11-18', 9.7, 'Únete a tres criminales mientras llevan a cabo robos y otros crímenes en la ciudad ficticia de Los Santos.'),
  ('Call of Duty: Modern Warfare', 'Shooter en primera persona', 'Xbox One', '2019-10-25', 8.9, 'Únete a las fuerzas especiales para detener a un grupo terrorista global.'),
  ('The Elder Scrolls V: Skyrim', 'RPG de acción', 'PC', '2011-11-11', 9.5, 'Explora el vasto mundo de Tamriel y elige tu camino como el legendario Sangre de Dragón.'),
  ('League of Legends', 'MOBA', 'PC', '2009-10-27', 8.2, 'Únete a un equipo de cinco jugadores y lucha para destruir la base enemiga en este popular juego en línea.'),
  ('Overwatch', 'Shooter en primera persona', 'PlayStation 4', '2016-05-24', 8.8, 'Únete a un equipo de héroes únicos y lucha por el control del campo de batalla en este popular juego de disparos.') ;

-- Segunda tanda de inserciones en la tabla "desarrolladoras"
INSERT IGNORE INTO desarrolladoras (nombre, pais)
VALUES
  ('Rockstar North', 'Reino Unido'),
  ('Infinity Ward', 'Estados Unidos'),
  ('Bethesda Game Studios', 'Estados Unidos'),
  ('Riot Games', 'Estados Unidos'),
  ('Blizzard Entertainment', 'Estados Unidos');

-- Segunda tanda de inserciones en la tabla "desarrolladores_juegos"
INSERT IGNORE INTO desarrolladores_juegos (id_juego, id_desarrolladora)
VALUES
  (6, 5),
  (7, 6),
  (8, 7),
  (9, 8),
  (10, 9);

-- Segunda tanda de inserciones en la tabla "jugadores"
INSERT IGNORE INTO jugadores (nombre, email)
VALUES
  ('Ana García', 'anagarcia@email.com'),
  ('Carlos Torres', 'carlostorres@email.com'),
  ('Lucía Sánchez', 'luciasanchez@email.com');

-- Segunda tanda de inserciones en la tabla "compras"
INSERT IGNORE INTO compras (id_jugador, id_juego, fecha_compra)
VALUES
  (4, 8, '2022-03-26 11:00:00'),
  (5, 6, '2022-03-28 14:30:00'),
  (5, 10, '2022-03-29 09:20:00'),
  (6, 9, '2022-03-30 17:15:00'),
  (6, 7, '2022-03-31 10:45:00');

-- Tercera tanda de inserciones en la tabla "juegos"
INSERT IGNORE INTO juegos (titulo, genero, plataforma, fecha_lanzamiento, calificacion, descripcion)
VALUES
  ('Super Mario Bros.', 'Plataformas', 'NES', '1985-09-13', 9.0, 'Uno de los juegos más icónicos de la historia'),
  ('Final Fantasy VII', 'RPG', 'PlayStation', '1997-01-31', 9.2, 'Una historia emocionante con personajes inolvidables'),
  ('Grand Theft Auto V', 'Acción', 'PS4', '2014-11-18', 9.7, 'Un mundo abierto increíblemente detallado y lleno de vida'),
  ('Minecraft', 'Sandbox', 'PC', '2011-11-18', 8.5, 'Un mundo infinito lleno de posibilidades'),
  ('The Last of Us Part II', 'Acción-Aventura', 'PS4', '2020-06-19', 9.3, 'Una historia emocionante que te mantendrá al borde de tu asiento'),
  ('Halo: Combat Evolved', 'FPS', 'Xbox', '2001-11-15', 8.7, 'El inicio de una de las sagas más icónicas de los videojuegos'),
  ('World of Warcraft', 'MMORPG', 'PC', '2004-11-23', 8.9, 'Un mundo en línea lleno de aventuras y peligros'),
  ('Red Dead Redemption 2', 'Acción-Aventura', 'PS4', '2018-10-26', 9.8, 'Un viaje impresionante al salvaje oeste'),
  ('Fortnite', 'Battle Royale', 'PC', '2017-07-25', 8.1, 'Un juego de batalla real que ha conquistado al mundo entero'),
  ('BioShock', 'FPS', 'Xbox 360', '2007-08-21', 8.8, 'Un juego de acción y suspense con una historia que te sorprenderá'),
  ('FIFA 21', 'Deportes', 'PS4', '2020-10-09', 7.9, 'El simulador de fútbol más popular del mundo'),
  ('Call of Duty: Modern Warfare 2', 'FPS', 'Xbox 360', '2009-11-10', 8.4, 'Una campaña emocionante y un multijugador adictivo'),
  ('Super Smash Bros. Ultimate', 'Lucha', 'Switch', '2018-12-07', 9.1, 'La experiencia definitiva de Smash Bros.'),
  ('The Elder Scrolls V: Skyrim', 'RPG', 'PC', '2011-11-11', 9.6, 'Un mundo de fantasía épico lleno de aventuras y secretos'),
  ('Counter-Strike: Global Offensive', 'FPS', 'PC', '2012-08-21', 8.6, 'El clásico juego de disparos en equipo'),
  ('The Witcher 3: Wild Hunt', 'RPG', 'PS4', '2015-05-19', 9.9, 'Una aventura épica con un mundo enorme y una historia envolvente'),
  ('League of Legends', 'MOBA', 'PC', '2009-10-27', 8.7, 'Uno de los juegos en línea más populares del mundo'),
  ('Assassins Creed Valhalla', 'Acción-Aventura', 'PS5', '2020-11-10', 9.0, 'Un juego de acción y aventuras que te lleva al mundo vikingo'),
  ('Half-Life 2', 'FPS', 'PC', '2004-11-16', 9.4, 'Un clásico de la historia de los videojuegos'),
  ('Pokemon Red/Blue', 'RPG', 'Game Boy', '1998-09-30', 8.3, 'El inicio de la exitosa franquicia de Pokemon'),
  ('Overwatch', 'FPS', 'PC', '2016-05-24', 8.9, 'Un juego de disparos en equipo con personajes únicos'),
  ('Madden NFL 21', 'Deportes', 'PS4', '2020-08-25', 7.5, 'El juego de fútbol americano más popular'),
  ('Resident Evil 2 (2019)', 'Survival Horror', 'PS4', '2019-01-25', 8.8, 'Un remake del clásico de terror con gráficos mejorados'),
  ('Portal 2', 'Puzzle-Platformer', 'PC', '2011-04-19', 9.5, 'Un juego de puzzles con humor y personajes memorables'),
  ('Civilization VI', 'Estrategia', 'PC', '2016-10-21', 9.1, 'Un juego de estrategia por turnos donde construyes una civilización desde cero'),
  ('Tony Hawks Pro Skater 2', 'Deportes', 'PlayStation', '2000-09-20', 8.5, 'El mejor juego de skate de todos los tiempos'),
  ;
