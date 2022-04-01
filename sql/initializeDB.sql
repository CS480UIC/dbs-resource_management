
CREATE DATABASE IF NOT EXISTS resource_management;

use resource_management;

CREATE TABLE school (
code VARCHAR(7),
name VARCHAR(50) NOT NULL,
address VARCHAR(100) NOT NULL,
head VARCHAR (20) NOT NULL,
login_id VARCHAR(10) NOT NULL UNIQUE,
password VARCHAR(12) NOT NULL,
PRIMARY KEY(code));

CREATE TABLE resource (
id VARCHAR(7),
school_code VARCHAR (7) NOT NULL UNIQUE,
resource_name VARCHAR(20) NOT NULL,
resource_location VARCHAR(50) NOT NULL,
full_capacity SMALLINT UNSIGNED NOT NULL,
available_capacity SMALLINT UNSIGNED NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (school_code) REFERENCES school(code)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT chk_fullc CHECK (full_capacity >0));

CREATE TABLE booking_employee (
user_id VARCHAR(7),
school_code VARCHAR(7) NOT NULL,
employee_name VARCHAR(20) NOT NULL,
password VARCHAR(12) NOT NULL,
PRIMARY KEY (user_id),
FOREIGN KEY (school_code) REFERENCES school(code)
ON DELETE CASCADE
ON UPDATE CASCADE);

CREATE TABLE booking (
booking_id VARCHAR(7),
employee_user_id VARCHAR(7) NOT NULL,
resource_id VARCHAR(7) NOT NULL,
booked_capacity SMALLINT UNSIGNED NOT NULL,
booking_slot DATETIME NOT NULL,
number_of_hours TINYINT UNSIGNED NOT NULL,
notes VARCHAR(150),
PRIMARY KEY(booking_id),
FOREIGN KEY (employee_user_id) REFERENCES booking_employee(user_id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (resource_id) REFERENCES resource(id)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT chk_bookc CHECK (booked_capacity > 0),
CONSTRAINT chk_noh CHECK (number_of_hours > 0));

CREATE TABLE booking_employee_grade (
grade TINYINT UNSIGNED NOT NULL,
booking_employee_user_id VARCHAR(7) NOT NULL,
PRIMARY KEY(grade, booking_employee_user_id),
FOREIGN KEY (booking_employee_user_id) REFERENCES booking_employee(user_id));

CREATE TABLE user
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);

