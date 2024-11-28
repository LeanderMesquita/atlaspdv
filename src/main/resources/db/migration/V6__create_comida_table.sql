CREATE TABLE comida (
    id INT PRIMARY KEY,
    porcao INT,
    rotulos SMALLINT[],
    FOREIGN KEY (id) REFERENCES item (id) ON DELETE CASCADE
);
