-- -----------------------------------------------------
-- Borrado de datos
-- -----------------------------------------------------
DELETE FROM tramites;
DELETE FROM peligros;
DELETE FROM categorias;
DELETE FROM responsables;
DELETE FROM usuarios;

-- -----------------------------------------------------
-- Consulta de verificación
-- -----------------------------------------------------
SELECT * FROM categorias;
SELECT * FROM peligros;
SELECT * FROM responsables;
SELECT * FROM tramites;
SELECT * FROM usuarios;