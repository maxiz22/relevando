

-- -----------------------------------------------------
-- Categorias
-- -----------------------------------------------------
INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) 
VALUES (1, 'Alumbrado público', 'Peligros en alumbrado público o afines', '2024-10-03 18:04:02', '2024-10-03 18:04:02');

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) 
VALUES (2, 'Cartelería', 'Peligros en carteles o publicidades', '2024-10-03 18:05:19', '2024-10-03 18:05:19');

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) 
VALUES (3, 'Boca de tormenta', 'Peligros con desagües y boca de tormenta', '2024-10-03 18:06:17', '2024-10-03 18:06:17');

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) 
VALUES (4, 'Cables expuestos', 'Peligros con cables expuestos a la vista', '2024-10-03 18:07:55', '2024-10-03 18:07:55');

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`, `fecha_creado`, `fecha_modificado`) 
VALUES (5, 'Arbol', 'Peligros relacionados con árboles, vegetación o afines', '2024-10-03 18:08:35', '2024-10-03 18:08:35');


-- -----------------------------------------------------
-- Usuarios
-- -----------------------------------------------------

INSERT INTO `usuarios` (`id`, `username`, `email`, `telefono`, `password`, `fecha_creado`, `fecha_modificado`) 
VALUES (1, 'juandoe', 'juandoe@test.com', '3512123456', '098f6bcd4621d373cade4e832627b4f6', '2024-10-03 18:14:06', '2024-10-03 18:14:06');

INSERT INTO `usuarios` (`id`, `username`, `email`, `telefono`, `password`, `fecha_creado`, `fecha_modificado`) 
VALUES (2, 'leomessi', 'leomessi@test.com', '3512123466', 'ad0234829205b9033196ba818f7a872b', '2024-10-03 18:14:08', '2024-10-03 18:14:08');

INSERT INTO `usuarios` (`id`, `username`, `email`, `telefono`, `password`, `fecha_creado`, `fecha_modificado`) 
VALUES (3, 'rfuentes', 'rfuentes@test.com', '3512123470', '8ad8757baa8564dc136c1e07507f4a98', '2024-10-03 18:14:15', '2024-10-03 18:14:15');



-- -----------------------------------------------------
-- Responsables
-- -----------------------------------------------------

INSERT INTO `responsables` (`id`, `nombre`, `email`, `telefono`, `fecha_creado`, `fecha_modificado`) 
VALUES (1, 'EPEC', 'epec@test.com', '3512302121', '2024-10-03 18:20:33', '2024-10-03 18:20:33');

INSERT INTO `responsables` (`id`, `nombre`, `email`, `telefono`, `fecha_creado`, `fecha_modificado`) 
VALUES (2, 'Municipalidad de Córdoba', 'municba@test.com', '3512302121', '2024-10-03 18:20:40', '2024-10-03 18:20:40');

INSERT INTO `responsables` (`id`, `nombre`, `email`, `telefono`, `fecha_creado`, `fecha_modificado`) 
VALUES (3, 'Aguas Cordobesas', 'agcordobesas@test.com', '3512302121', '2024-10-03 18:20:55', '2024-10-03 18:20:55');


-- -----------------------------------------------------
-- Peligros
-- -----------------------------------------------------

INSERT INTO `peligros` (`id`, `titulo`, `descripcion`, `codigo`, `estado`, `ubicacion`, `direccion`, `barrrio`, `ciudad`, `provincia`, `fecha_creado`, `fecha_modificado`, `categoria_id`, `relevador_id`, `responsable_id`) 
VALUES (1, 'Buenos Aires 600, Cordoba, Cordoba', 'Luminarias empotradas en la pared para indicar los peldaños de la escalera se encuentran sin el equipo y sin la lámpara y con los cables a la vista. En la foto se aprecia sólo uno pero en todo el predio de Paseo del Buen Pastor hay una numerosa cantidad de luces en las mismas condiciones.',
 'CBKIDG', '1', ST_GeomFromText('POINT(1 1)',0), 'La Fraternidad 2195, Cordoba, Cordoba', 'Ferroviario Mitre', 'Cordoba', 'Cordoba', '2024-10-04 18:26:00', '2024-10-04 18:26:00', '1', '1', '1');

INSERT INTO `peligros` (`id`, `titulo`, `descripcion`, `codigo`, `estado`, `ubicacion`, `direccion`, `barrrio`, `ciudad`, `provincia`, `fecha_creado`, `fecha_modificado`, `categoria_id`, `relevador_id`, `responsable_id`) 
VALUES (2, 'Belardinelli 3654, Cordoba, Cordoba', 'Cable de electricidad colgando, sobre calle Belardinelli',
 'LUGVCI', '1', ST_GeomFromText('POINT(1 2)',0), 'Belardinelli 3654, Cordoba, Cordoba', 'Las Flores ', 'Cordoba', 'Cordoba', '2024-10-04 18:32:42', '2024-10-04 18:32:42', '4', '1', '1');


-- -----------------------------------------------------
-- Tramites
-- -----------------------------------------------------

INSERT INTO `tramites` (`id`, `estado`, `fecha_creado`, `fecha_modificado`, `responsable_id`, `peligro_id`, `datos_adicionales`) 
VALUES (1, '1', '2024-10-03 18:42:39', '2024-10-03 18:42:39', '1', '1', NULL);

INSERT INTO `tramites` (`id`, `estado`, `fecha_creado`, `fecha_modificado`, `responsable_id`, `peligro_id`, `datos_adicionales`) 
VALUES (2, '1', '2024-10-04 18:43:18', '2024-10-04 18:43:18', '2', '2', NULL);