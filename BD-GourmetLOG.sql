-- MySQL Script generated by MySQL Workbench
-- Sat May 11 18:11:13 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tendereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tendereco` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tendereco` (
  `nid_endereco` INT NOT NULL AUTO_INCREMENT,
  `rua_endereco` VARCHAR(45) NOT NULL,
  `num_endereco` VARCHAR(45) NOT NULL,
  `cep_endereco` VARCHAR(45) NOT NULL,
  `bairro_endereco` VARCHAR(45) NOT NULL,
  `municipio_endereco` VARCHAR(45) NOT NULL,
  `tipousuario_endereco` TINYINT NOT NULL,
  PRIMARY KEY (`nid_endereco`),
  UNIQUE INDEX `nidendereco_UNIQUE` (`nid_endereco` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tusuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tusuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tusuario` (
  `nid_usuario` INT NOT NULL AUTO_INCREMENT,
  `tendereco_nid_endereco` INT NULL,
  `cpf_usuario` VARCHAR(15) NOT NULL,
  `nome_usuario` VARCHAR(20) NOT NULL DEFAULT 'trim',
  `sobren_usuario` VARCHAR(45) NOT NULL,
  `nasc_usuario` DATE NOT NULL,
  `cel_usuario` VARCHAR(45) NOT NULL,
  `email_usuario` VARCHAR(45) NOT NULL,
  `senha_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nid_usuario`),
  UNIQUE INDEX `cpfusuario_UNIQUE` (`cpf_usuario` ASC) VISIBLE,
  UNIQUE INDEX `celularusuario_UNIQUE` (`cel_usuario` ASC) VISIBLE,
  UNIQUE INDEX `emailusuario_UNIQUE` (`email_usuario` ASC) VISIBLE,
  UNIQUE INDEX `nidusuario_UNIQUE` (`nid_usuario` ASC) VISIBLE,
  INDEX `fk_tusuario_endereco_idx` (`tendereco_nid_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_tusuario_endereco`
    FOREIGN KEY (`tendereco_nid_endereco`)
    REFERENCES `mydb`.`tendereco` (`nid_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tservico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tservico` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tservico` (
  `nid_servicos` INT NOT NULL AUTO_INCREMENT,
  `wifi_servicos` TINYINT NOT NULL,
  `ar_servicos` TINYINT NOT NULL,
  `pet_servicos` TINYINT NOT NULL,
  `couvert_servicos` TINYINT NOT NULL,
  `estacionamento_servicos` TINYINT NOT NULL,
  `kids_servicos` TINYINT NOT NULL,
  `arlivre_servicos` TINYINT NOT NULL,
  `deficiente_servicos` TINYINT NOT NULL,
  `fumante_servicos` TINYINT NOT NULL,
  `selfservice_servicos` TINYINT NOT NULL,
  `rodizio_servicos` TINYINT NOT NULL,
  PRIMARY KEY (`nid_servicos`),
  UNIQUE INDEX `nidservicos_UNIQUE` (`nid_servicos` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tculinaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tculinaria` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tculinaria` (
  `nid_culinaria` INT NOT NULL AUTO_INCREMENT,
  `italiana` TINYINT NOT NULL,
  `japonesa` TINYINT NOT NULL,
  `nordestina` TINYINT NOT NULL,
  `mexicana` TINYINT NOT NULL,
  `pizzaria` TINYINT NOT NULL,
  `mineira` TINYINT NOT NULL,
  `chinesa` TINYINT NOT NULL,
  `arabe` TINYINT NOT NULL,
  `grega` TINYINT NOT NULL,
  `francesa` TINYINT NOT NULL,
  `coreana` TINYINT NOT NULL,
  PRIMARY KEY (`nid_culinaria`),
  UNIQUE INDEX `nidculinaria_UNIQUE` (`nid_culinaria` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`testabelecimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`testabelecimento` ;

CREATE TABLE IF NOT EXISTS `mydb`.`testabelecimento` (
  `nid_estabelecimento` INT NOT NULL AUTO_INCREMENT,
  `tendereco_nid_endereco` INT NULL,
  `tservicos_nid_servicos` INT NULL,
  `tculinaria_nid_culinaria` INT NULL,
  `ninscr_estabelecimento` VARCHAR(45) NOT NULL,
  `nomeemp_estabelecimento` VARCHAR(45) NOT NULL,
  `nomefantasia_estabelecimento` VARCHAR(45) NOT NULL,
  `nomeresp_estabelecimento` VARCHAR(20) NOT NULL,
  `email_estabelecimento` VARCHAR(45) NOT NULL,
  `tel_estabelecimento` VARCHAR(45) NOT NULL,
  `nlugares_estabelecimento` VARCHAR(45) NOT NULL,
  `cheio_estabelecimento` TINYINT NULL,
  PRIMARY KEY (`nid_estabelecimento`),
  UNIQUE INDEX `emailestabelecimento_UNIQUE` (`email_estabelecimento` ASC) VISIBLE,
  UNIQUE INDEX `telestabelecimento_UNIQUE` (`tel_estabelecimento` ASC) VISIBLE,
  UNIQUE INDEX `nidtestabelecimento_UNIQUE` (`nid_estabelecimento` ASC) VISIBLE,
  INDEX `fk_testabelecimento_endereco1_idx` (`tendereco_nid_endereco` ASC) VISIBLE,
  INDEX `fk_testabelecimento_servicos1_idx` (`tservicos_nid_servicos` ASC) VISIBLE,
  UNIQUE INDEX `ninscr_estabelecimento_UNIQUE` (`ninscr_estabelecimento` ASC) VISIBLE,
  INDEX `fk_testabelecimento_tculinaria1_idx` (`tculinaria_nid_culinaria` ASC) VISIBLE,
  CONSTRAINT `fk_testabelecimento_endereco1`
    FOREIGN KEY (`tendereco_nid_endereco`)
    REFERENCES `mydb`.`tendereco` (`nid_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_testabelecimento_servicos1`
    FOREIGN KEY (`tservicos_nid_servicos`)
    REFERENCES `mydb`.`tservico` (`nid_servicos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_testabelecimento_tculinaria1`
    FOREIGN KEY (`tculinaria_nid_culinaria`)
    REFERENCES `mydb`.`tculinaria` (`nid_culinaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`treserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`treserva` ;

CREATE TABLE IF NOT EXISTS `mydb`.`treserva` (
  `nid_reserva` INT NOT NULL AUTO_INCREMENT,
  `testabelecimento_nid_estabelecimento` INT NOT NULL,
  `tusuario_nid_usuario` INT NOT NULL,
  `numpessoas_reserva` VARCHAR(45) NOT NULL,
  `horario_reserva` TIME NOT NULL,
  `nome_reserva` VARCHAR(45) NOT NULL,
  `data_reserva` DATE NOT NULL,
  `avaliacao_reserva` VARCHAR(45) NOT NULL,
  `obs_reserva` VARCHAR(100) NOT NULL,
  `confirmacao_reserva` VARCHAR(1) NOT NULL DEFAULT 'P',
  `fim_reserva` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`nid_reserva`),
  UNIQUE INDEX `nidreserva_UNIQUE` (`nid_reserva` ASC) VISIBLE,
  INDEX `fk_treserva_testabelecimento1_idx` (`testabelecimento_nid_estabelecimento` ASC) VISIBLE,
  INDEX `fk_treserva_tusuario1_idx` (`tusuario_nid_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_treserva_testabelecimento1`
    FOREIGN KEY (`testabelecimento_nid_estabelecimento`)
    REFERENCES `mydb`.`testabelecimento` (`nid_estabelecimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_treserva_tusuario1`
    FOREIGN KEY (`tusuario_nid_usuario`)
    REFERENCES `mydb`.`tusuario` (`nid_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Inserindo registros na tabela tendereco
INSERT INTO tendereco (rua_endereco, num_endereco, cep_endereco, bairro_endereco, municipio_endereco, tipousuario_endereco) 
VALUES ('Rua A', '123', '12345-678', 'Bairro A', 'Cidade A', 0),
       ('Rua B', '456', '98765-432', 'Bairro B', 'Cidade B', 0),
       ('Rua C', '789', '54321-876', 'Bairro C', 'Cidade C', 0),
       ('Rua D', '123', '12345-678', 'Bairro D', 'Cidade D', 0),
       ('Rua E', '456', '98765-432', 'Bairro E', 'Cidade E', 1),
       ('Rua F', '789', '54321-876', 'Bairro F', 'Cidade F', 1),
       ('Rua G', '101', '13579-642', 'Bairro G', 'Cidade G', 1),
       ('Rua H', '101', '13579-642', 'Bairro H', 'Cidade H', 1);

-- Inserindo registros na tabela tusuario
INSERT INTO tusuario (tendereco_nid_endereco, cpf_usuario, nome_usuario, sobren_usuario, nasc_usuario, cel_usuario, email_usuario, senha_usuario) 
VALUES (1, '123.456.789-00', 'Usuário 1', 'Sobrenome 1', '1990-01-01', '98765-4321', 'usuario1@example.com', 'senha1'),
       (2, '987.654.321-00', 'Usuário 2', 'Sobrenome 2', '1985-05-05', '12345-6789', 'usuario2@example.com', 'senha2'),
       (3, '111.222.333-00', 'Usuário 3', 'Sobrenome 3', '2000-10-10', '55555-5555', 'usuario3@example.com', 'senha3'),
       (4, '444.555.666-00', 'Usuário 4', 'Sobrenome 4', '1975-12-25', '99999-9999', 'usuario4@example.com', 'senha4');

-- Inserindo registros na tabela tservico
INSERT INTO tservico (wifi_servicos, ar_servicos, pet_servicos, couvert_servicos, estacionamento_servicos, kids_servicos, arlivre_servicos, deficiente_servicos, fumante_servicos, selfservice_servicos, rodizio_servicos) 
VALUES (1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0),
       (0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1),
       (1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0),
       (0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0);

-- Inserindo registros na tabela tculinaria
INSERT INTO tculinaria (italiana, japonesa, nordestina, mexicana, pizzaria, mineira, chinesa, arabe, grega, francesa, coreana) 
VALUES (1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0),
       (0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1),
       (1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0),
       (0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0);

-- Inserindo registros na tabela testabelecimento
INSERT INTO testabelecimento (tendereco_nid_endereco, tservicos_nid_servicos, tculinaria_nid_culinaria, ninscr_estabelecimento, nomeemp_estabelecimento, nomefantasia_estabelecimento, nomeresp_estabelecimento, email_estabelecimento, tel_estabelecimento, nlugares_estabelecimento, cheio_estabelecimento) 
VALUES (5, 1, 1, '123456', 'Restaurante A', 'Restaurante do João', 'João', 'restaurantea@example.com', '1111-1111', '100', 0),
       (6, 2, 2, '654321', 'Restaurante B', 'Restaurante da Maria', 'Maria', 'restauranteb@example.com', '2222-2222', '150', 0),
       (7, 3, 3, '987654', 'Restaurante C', 'Restaurante da Ana', 'Ana', 'restaurantec@example.com', '3333-3333', '80', 0),
       (8, 4, 4, '123987', 'Restaurante D', 'Restaurante do José', 'José', 'restauranted@example.com', '4444-4444', '120', 1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
