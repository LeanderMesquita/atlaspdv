CREATE TABLE item_insumo (
    item_id INT NOT NULL,
    insumo_id INT NOT NULL,
    PRIMARY KEY (item_id, insumo_id),
    FOREIGN KEY (item_id) REFERENCES item (id) ON DELETE CASCADE,
    FOREIGN KEY (insumo_id) REFERENCES insumo (id) ON DELETE CASCADE
);
