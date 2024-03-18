-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-03-2024 a las 18:49:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concurso_hamburguesas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hamburguesas`
--

CREATE TABLE `hamburguesas` (
  `ID_Hamburguesa` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` text DEFAULT NULL,
  `Restaurante_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hamburguesas`
--

INSERT INTO `hamburguesas` (`ID_Hamburguesa`, `Nombre`, `Descripcion`, `Restaurante_ID`) VALUES
(1, 'Classic Burger', 'Una jugosa hamburguesa de carne de res con lechuga, tomate, cebolla y queso cheddar.', 1),
(2, 'Texas BBQ Burger', 'Hamburguesa con carne de res, bacon, cebolla caramelizada, jalapeños y salsa BBQ.', 20),
(3, 'Veggie Delight Burger', 'Hamburguesa vegetariana con una deliciosa mezcla de lentejas, aguacate, tomate y lechuga.', 1),
(4, 'Smokehouse Burger', 'Hamburguesa de carne de res con bacon, queso ahumado, cebolla caramelizada y salsa de la casa.', 19),
(5, 'Southern Charm Burger', 'Una deliciosa hamburguesa con carne de res, aros de cebolla crujientes, queso cheddar y salsa ranch.', 19),
(6, 'Grilled Chicken Burger', 'Hamburguesa de pollo a la parrilla con aguacate, tomate, lechuga y mayonesa de chipotle.', 2),
(7, 'Spicy Jalapeño Burger', 'Hamburguesa de soja con jalapeños frescos, pepper jack cheese, lechuga y mayonesa picante.', 3),
(8, 'Mushroom Swiss Burger', 'Hamburguesa de carne de res con champiñones salteados, queso suizo, lechuga y salsa especial.', 17),
(9, 'Beyond Burger', 'Una opción vegetariana con una jugosa hamburguesa de Beyond Meat, aguacate, cebolla roja y tomate.', 3),
(10, 'Double Cheeseburger', 'Una hamburguesa doble con dos jugosas carnes de res, doble queso cheddar, lechuga, tomate y cebolla.', 23),
(11, 'California Burger', 'Hamburguesa con carne de res, aguacate fresco, tocino crujiente, lechuga y mayonesa de cilantro.', 17),
(12, 'Hawaiian Burger', 'Hamburguesa de carne de res con piña a la parrilla, jamón, queso suizo y salsa teriyaki.', 12),
(13, 'Southwest Turkey Burger', 'Hamburguesa de pavo con guacamole, pico de gallo, queso pepper jack y tortilla chips.', 5),
(14, 'Mediterranean Veggie Burger', 'Hamburguesa vegetariana con falafel, hummus, pepino, tomate, lechuga y salsa tzatziki.', 18),
(15, 'Buffalo Chicken Burger', 'Hamburguesa de pollo empanizado con salsa buffalo, queso azul, lechuga y cebolla morada.', 5),
(16, 'BBQ Bacon Ranch Burger', 'Hamburguesa de carne de res con bacon crujiente, queso cheddar, aros de cebolla y salsa ranch.', 6),
(17, 'Black and Blue Burger', 'Hamburguesa de carne de res con queso azul, cebolla caramelizada, champiñones y salsa balsámica.', 6),
(18, 'Teriyaki Pineapple Burger', 'Hamburguesa de carne de res con rodajas de piña a la parrilla, queso suizo y salsa teriyaki.', 6),
(19, 'Portobello Mushroom Burger', 'Hamburguesa de carne de res con portobello a la parrilla, queso provolone, lechuga y tomate.', 16),
(20, 'BBQ Pulled Pork Burger', 'Hamburguesa de cerdo desmenuzado con salsa BBQ, coleslaw, pepinillos y cebolla frita.', 10),
(21, 'Caprese Burger', 'Hamburguesa de carne de res con tomate fresco, mozzarella de búfala, albahaca y pesto.', 7),
(22, 'Bacon Guacamole Burger', 'Hamburguesa de carne de res con guacamole casero, bacon crujiente, queso cheddar y tomate.', 4),
(23, 'Philly Cheesesteak Burger', 'Hamburguesa de carne de res con pimientos y cebollas salteadas, queso provolone y salsa de queso.', 11),
(24, 'Greek Lamb Burger', 'Hamburguesa de cordero con queso feta, pepino, tomate, lechuga y salsa tzatziki.', 8),
(25, 'Jalapeño Popper Burger', 'Hamburguesa de carne de res con jalapeños rellenos de queso crema, bacon y queso pepper jack.', 9),
(26, 'Cajun Shrimp Burger', 'Hamburguesa de camarones a la parrilla con aguacate, tomate, lechuga y mayonesa de cajún.', 9),
(27, 'Italian Sausage Burger', 'Hamburguesa de salchicha italiana con pimientos asados, cebolla caramelizada y queso provolone.', 23),
(28, 'Turkey Club Burger', 'Hamburguesa de pavo con bacon, aguacate, tomate, lechuga y mayonesa de mostaza y miel.', 22),
(29, 'Mushroom Swiss Turkey Burger', 'Hamburguesa de pavo con champiñones salteados, queso suizo, lechuga y salsa de mostaza.', 10),
(30, 'BBQ Bacon Turkey Burger', 'Hamburguesa de pavo con bacon crujiente, queso cheddar, aros de cebolla y salsa BBQ.', 10),
(31, 'Vegan BBQ Burger', 'Hamburguesa vegana con carne a base de plantas, cebolla caramelizada, pepinillos y salsa BBQ vegana.', 12),
(32, 'Spicy Chickpea Burger', 'Hamburguesa vegana con falafel picante, hummus, tomate, lechuga y salsa de chile.', 3),
(33, 'Black Bean Burger', 'Hamburguesa vegana de frijoles negros con aguacate, maíz, lechuga y salsa de cilantro.', 20),
(34, 'Mushroom Veggie Burger', 'Hamburguesa vegana con champiñones, cebolla, pimientos, zanahoria y calabacín a la parrilla.', 23),
(35, 'Quinoa and Sweet Potato Burger', 'Hamburguesa vegana con quinoa, batata, cebolla roja, espinacas y alioli de aguacate.', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurantes`
--

CREATE TABLE `restaurantes` (
  `ID_Restaurante` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Ubicacion` varchar(255) DEFAULT NULL,
  `Chef` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `restaurantes`
--

INSERT INTO `restaurantes` (`ID_Restaurante`, `Nombre`, `Ubicacion`, `Chef`) VALUES
(1, 'The Burger Joint', '123 Main Street, Ciudad A', 'John Smith'),
(2, 'Grill Master', '456 Oak Avenue, Ciudad B', 'Maria Rodriguez'),
(3, 'Veggie Delight', '789 Elm Street, Ciudad C', 'David Nguyen'),
(4, 'The Burger Palace', '123 Main Street, New York', 'Michael Johnson'),
(5, 'Smokehouse BBQ', '456 Oak Avenue, Los Angeles', 'Sarah Williams'),
(6, 'The Grilled Cow', '789 Elm Street, Chicago', 'Daniel Martinez'),
(7, 'Burger Barn', '567 Maple Drive, Houston', 'Jessica Lee'),
(8, 'Flame Grill', '890 Pine Street, San Francisco', 'Ryan Thompson'),
(9, 'Sizzling Skillet', '234 Cedar Lane, Miami', 'Emily Garcia'),
(10, 'Smoke & Spice', '321 Walnut Avenue, Atlanta', 'Alex Turner'),
(11, 'Grill House', '432 Cherry Lane, Dallas', 'Jennifer Brown'),
(12, 'Grill King', '876 Oakwood Drive, Denver', 'Kevin Wilson'),
(13, 'Burger Bistro', '987 Birch Street, Seattle', 'Amanda Roberts'),
(14, 'Meat Lovers Hideout', '765 Spruce Road, Boston', 'Matthew Clark'),
(15, 'The BBQ Pitstop', '543 Elm Avenue, Philadelphia', 'Rachel Taylor'),
(16, 'Urban Burger Co.', '345 Cedar Street, Washington D.C.', 'Andrew Evans'),
(17, 'Flavor Junction', '654 Maple Lane, San Diego', 'Olivia Moore'),
(18, 'Burger Bliss', '432 Pine Street, Orlando', 'Jacob Anderson'),
(19, 'Smokestack Tavern', '321 Oakwood Avenue, Austin', 'Sophia Hall'),
(20, 'Grill House', '876 Cherry Lane, Nashville', 'Nathan White'),
(21, 'Rustic Burger Shack', '543 Elm Street, Portland', 'Ethan Carter'),
(22, 'The Juicy Joint', '789 Birch Road, Detroit', 'Madison Scott'),
(23, 'Burger Emporium', '654 Walnut Drive, Phoenix', 'Joshua Hernandez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `votaciones`
--

CREATE TABLE `votaciones` (
  `ID_Votacion` int(11) NOT NULL,
  `Hamburguesa_ID` int(11) DEFAULT NULL,
  `Puntuacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `votaciones`
--

INSERT INTO `votaciones` (`ID_Votacion`, `Hamburguesa_ID`, `Puntuacion`) VALUES
(131071, 28, 5),
(131072, 26, 2),
(131073, 33, 5),
(131074, 33, 5),
(131075, 10, 5),
(131076, 24, 4),
(131077, 17, 2),
(131078, 4, 4),
(131079, 29, 1),
(131080, 9, 5),
(131081, 21, 2),
(131082, 33, 3),
(131083, 4, 4),
(131084, 14, 4),
(131085, 27, 3),
(131086, 2, 4),
(131087, 23, 5),
(131088, 26, 5),
(131089, 2, 4),
(131090, 12, 3),
(131091, 22, 3),
(131092, 21, 3),
(131093, 28, 3),
(131094, 25, 2),
(131095, 4, 4),
(131096, 15, 5),
(131097, 6, 1),
(131098, 7, 3),
(131099, 10, 4),
(131100, 15, 1),
(131101, 21, 3),
(131102, 12, 3),
(131103, 1, 5),
(131104, 8, 3),
(131105, 35, 2),
(131106, 31, 2),
(131107, 30, 2),
(131108, 2, 2),
(131109, 35, 2),
(131110, 23, 1),
(131111, 3, 5),
(131112, 31, 5),
(131113, 32, 5),
(131114, 14, 3),
(131115, 6, 3),
(131116, 26, 2),
(131117, 19, 4),
(131118, 16, 3),
(131119, 28, 4),
(131120, 28, 1),
(131121, 32, 2),
(131122, 33, 4),
(131123, 30, 1),
(131124, 21, 5),
(131125, 21, 2),
(131126, 21, 1),
(131127, 5, 1),
(131128, 6, 3),
(131129, 23, 5),
(131130, 29, 2),
(131131, 23, 4),
(131132, 5, 5),
(131133, 28, 2),
(131134, 17, 2),
(131135, 35, 1),
(131136, 25, 1),
(131137, 20, 2),
(131138, 9, 1),
(131139, 15, 1),
(131140, 30, 1),
(131141, 14, 2),
(131142, 21, 5),
(131143, 29, 2),
(131144, 14, 5),
(131145, 34, 2),
(131146, 15, 2),
(131147, 19, 3),
(131148, 12, 5),
(131149, 8, 4),
(131150, 17, 3),
(131151, 3, 5),
(131152, 5, 1),
(131153, 25, 3),
(131154, 11, 1),
(131155, 10, 2),
(131156, 24, 3),
(131157, 10, 5),
(131158, 1, 1),
(131159, 33, 1),
(131160, 15, 5),
(131161, 15, 2),
(131162, 35, 2),
(131163, 9, 3),
(131164, 24, 5),
(131165, 17, 4),
(131166, 26, 5),
(131167, 29, 4),
(131168, 31, 3),
(131169, 14, 4),
(131170, 9, 1),
(131198, 33, 1),
(131199, 15, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hamburguesas`
--
ALTER TABLE `hamburguesas`
  ADD PRIMARY KEY (`ID_Hamburguesa`);

--
-- Indices de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  ADD PRIMARY KEY (`ID_Restaurante`);

--
-- Indices de la tabla `votaciones`
--
ALTER TABLE `votaciones`
  ADD PRIMARY KEY (`ID_Votacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hamburguesas`
--
ALTER TABLE `hamburguesas`
  MODIFY `ID_Hamburguesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  MODIFY `ID_Restaurante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `votaciones`
--
ALTER TABLE `votaciones`
  MODIFY `ID_Votacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131200;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
