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
-- Data Instances
  INSERT INTO student(student_id, first_name, last_name, email, password, major, year_id)
  VALUES(1, 'test', 'user', 'test@testing.com', '123', 'Biology', 2);
  
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
-- Data Instances
  INSERT INTO course(course_id, name)
  VALUES(1, 'Intro to Biology'),
  (2, 'Anatomy'),
  (3, 'Statistics'),
  (4, 'Calculus'),
  (5, 'Physiology'),
  (6, 'Kinematics'),
  (7, 'Chemistry'),
  (8, 'Engineering Reports'),
  (9, 'English'),
  (10, 'History'),
  (11, 'Computer Networks'),
  (12, 'Thermodynamics'),
  (13, 'Senior Design Project'),
  (14, 'Enviromental Sciences'),
  (15, 'Organic Chemistry'),
  (16, 'Electricity and Magnetism'),
  (17, 'Human Genetics'),
  (18, 'Microbiology'),
  (19, 'Spanish'),
  (20, 'Music Theory'),
  (21, 'French'),
  (22, 'Physical Education'),
  (23, 'Object Orientated Design'),
  (24, 'Data Structures and Algorithms'),
  (25, 'Operating Systems'),
  (26, 'Quality Engineering'),
  (27, 'Assembly'),
  (28, 'Public Speaking'),
  (29, 'Geology'),
  (30, 'Art History'),
  (31, 'Dance Appreciation'),
  (32, 'Film Studies'),
  (33, 'Philosophy'),
  (34, 'Evolution'),
  (35, 'Biochemistry'),
  (36, 'Marine Biology'),
  (37, 'Molecular Biology'),
  (38, 'Neuroscience'),
  (39, 'Anthropology'),
  (40, 'Individual Studies'),
  (41, 'Ethics'),
  (42, 'Aerodynamics'),
  (43, 'Structural Analysis'),
  (44, 'Circuits and Systems'),
  (45, 'Network Security'),
  (46, 'Accounting'),
  (47, 'Project Management'),
  (48, 'Marketing'),
  (49, 'Data Anaylsis'),
  (50, 'Product Development');


-- Table for major (Entity Set)
CREATE TABLE major (
  major_id INT UNSIGNED NOT NULL, 
  name VARCHAR(32) NOT NULL,
  PRIMARY KEY (major_id)) ENGINE=InnoDB;
  INSERT INTO major(major_id, name)
  VALUES(1, 'Biology'),
  (2, 'Engineering'),
  (3, 'Business'),
  (4, 'Other');
  
-- Table for major courses (Relationship)
CREATE TABLE major_course (
  major_id INT UNSIGNED NOT NULL, 
  course_id INT UNSIGNED NOT NULL,
  year_id INT UNSIGNED NOT NULL,
  FOREIGN KEY(major_id) REFERENCES major(major_id),
  FOREIGN KEY(course_id) REFERENCES course(course_id),
  FOREIGN KEY(year_id) REFERENCES year(year_id)) ENGINE=InnoDB;
-- Data Instances
  INSERT INTO major_course(major_id, course_id, year_id)
  VALUES(1,1,1),
  (1,2,2),
  (4,3,3),
  (4,4,2),
  (1,5,2),
  (2,6,1),
  (2,7,3),
  (4,8,1),
  (4,9,1),
  (4,10,1),
  (2,11,4),
  (2,12,3),
  (4,13,4),
  (1,14,1),
  (1,15,3),
  (2,16,2),
  (1,17,3),
  (1,18,4),
  (4,19,1),
  (4,20,1),
  (4,21,1),
  (4,22,1),
  (2,23,2),
  (2,24,2),
  (2,25,4),
  (2,26,3),
  (2,27,3),
  (2,28,2),
  (4,29,2),
  (4,30,1),
  (4,31,1),
  (4,32,1),
  (4,33,2),
  (1,34,3),
  (1,35,4),
  (1,36,3),
  (1,37,4),
  (1,38,4),
  (1,39,2),
  (4,40,4),
  (4,41,2),
  (2,42,3),
  (2,43,2),
  (2,44,2),
  (2,45,3),
  (3,46,3),
  (3,47,3),
  (3,48,3),
  (2,49,3),
  (3,50,4);
  
-- Table for completed courses (Relationship)
CREATE TABLE student_course (
  student_id INT UNSIGNED NOT NULL, 
  course_id INT UNSIGNED NOT NULL,
  status VARCHAR(32) DEFAULT 'Incomplete',
  grade VARCHAR(6),
  FOREIGN KEY(student_id) REFERENCES student(student_id) ON DELETE CASCADE,
  FOREIGN KEY(course_id) REFERENCES course(course_id)) ENGINE=InnoDB;
  
