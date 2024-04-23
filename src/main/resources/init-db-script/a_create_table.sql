CREATE TABLE todo
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    body      VARCHAR(255) NULL,
    subject   VARCHAR(255) NULL,
    completed BIT          NULL
);