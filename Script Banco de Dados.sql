CREATE TABLE escritorio (
id_escritorio int primary key,
nome_escritorio varchar (60)
);

CREATE TABLE natureza (
id_natureza int primary key,
natureza varchar (40)
);

CREATE TABLE tipo_acao (
id_tipo_acao int primary key,
tipo_acao varchar (60)
);

CREATE TABLE funcao (
id_funcao int primary key,
funcao varchar (60)
);

CREATE TABLE tribunal (
id_tribunal int primary key,
tribunal_origem int (10)
);

CREATE TABLE tipo_pedido (
id_tipo_pedido int primary key,
pedido varchar (80)
);

INSERT INTO tipo_pedido (id_tipo_pedido, pedido) VALUES 
(1, "Hora Extra"),
(2, "DSR"),
(3, "Desconfiguração de Justa Causa"),
(4, "Acidente de Trabalho"),
(5, "Verbas Rescisórias"),
(6, "Aviso Prévio"),
(7, "Adicional de Periculosidade"),
(8, "Intervalo Intrajornada"),
(9, "Adicional de Insalubridade"),
(10, "Comissões");

CREATE TABLE fase_processual (
id_fase_processual int primary key,
fase_processual varchar (60)
);

CREATE TABLE classificacao_risco (
id_classificacao_risco int primary key,
classificacao_risco varchar (60)
);

CREATE TABLE vara (
id_vara int primary key,
vara varchar (160)
);

CREATE TABLE processo (
id_processo int primary KEY GENERATED ALWAYS AS IDENTITY,
escritorio int,
reclamada varchar (160),
natureza int,
autor varchar (160),
reu varchar (160),
tipo_acao int,
funcao int,
admissao date, 
demissao date, 
numero_processo varchar (160),
tribunal int,
estado varchar (10),
cidade_origem varchar (80),
vara int,
data_ajuizamento date,
tipo_pedido int,
ultimos_andamentos_processuais varchar (160),
fase_processual int,
valor_causa int (30),
valor_perda_estimado int (30),
classificacao_risco varchar (60),
deposito_recursal_ordinario int (30),
data_deposito_recursal_ordinario date,
deposito_recursal_revista int (30),
data_deposito_recursal_revista date,
deposito_judicial int (30),
data_deposito_judicial date,
bloqueio_judicial int (30),
data_bloquei_judicial date,
foreign key (escritorio) references escritorio(id_escritorio),
foreign key (natureza) references natureza(id_natureza),
foreign key (tipo_acao) references tipo_acao(id_tipo_acao),
foreign key (funcao) references funcao(id_funcao),
foreign key (tribunal) references tribunal(id_tribunal),
foreign key (vara) references vara(id_vara),
foreign key (tipo_pedido) references tipo_pedido(id_tipo_pedido),
foreign key (fase_processual) references fase_processual(id_fase_processual)
);

CREATE TABLE pedido (
id_pedido int GENERATED ALWAYS AS IDENTITY,
id_tipo_pedido int,
id_processo int,
pedido_ganho_primeira_instancia boolean,
pedido_ganho_segunda_instancia boolean,
pedido_ganho_terceirara_instancia boolean,
foreign key (id_tipo_pedido) references tipo_pedido(id_tipo_pedido),
foreign key (id_processo) references processo(id_processo)
);

ALTER TABLE `dbprocess`.`processo` 
DROP FOREIGN KEY `processo_ibfk_1`,
DROP FOREIGN KEY `processo_ibfk_2`,
DROP FOREIGN KEY `processo_ibfk_3`,
DROP FOREIGN KEY `processo_ibfk_4`,
DROP FOREIGN KEY `processo_ibfk_5`,
DROP FOREIGN KEY `processo_ibfk_7`,
DROP FOREIGN KEY `processo_ibfk_8`;
ALTER TABLE `dbprocess`.`processo` 
CHANGE COLUMN `escritorio` `id_escritorio` INT NULL DEFAULT NULL ,
CHANGE COLUMN `natureza` `id_natureza` INT NULL DEFAULT NULL ,
CHANGE COLUMN `tipo_acao` `id_tipo_acao` INT NULL DEFAULT NULL ,
CHANGE COLUMN `funcao` `id_funcao` INT NULL DEFAULT NULL ,
CHANGE COLUMN `tribunal` `id_tribunal` INT NULL DEFAULT NULL ,
CHANGE COLUMN `tipo_pedido` `id_pedido` INT NULL DEFAULT NULL ,
CHANGE COLUMN `fase_processual` `id_fase_processual` INT NULL DEFAULT NULL ,
CHANGE COLUMN `valor_causa` `valor_causa` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `valor_perda_estimado` `valor_perda_estimado` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `deposito_recursal_ordinario` `deposito_recursal_ordinario` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `deposito_recursal_revista` `deposito_recursal_revista` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `deposito_judicial` `deposito_judicial` DOUBLE NULL DEFAULT NULL ;
ALTER TABLE `dbprocess`.`processo` 
ADD CONSTRAINT `processo_ibfk_1`
  FOREIGN KEY (`id_escritorio`)
  REFERENCES `dbprocess`.`escritorio` (`id_escritorio`),
ADD CONSTRAINT `processo_ibfk_2`
  FOREIGN KEY (`id_natureza`)
  REFERENCES `dbprocess`.`natureza` (`id_natureza`),
ADD CONSTRAINT `processo_ibfk_3`
  FOREIGN KEY (`id_tipo_acao`)
  REFERENCES `dbprocess`.`tipo_acao` (`id_tipo_acao`),
ADD CONSTRAINT `processo_ibfk_4`
  FOREIGN KEY (`id_funcao`)
  REFERENCES `dbprocess`.`funcao` (`id_funcao`),
ADD CONSTRAINT `processo_ibfk_5`
  FOREIGN KEY (`id_tribunal`)
  REFERENCES `dbprocess`.`tribunal` (`id_tribunal`),
ADD CONSTRAINT `processo_ibfk_7`
  FOREIGN KEY (`id_pedido`)
  REFERENCES `dbprocess`.`tipo_pedido` (`id_tipo_pedido`),
ADD CONSTRAINT `processo_ibfk_8`
  FOREIGN KEY (`id_fase_processual`)
  REFERENCES `dbprocess`.`fase_processual` (`id_fase_processual`);


ALTER TABLE `dbprocess`.`processo` 
DROP FOREIGN KEY `processo_ibfk_7`;
ALTER TABLE `dbprocess`.`processo` 
DROP COLUMN `id_pedido`,
DROP INDEX `processo_ibfk_7` ;
;

ALTER TABLE `dbprocess`.`tipo_pedido` 
CHANGE COLUMN `pedido` `descricao` VARCHAR(80) NULL DEFAULT NULL ;











