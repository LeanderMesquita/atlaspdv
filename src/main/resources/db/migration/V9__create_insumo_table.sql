CREATE SEQUENCE insumo_sequence;

CREATE TABLE insumo (
    id INT PRIMARY KEY DEFAULT NEXTVAL('insumo_sequence'),
    nome VARCHAR(255) NOT NULL,
    item_relacionado INT,
    medida medida NOT NULL,
    quantidade INT NOT NULL,
    preco DOUBLE PRECISION,
    FOREIGN KEY (item_relacionado) REFERENCES item (id) ON DELETE SET NULL
);

ALTER SEQUENCE insumo_sequence OWNED BY insumo.id;
