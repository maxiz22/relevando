-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 16, 2024 at 09:14 PM
-- Server version: 8.0.30
-- PHP Version: 8.2.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `relevando_s21`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE `categorias` (
  `id` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_creado` timestamp NULL DEFAULT NULL,
  `fecha_modificado` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) VALUES
(1, 'Alumbrado público', 'Peligros en alumbrado público o afines', '2024-10-03 21:04:02', '2024-10-03 21:04:02'),
(2, 'Cartelería', 'Peligros en carteles o publicidades', '2024-10-03 21:05:19', '2024-10-03 21:05:19'),
(3, 'Boca de tormenta', 'Peligros con desagües y boca de tormenta', '2024-10-03 21:06:17', '2024-10-03 21:06:17'),
(4, 'Cables expuestos', 'Peligros con cables expuestos a la vista', '2024-10-03 21:07:55', '2024-10-03 21:07:55'),
(5, 'Arbol', 'Peligros relacionados con árboles, vegetación o afines', '2024-10-03 21:08:35', '2024-10-03 21:08:35');

-- --------------------------------------------------------

--
-- Table structure for table `peligros`
--

CREATE TABLE `peligros` (
  `id` int NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `descripcion` text,
  `codigo` varchar(45) DEFAULT NULL,
  `estado` int NOT NULL,
  `ubicacion` point DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `barrio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `fecha_creado` timestamp NULL DEFAULT NULL,
  `fecha_modificado` timestamp NULL DEFAULT NULL,
  `categoria_id` int NOT NULL,
  `relevador_id` int NOT NULL,
  `responsable_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `peligros`
--

INSERT INTO `peligros` (`id`, `titulo`, `descripcion`, `codigo`, `estado`, `ubicacion`, `direccion`, `barrio`, `ciudad`, `provincia`, `fecha_creado`, `fecha_modificado`, `categoria_id`, `relevador_id`, `responsable_id`) VALUES
(1, 'Poste Caído en plaza', 'Hay un poste caido en la plaza san martin la cual presenta un peligro por los cables que quedaron a la altura de la via publica', 'C09bs', 1, NULL, NULL, 'Centro', 'Cordoba', 'Cordoba', '2024-11-16 19:32:00', '2024-11-16 19:32:00', 1, 1, 1),
(2, 'Arbol caído en plaza san martín', 'Hay un arbol caido en la plaza en la esquina de sanjeronimo y buenos aires', 'waPTJ', 2, NULL, NULL, 'Centro', 'Cordoba', 'Cordoba', '2024-11-16 20:43:53', '2024-11-16 20:43:53', 5, 1, 2),
(3, 'Cables expuestos en plaza san martin', 'Hay una caja electrica que tiene cables expuestos que son peligrosos para las personas que circulan en el area', 'js61A', 4, NULL, NULL, 'Centro', 'Córdoba', 'Córdoba', '2024-11-16 20:48:23', '2024-11-16 20:48:23', 4, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `responsables`
--

CREATE TABLE `responsables` (
  `id` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `fecha_creado` timestamp NULL DEFAULT NULL,
  `fecha_modificado` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `responsables`
--

INSERT INTO `responsables` (`id`, `nombre`, `email`, `telefono`, `fecha_creado`, `fecha_modificado`) VALUES
(1, 'EPEC', 'epec@test.com', '3512302121', '2024-10-03 21:20:33', '2024-10-03 21:20:33'),
(2, 'Municipalidad de Córdoba', 'municba@test.com', '3512302121', '2024-10-03 21:20:40', '2024-10-03 21:20:40'),
(3, 'Aguas Cordobesas', 'agcordobesas@test.com', '3512302121', '2024-10-03 21:20:55', '2024-10-03 21:20:55');

-- --------------------------------------------------------

--
-- Table structure for table `tramites`
--

CREATE TABLE `tramites` (
  `id` int NOT NULL,
  `estado` int NOT NULL DEFAULT '1',
  `descripcion` text NOT NULL,
  `fecha_creado` timestamp NULL DEFAULT NULL,
  `fecha_modificado` timestamp NULL DEFAULT NULL,
  `responsable_id` int NOT NULL,
  `peligro_id` int NOT NULL,
  `datos_adicionales` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tramites`
--

INSERT INTO `tramites` (`id`, `estado`, `descripcion`, `fecha_creado`, `fecha_modificado`, `responsable_id`, `peligro_id`, `datos_adicionales`) VALUES
(1, 2, 'Por favor resolver el peligro a la brevedad', '2024-11-16 20:44:42', '2024-11-16 20:44:42', 2, 2, NULL),
(2, 2, 'Resolver a la brevedad', '2024-11-16 20:49:21', '2024-11-16 20:49:21', 1, 3, NULL),
(3, 4, 'El peligro fue solucionado correctamente', '2024-11-16 20:49:49', '2024-11-16 20:49:49', 1, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `fecha_creado` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificado` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `email`, `telefono`, `password`, `fecha_creado`, `fecha_modificado`) VALUES
(1, 'relevadortest', 'relevador@test.com', '3512305121', '0ec53c34ceb021b4c7907d31db2ff752', '2024-11-16 08:59:18', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peligros`
--
ALTER TABLE `peligros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_peligros_categorias_idx` (`categoria_id`),
  ADD KEY `fk_peligros_usuarios_idx` (`relevador_id`),
  ADD KEY `fk_peligros_responsables_idx` (`responsable_id`);

--
-- Indexes for table `responsables`
--
ALTER TABLE `responsables`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tramites`
--
ALTER TABLE `tramites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tramites_responsables_idx` (`responsable_id`),
  ADD KEY `fk_tramites_peligros_idx` (`peligro_id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `peligros`
--
ALTER TABLE `peligros`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `responsables`
--
ALTER TABLE `responsables`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tramites`
--
ALTER TABLE `tramites`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peligros`
--
ALTER TABLE `peligros`
  ADD CONSTRAINT `fk_peligros_categorias` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_peligros_responsables` FOREIGN KEY (`responsable_id`) REFERENCES `responsables` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_peligros_usuarios` FOREIGN KEY (`relevador_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `tramites`
--
ALTER TABLE `tramites`
  ADD CONSTRAINT `fk_tramites_peligros` FOREIGN KEY (`peligro_id`) REFERENCES `peligros` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tramites_responsables` FOREIGN KEY (`responsable_id`) REFERENCES `responsables` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
