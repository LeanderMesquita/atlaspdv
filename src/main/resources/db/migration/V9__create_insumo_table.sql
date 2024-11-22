CREATE TABLE insumo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    item_relacionado INT,
    medida medida NOT NULL,
    quantidade INT NOT NULL,
    preco NUMERIC(10, 2),
    FOREIGN KEY (item_relacionado) REFERENCES item (id) ON DELETE SET NULL
);
