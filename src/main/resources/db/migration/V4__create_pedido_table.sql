CREATE TABLE pedido (
    id UUID PRIMARY KEY,
    mesa_id INT NOT NULL,
    funcionario_id UUID NOT NULL,
    hora_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    hora_cancelamento TIMESTAMP,
    valor_pedido DOUBLE PRECISION DEFAULT 0.0,
    FOREIGN KEY (mesa_id) REFERENCES mesa (id) ON DELETE CASCADE,
    FOREIGN KEY (funcionario_id) REFERENCES funcionario (id) ON DELETE SET NULL
);
