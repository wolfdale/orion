DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
uuid VARCHAR(50) PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
gender VARCHAR(50) NOT NULL,
credit_card VARCHAR(50) NOT NULL,
credit_card_type VARCHAR(50) NOT NULL
); 