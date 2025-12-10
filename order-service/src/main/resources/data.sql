-- Sample SQL for products table (PostgreSQL-compatible)
-- Creates a products table and inserts several sample rows for local testing

-- CREATE TABLE IF NOT EXISTS products (
--     product_id VARCHAR(255) PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     price_amount INTEGER(19,2) NOT NULL
-- );

-- Sample data
INSERT INTO product (product_id, name, price) VALUES
    ('P-001', 'Coke', 1500),
    ('P-002', 'Burger', 5000),
    ('P-003', 'Fries', 2500),
    ('P-004', 'Pizza', 8500),
    ('P-005', 'Salad', 4250);

-- Notes:
-- For H2: change NUMERIC to DECIMAL if preferred.
-- For UUID keys, adjust product_id type to UUID and populate accordingly.

