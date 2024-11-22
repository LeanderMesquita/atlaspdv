CREATE TABLE comida (
    id INT PRIMARY KEY,
    porcao INT,
    rotulos rotulo[],
    FOREIGN KEY (id) REFERENCES item (id) ON DELETE CASCADE
);
