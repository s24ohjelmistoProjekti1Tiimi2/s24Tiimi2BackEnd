-- CREATE MANUFACTURER TABLE
CREATE TABLE IF NOT EXISTS manufacturer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

INSERT INTO manufacturer (name) VALUES ('Rukka') , ('Pomppa'), ('Orra'), ('Hurtta');



-- CREATE TYPE TABLE
CREATE TABLE IF NOT EXISTS type (
  id BIGSERIAL PRIMARY KEY,
  type_name VARCHAR(50) NOT NULL
);
INSERT INTO type (type_name) VALUES ('Clothes'), ('Toys'), ('Food');


-- CREATE PRODUCT TABLE
CREATE TABLE IF NOT EXISTS product (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  type_id BIGINT NOT NULL,
  color VARCHAR(50),
  size VARCHAR(50),
  price DECIMAL(10, 2) NOT NULL,
  manufacturer_id BIGINT NOT NULL,
  FOREIGN KEY (type_id) REFERENCES Type(id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);
INSERT INTO product (name, type_id, color, size, price, manufacturer_id) VALUES ('Sparkling Shoes', 1, 'Black', 'S', 5, 2), 
('Chewable joy', 1, 'Multicolor', 'XS', 10, 1), 
('Jacket', 1, 'Yellow', 'M', 5, 2);