
CREATE TABLE `equipo` (
  `id_equipo` int(11) AUTO_INCREMENT PRIMARY KEY  ,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `equipo` (`nombre`) VALUES
('Eibar'),
('Tenerife '),
('Cartagena');


CREATE TABLE `jugador` (
  `id_jugador` int(11) AUTO_INCREMENT PRIMARY KEY,
  `nombre_jugador` varchar(60) NOT NULL,
  `id_equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`);

INSERT INTO `jugador` (`nombre_jugador`, `id_equipo`) VALUES
('Andy Rodriguez', 3),
('Mikel Rico', 3),
('Tejero', 1),
('Ager Aketxe', 1),
('Mo dauda', 2),
('Elady', 2);


COMMIT;