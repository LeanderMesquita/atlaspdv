CREATE TABLE item_pedido (
    id SERIAL PRIMARY KEY,
    pedido_id UUID NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido (id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item (id) ON DELETE CASCADE
);
