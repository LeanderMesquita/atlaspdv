CREATE TABLE drink (
    id INT PRIMARY KEY,
    volume INT,
    alcoolico BOOLEAN,
    teor_alcoolico NUMERIC(5, 2),
    gaseificada BOOLEAN,
    FOREIGN KEY (id) REFERENCES item (id) ON DELETE CASCADE
);
