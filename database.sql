CREATE DATABASE IF NOT EXISTS `sharaz`;

USE `sharaz`;

CREATE TABLE IF NOT EXISTS `admin`(
`entry_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`admin_id` VARCHAR(15),
`admin_password` VARCHAR(15)
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
`password` VARCHAR(15)
);