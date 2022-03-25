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

CREATE TABLE `aqa_it_step_4at`.`phone` (
  `idphone` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  `id_users` INT,
  PRIMARY KEY (`idphone`));

CREATE TABLE `aqa_it_step_4at`.`relatedcars` (
  `id_cars` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `description` VARCHAR(60) NULL,
  `id_users` INT NULL,
  PRIMARY KEY (`id_cars`));

CREATE TABLE `aqa_it_step_4at`.`relatedusers` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `day_of_birdth` DATETIME NOT NULL,
  `id_cars` INT NULL,
  PRIMARY KEY (`id_users`));