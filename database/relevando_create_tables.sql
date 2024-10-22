-- -----------------------------------------------------
-- Crear base de datos relevando_s21
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `relevando_s21` DEFAULT CHARACTER SET utf8 ;
USE `relevando_s21` ;

-- -----------------------------------------------------
-- Tabla`relevando_s21`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `relevando_s21`.`categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `descripcion` VARCHAR(255) NULL,
  `fecha_creacion` TIMESTAMP NULL,
  `fecha_modificado` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla`relevando_s21`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `relevando_s21`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `telefono` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `fecha_creado` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificado` TIMESTAMP NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Tabla`relevando_s21`.`responsables`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `relevando_s21`.`responsables` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL,
  `telefono` VARCHAR(255) NULL,
  `fecha_creado` TIMESTAMP NULL,
  `fecha_modificado` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla`relevando_s21`.`peligros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `relevando_s21`.`peligros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NULL,
  `descripcion` TEXT NULL,
  `codigo` VARCHAR(45) NULL,
  `estado` INT NOT NULL,
  `ubicacion` POINT NULL,
  `direccion` VARCHAR(255) NULL,
  `barrrio` VARCHAR(255) NULL,
  `ciudad` VARCHAR(255) NULL,
  `provincia` VARCHAR(255) NULL,
  `fecha_creado` TIMESTAMP NULL,
  `fecha_modificado` TIMESTAMP NULL,
  `categoria_id` INT NOT NULL,
  `relevador_id` INT NOT NULL,
  `responsable_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_peligros_categorias_idx` (`categoria_id` ASC) VISIBLE,
  INDEX `fk_peligros_usuarios_idx` (`relevador_id` ASC) VISIBLE,
  INDEX `fk_peligros_responsables_idx` (`responsable_id` ASC) VISIBLE,
  CONSTRAINT `fk_peligros_categorias`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `relevando_s21`.`categorias` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_peligros_usuarios`
    FOREIGN KEY (`relevador_id`)
    REFERENCES `relevando_s21`.`usuarios` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_peligros_responsables`
    FOREIGN KEY (`responsable_id`)
    REFERENCES `relevando_s21`.`responsables` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla`relevando_s21`.`tramites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `relevando_s21`.`tramites` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estado` INT NOT NULL DEFAULT 1,
  `fecha_creado` TIMESTAMP NULL,
  `fecha_modificado` TIMESTAMP NULL,
  `responsable_id` INT NOT NULL,
  `peligro_id` INT NOT NULL,
  `datos_adicionales` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tramites_responsables_idx` (`responsable_id` ASC) VISIBLE,
  INDEX `fk_tramites_peligros_idx` (`peligro_id` ASC) VISIBLE,
  CONSTRAINT `fk_tramites_responsables`
    FOREIGN KEY (`responsable_id`)
    REFERENCES `relevando_s21`.`responsables` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tramites_peligros`
    FOREIGN KEY (`peligro_id`)
    REFERENCES `relevando_s21`.`peligros` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
