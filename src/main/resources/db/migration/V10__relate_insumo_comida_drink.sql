ALTER TABLE comida ADD COLUMN insumo_id INT;
ALTER TABLE drink ADD COLUMN insumo_id INT;

ALTER TABLE comida ADD CONSTRAINT fk_comida_insumo FOREIGN KEY (insumo_id) REFERENCES insumo (id);
ALTER TABLE drink ADD CONSTRAINT fk_drink_insumo FOREIGN KEY (insumo_id) REFERENCES insumo (id);
