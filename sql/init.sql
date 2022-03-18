CREATE SCHEMA 'aqa_it_step_4at';

CREATE TABLE `aqa_it_step_4at`.`cars` (
  `id_cars` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `description` VARCHAR(60) NULL,
  PRIMARY KEY (`id_cars`));

CREATE TABLE `aqa_it_step_4at`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `day_of_birdth` DATETIME NOT NULL,
  PRIMARY KEY (`id_users`));