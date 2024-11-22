CREATE TABLE nao_manufaturados (
    id INT PRIMARY KEY,
    marca VARCHAR(255),
    tipo tag NOT NULL,
    FOREIGN KEY (id) REFERENCES item (id) ON DELETE CASCADE
);
