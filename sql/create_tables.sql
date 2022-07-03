-- DROP TABLE contrato_locacao;

CREATE TABLE contrato_locacao (
	id bigserial NOT NULL,
	check_in timestamp NULL,
	check_out timestamp NULL,
	dias_locacao int4 NULL,
	quant_pessoa varchar(255) NULL,
	valor_locacao int4 NULL,
	imovel_id int8 NULL,
	CONSTRAINT contrato_locacao_pkey PRIMARY KEY (id)
);

-- DROP TABLE documento_imovel;

CREATE TABLE documento_imovel (
	id bigserial NOT NULL,
	documento varchar(255) NULL,
	imovel_id int8 NULL,
	CONSTRAINT documento_imovel_pkey PRIMARY KEY (id)
);

-- DROP TABLE endereco;

CREATE TABLE endereco (
	id bigserial NOT NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	complemento varchar(255) NULL,
	logradouro varchar(255) NULL,
	nacionalidade varchar(255) NULL,
	numero varchar(255) NULL,
	ponto_referencia varchar(255) NULL,
	uf varchar(255) NULL,
	pessoa_id int8 NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (id)
);

-- DROP TABLE foto_imovel;

CREATE TABLE foto_imovel (
	id bigserial NOT NULL,
	foto varchar(255) NULL,
	imovel_id int8 NULL,
	CONSTRAINT foto_imovel_pkey PRIMARY KEY (id)
);

-- DROP TABLE imovel;

CREATE TABLE imovel (
	id bigserial NOT NULL,
	area_lazer bool NULL,
	area_m2 int4 NULL,
	climatizado varchar(255) NULL,
	piscina bool NULL,
	quant_quartos int4 NULL,
	quant_suite int4 NULL,
	status_ocupacao varchar(255) NULL,
	endereco_id int8 NULL,
	CONSTRAINT imovel_pkey PRIMARY KEY (id)
);

-- DROP TABLE locacao;

CREATE TABLE locacao (
	id bigserial NOT NULL,
	status_locacao varchar(255) NULL,
	contrato_locacao_id int8 NULL,
	imovel_id int8 NULL,
	usuario_id int8 NULL,
	CONSTRAINT locacao_pkey PRIMARY KEY (id)
);

-- DROP TABLE localizacao;

CREATE TABLE localizacao (
	id bigserial NOT NULL,
	latitude varchar(255) NULL,
	longitude varchar(255) NULL,
	imovel_id int8 NULL,
	parceiro_id int8 NULL,
	CONSTRAINT localizacao_pkey PRIMARY KEY (id)
);

-- DROP TABLE parceiro;

CREATE TABLE parceiro (
	id bigserial NOT NULL,
	cnpj varchar(255) NULL,
	descricao varchar(255) NULL,
	nome_fantasia varchar(255) NULL,
	usuario_id int8 NULL,
	CONSTRAINT parceiro_pkey PRIMARY KEY (id)
);

-- DROP TABLE pessoa;

CREATE TABLE pessoa (
	id bigserial NOT NULL,
	cnpj varchar(255) NULL,
	cpf varchar(255) NULL,
	data_nascimento timestamp NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	usuario_id int8 NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);

-- DROP TABLE usuario;
CREATE TABLE usuario (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	senha varchar(255) NULL,
	pessoa_id int8 NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);


-- contrato_locacao foreign keys

ALTER TABLE contrato_locacao ADD CONSTRAINT imovel_id FOREIGN KEY (imovel_id) REFERENCES imovel(id);


-- documento_imovel foreign keys

ALTER TABLE documento_imovel ADD CONSTRAINT imovel_id FOREIGN KEY (imovel_id) REFERENCES imovel(id);

-- endereco foreign keys

ALTER TABLE endereco ADD CONSTRAINT pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);

-- foto_imovel foreign keys

ALTER TABLE foto_imovel ADD CONSTRAINT imovel_id FOREIGN KEY (imovel_id) REFERENCES imovel(id);

-- imovel foreign keys

ALTER TABLE imovel ADD CONSTRAINT endereco_id FOREIGN KEY (endereco_id) REFERENCES endereco(id);

-- locacao foreign keys

ALTER TABLE locacao ADD CONSTRAINT contrato_locacao_id FOREIGN KEY (contrato_locacao_id) REFERENCES contrato_locacao(id);
ALTER TABLE locacao ADD CONSTRAINT usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE locacao ADD CONSTRAINT imovel_id FOREIGN KEY (imovel_id) REFERENCES imovel(id);

-- localizacao foreign keys

ALTER TABLE localizacao ADD CONSTRAINT imovel_id FOREIGN KEY (imovel_id) REFERENCES imovel(id);
ALTER TABLE localizacao ADD CONSTRAINT parceiro_id FOREIGN KEY (parceiro_id) REFERENCES parceiro(id);

-- parceiro foreign keys

ALTER TABLE parceiro ADD CONSTRAINT usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id);

-- pessoa foreign keys

ALTER TABLE pessoa ADD CONSTRAINT usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id);

-- usuario foreign keys

ALTER TABLE usuario ADD CONSTRAINT pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);