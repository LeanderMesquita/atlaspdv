CREATE SEQUENCE item_sequence;

CREATE TABLE item (
    id INT PRIMARY KEY DEFAULT NEXTVAL('item_sequence'),
    preco NUMERIC(10, 2) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    em_estoque BOOLEAN DEFAULT TRUE,
    quantidade_em_estoque INT NOT NULL,
    criado_em DATE DEFAULT CURRENT_DATE,
    atualizado_em DATE DEFAULT CURRENT_DATE,
    medida medida NOT NULL
);

ALTER SEQUENCE item_sequence OWNED BY item.id;
