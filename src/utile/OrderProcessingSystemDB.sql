CREATE DATABASE OrderProcessingSystemDB;

USE OrderProcessingSystemDB;

-- Table for Customers
CREATE TABLE customers (
                           customer_id VARCHAR(20) PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           phone VARCHAR(15) NOT NULL
);

-- Table for Orders (Empty for now)
CREATE TABLE orders (
                        order_id VARCHAR(20) PRIMARY KEY,
                        customer_id VARCHAR(20),
                        order_date DATETIME NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insert data into Customers
INSERT INTO customers (customer_id, name, email, phone)
VALUES
    ('CUST001', 'Alice Johnson', 'alice.johnson@example.com', '+1234567890'),
    ('CUST002', 'Bob Williams', 'bob.williams@example.com', '+1234567891'),
    ('CUST003', 'Charlie Brown', 'charlie.brown@example.com', '+1234567892'),
    ('CUST004', 'Diana Ross', 'diana.ross@example.com', '+1234567893'),
    ('CUST005', 'Elliot Page', 'elliot.page@example.com', '+1234567894');
