CREATE DATABASE IF NOT EXISTS `sharaz`;

USE `sharaz`;

CREATE TABLE IF NOT EXISTS `admin`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`admin_id` VARCHAR(15),
`admin_password` VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS `cashier`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`cashier_id` VARCHAR(15),
`first_name` VARCHAR(25),
`last_name` VARCHAR(25),
`phone_number` VARCHAR(15),
`address` TEXT,
`date_joined` DATE,
`avatar` LONGBLOB,
`password` VARCHAR(20) DEFAULT "1234"
);

CREATE TABLE IF NOT EXISTS `meals`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`meal_id` VARCHAR(15),
`meal_title` VARCHAR(30),
`meal_description` VARCHAR(50),
`meal_price` VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS `sales`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`meal_id` VARCHAR(15),
`cashier_id` VARCHAR(15),
`quantity` VARCHAR(10),
`amount` VARCHAR(10),
`date_time` DATE
);

CREATE TABLE IF NOT EXISTS `cart`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`meal_id` VARCHAR(15),
`cashier_id` VARCHAR(15),
`quantity` VARCHAR(10),
`subtotal` VARCHAR(50)
);

-- POPULATE ADMIN TABLE
INSERT INTO `admin`(admin_id, admin_password) VALUES ("SHA/ADM/101", "sharazceo");
INSERT INTO `admin`(admin_id, admin_password) VALUES ("SHA/ADM/102", "sharazgeneralmanager");
INSERT INTO `admin`(admin_id, admin_password) VALUES ("SHA/ADM/103", "sharazmanager");
INSERT INTO `admin`(admin_id, admin_password) VALUES ("admin", "admin");

-- POPULATE SALES TABLE

INSERT INTO `sales`(meal_id, cashier_id, quantity, amount, date_time) VALUES("SHA/MEAL/101", "SHA/CSH/102", "3", "1500", "2021-01-23");
INSERT INTO `sales`(meal_id, cashier_id, quantity, amount, date_time) VALUES("SHA/MEAL/101", "SHA/CSH/102", "5", "2500", "2021-01-23");
INSERT INTO `sales`(meal_id, cashier_id, quantity, amount, date_time) VALUES("SHA/MEAL/102", "SHA/CSH/102", "1", "500", "2021-01-23");

