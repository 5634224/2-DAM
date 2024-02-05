CREATE TABLE IF NOT EXISTS Entrenador (
    EntrenadorID INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Ciudad VARCHAR(100)
);

INSERT INTO Entrenador (EntrenadorID, Nombre, Ciudad)
VALUES
    (1, 'Ash Ketchum', 'Pueblo Paleta'),
    (2, 'Misty', 'Ciudad Celeste'),
    (3, 'Brock', 'Ciudad Plateada'),
	(4, 'Gary Oak', 'Pueblo Paleta'),
    (5, 'Erika', 'Ciudad Azulona'),
    (6, 'Lt. Surge', 'Ciudad Carmín'),
	(7, 'Sabrina', 'Ciudad Azafrán'),
    (8, 'Koga', 'Ciudad Fucsia'),
    (9, 'Blaine', 'Isla Canela'),
	(10, 'Ritchie', 'Ciudad Plateada'),
    (11, 'Janine', 'Ciudad Fucsia'),
    (12, 'Falkner', 'Ciudad Malva'),
	(13, 'Clair', 'Ciudad Endrino'),
    (14, 'Chuck', 'Ciudad Trigal'),
    (15, 'Jasmine', 'Ciudad Iris');


CREATE TABLE IF NOT EXISTS Pokemon (
    PokemonID INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Tipo VARCHAR(50) NOT NULL,
    Generacion INT,
    EntrenadorID INT, -- Agregamos una columna para representar la relación
    FOREIGN KEY (EntrenadorID) REFERENCES Entrenador(EntrenadorID)
);

INSERT INTO Pokemon (PokemonID, Nombre, Tipo, Generacion, EntrenadorID)
VALUES
    (1, 'Bulbasaur', 'Planta/Veneno', 1, 1),
    (2, 'Charmander', 'Fuego', 1, 1),
    (3, 'Squirtle', 'Agua', 1, 2),
	(4, 'Pikachu', 'Eléctrico', 1, 1),
    (5, 'Squirtle', 'Agua', 1, 2),
    (6, 'Jigglypuff', 'Normal/Hada', 1, 3),
    (7, 'Meowth', 'Normal', 1, 3),
    (8, 'Geodude', 'Roca/Tierra', 1, 2),
    (9, 'Pidgey', 'Normal/Volador', 1, 1),
    (10, 'Abra', 'Psíquico', 1, 4),
    (11, 'Clefairy', 'Hada', 1, 4),
    (12, 'Onix', 'Roca/Tierra', 1, 5),
    (13, 'Machop', 'Lucha', 1, 5),
    (14, 'Oddish', 'Planta/Veneno', 1, 6),
    (15, 'Diglett', 'Tierra', 1, 6),
    (16, 'Poliwag', 'Agua', 1, 7),
    (17, 'Bellsprout', 'Planta/Veneno', 1, 7),
    (18, 'Geodude', 'Roca/Tierra', 1, 8),
    (19, 'Ponyta', 'Fuego', 1, 8),
    (20, 'Slowpoke', 'Agua/Psíquico', 1, 9);

