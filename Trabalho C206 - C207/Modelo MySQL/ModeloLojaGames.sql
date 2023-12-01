-- Dropa o banco de dados se existir
DROP DATABASE IF EXISTS lojaGames;

-- Cria o banco de dados
CREATE DATABASE lojaGames;

-- Seleciona o banco de dados recém-criado
USE lojaGames;

-- Tabela para mídia física
CREATE TABLE MidiaFisica (
    nome varchar(45),
    codigoDeBarra varchar(45) PRIMARY KEY NOT NULL,
    estoque int,
    preco float,
    classificacaoIndicativa int,
    estudio varchar(45),
    console varchar(45),
    usado bool
);

-- Tabela para mídia digital
CREATE TABLE MidiaDigital (
    nome varchar(45),
    codigoDeBarra varchar(45) PRIMARY KEY NOT NULL,
    estoque int,
    preco float,
    classificacaoIndicativa int,
    estudio varchar(45),
    console varchar(45),
    anoExpiracao int
);

-- Tabela para edição de colecionador
CREATE TABLE EdicaoColecionador (
    nome varchar(45),
    codigoDeBarra varchar(45) PRIMARY KEY NOT NULL,
    estoque int,
    preco float,
    classificacaoIndicativa int,
    estudio varchar(45),
    console varchar(45),
    figure bool,
    steelbook bool,
    ost bool
);

-- Tabela para boneco
CREATE TABLE Boneco (
    nome varchar(45),
    codigoDeBarra varchar(45) PRIMARY KEY NOT NULL,
    estoque int,
    preco float,
    tamanho int
);

CREATE TABLE Vendedor (
	nome varchar(45),
    bonus float,
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT
);

CREATE TABLE Cliente (
    nome varchar(45),
    telefone varchar(45) PRIMARY KEY NOT NULL,
    id_Vendedor int,
    FOREIGN KEY (id_Vendedor) REFERENCES Vendedor(id)
);