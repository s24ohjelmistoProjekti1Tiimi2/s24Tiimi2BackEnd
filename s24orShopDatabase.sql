CREATE TABLE IF NOT EXISTS Manufacturer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

INSERT INTO Manufacturer (name) VALUES ('Rukka') , ('Pomppa'), ('Orra'), ('Hurtta');

CREATE TABLE IF NOT EXISTS Type (
  id BIGSERIAL PRIMARY KEY,
  type_name VARCHAR(50) NOT NULL
);
INSERT INTO Type (type_name) VALUES ('Clothes'), ('Toys'), ('Food');

CREATE TABLE IF NOT EXISTS Product (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  type_id BIGINT NOT NULL,
  color VARCHAR(50),
  size VARCHAR(50),
  price DECIMAL(10, 2) NOT NULL,
  manufacturer_id BIGINT NOT NULL,
  FOREIGN KEY (type_id) REFERENCES Type(id),
  FOREIGN KEY (manufacturer_id) REFERENCES Manufacturer(id)
);
INSERT INTO Product (name, type_id, color, size, price, manufacturer_id) VALUES ('Sparkling Shoes', 1, 'Black', 'S', 5, 2), 
('Chewable joy', 1, 'Multicolor', 'XS', 10, 1), 
('Jacket', 1, 'Yellow', 'M', 5, 2);