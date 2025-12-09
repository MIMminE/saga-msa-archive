-- Sample SQL for products table (PostgreSQL-compatible)
-- Creates a products table and inserts several sample rows for local testing

CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price_amount NUMERIC(19,2) NOT NULL
);

-- Sample data
INSERT INTO products (product_id, name, price_amount) VALUES
    ('P-001', 'Coke', 1.50),
    ('P-002', 'Burger', 5.00),
    ('P-003', 'Fries', 2.50),
    ('P-004', 'Pizza', 8.50),
    ('P-005', 'Salad', 4.25);

-- Notes:
-- For H2: change NUMERIC to DECIMAL if preferred.
-- For UUID keys, adjust product_id type to UUID and populate accordingly.

