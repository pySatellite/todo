CREATE TABLE todos (
	id 	INT NOT NULL AUTO_INCREMENT,
	subject VARCHAR(50),
	body VARCHAR(50),
	completed TINYINT(1),
	PRIMARY KEY(id)
);