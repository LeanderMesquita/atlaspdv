CREATE SEQUENCE mesa_sequence;

CREATE TABLE mesa (
    id INT PRIMARY KEY DEFAULT NEXTVAL('mesa_sequence'),
    numeracao_mesa INT NOT NULL UNIQUE,
    permanencia TIMESTAMP,
    ocupada BOOLEAN DEFAULT FALSE,
    valor_total DOUBLE PRECISION DEFAULT 0.0
);

ALTER SEQUENCE mesa_sequence OWNED BY mesa.id;
