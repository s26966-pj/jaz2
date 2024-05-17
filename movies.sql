CREATE TABLE movies (
	id int not null auto_increment,
    name varchar(255) not null,
    category enum("horror", "drama", "comedy", "criminal") not null,
    primary key (id)
);

INSERT INTO movies (id, name, category) 
VALUES
(null, 'm1','comedy'),
(null,'m2','criminal'),
(null,'m3','horror');