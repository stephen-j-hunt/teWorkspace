DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS artworks;
DROP TABLE IF EXISTS artists;

CREATE TABLE customers (
	customer_id	SERIAL NOT NULL
	, name VARCHAR(50) 		NOT NULL
	, address VARCHAR(50)	NOT NULL
	, phone VARCHAR(20)		NOT NULL
	
	, CONSTRAINT pk_customers PRIMARY KEY (customer_id)
);

CREATE TABLE artists (
	artist_id SERIAL NOT NULL PRIMARY KEY
	, first_name VARCHAR(25) NOT NULL
	, last_name VARCHAR(25) NOT NULL
);

CREATE TABLE artworks (
	art_id SERIAL NOT NULL PRIMARY KEY
	, title VARCHAR(100) NOT NULL
	, artist_id INT NOT NULL
	
	, CONSTRAINT fk_artworks_artist FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

CREATE TABLE purchases (
	purchase_id SERIAL NOT NULL PRIMARY KEY
	, customer_id INT NOT NULL 
	, art_id INT NOT NULL 
	, price MONEY NOT NULL
	, purchase_date TIMESTAMP NOT NULL
	
	, CONSTRAINT fk_purchases_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
	, CONSTRAINT fk_purchases_artworks FOREIGN KEY (art_id) REFERENCES artworks(art_id)
);

ALTER TABLE purchases
	ADD COLUMN delivery_date TIMESTAMP NULL;

ALTER TABLE purchases
	ADD CONSTRAINT ck_delivery_date CHECK (delivery_date IS NULL OR delivery_date >= purchase_date);

