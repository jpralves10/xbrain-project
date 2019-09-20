/*DROP TABLE IF EXISTS Pedido;
DROP TABLE IF EXISTS Produto;
DROP TABLE IF EXISTS Cliente;

/*CREATE TABLE Cliente(
	idCliente INT PRIMARY KEY,
	nome VARCHAR(255)
);

CREATE TABLE Produto(
	idProduto INT PRIMARY KEY,
	descricao VARCHAR(255)
);

CREATE TABLE Pedido(
	idCliente INT,
	idProduto INT,
	valorTotal NUMERIC(8,2),
	enderecoEntrega VARCHAR(255),
	
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
	FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);

INSERT INTO Cliente VALUES(1, 'Pedro Batista Nascimento');
INSERT INTO Cliente VALUES(2, 'Juliete Ferreira Santos');
INSERT INTO Produto VALUES(1, 'Roda Aro 17');

INSERT INTO Pedido VALUES(1, 1, 10.5, 'Avenida Maritacas 359');
INSERT INTO Pedido VALUES(2, 1, 12, 'Avenida Higienopolis 225');

/*INSERT INTO xbraindb (idCliente, idProduto, valorTotal, enderecoEntrega) VALUES (1, 1, 10.5, 'Avenida Maritacas 359')*/