DROP SCHEMA IF EXISTS course_manager;
CREATE SCHEMA course_manager;
USE course_manager;

-- Table for student (Entity Set) 
CREATE TABLE student (
  student_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(32) NOT NULL,
  last_name VARCHAR(32) NOT NULL,
  email VARCHAR(256) NOT NULL,
  password VARCHAR(64) UNIQUE NOT NULL, 
  major VARCHAR(32) NOT NULL,
  year_id INT UNSIGNED NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (student_id)) ENGINE=InnoDB;
  
-- Table for year (Entity Set)
CREATE TABLE year (
  year_id INT UNSIGNED NOT NULL, 
  name VARCHAR(32) NOT NULL,
  PRIMARY KEY (year_id)) ENGINE=InnoDB;
-- Data Instances
  INSERT INTO year(year_id, name)
  VALUES(1, 'Freshman'),
  (2, 'Sophomore'),
  (3, 'Junior'),
  (4, 'Senior');

-- Table for course (Entity Set)
CREATE TABLE course (
  course_id INT UNSIGNED NOT NULL, 
  name VARCHAR(32) NOT NULL,
  PRIMARY KEY (course_id)) ENGINE=InnoDB;

-- Table for major (Entity Set)
CREATE TABLE major (
  major_id INT UNSIGNED NOT NULL, 
  name VARCHAR(32) NOT NULL,
  PRIMARY KEY (major_id)) ENGINE=InnoDB;
  
-- Table for major courses (Relationship)
CREATE TABLE major_course (
  major_id INT UNSIGNED NOT NULL, 
  course_id INT UNSIGNED NOT NULL,
  FOREIGN KEY(major_id) REFERENCES major(major_id),
  FOREIGN KEY(course_id) REFERENCES course(course_id)) ENGINE=InnoDB;

  
