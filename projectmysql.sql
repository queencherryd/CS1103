-- ===============================
-- TABLE CREATION 
-- ===============================
CREATE DATABASE University;
USE University;

CREATE TABLE Departments (
   Department_ID INT AUTO_INCREMENT PRIMARY KEY,
    Department_Name VARCHAR(100) NOT NULL
 );

CREATE TABLE Students (
    Student_ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Age INT,
    Email VARCHAR(100) UNIQUE,
    Department_ID INT,
    FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID)
);

CREATE TABLE Instructors (
    Instructor_ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Salary DECIMAL(10, 2),
    Department_ID INT,
    FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID)
);

CREATE TABLE Courses (
    Course_ID INT AUTO_INCREMENT PRIMARY KEY,
    Course_Name VARCHAR(100) NOT NULL,
    Credits INT,
    Instructor_ID INT,
    Department_ID INT,
    FOREIGN KEY (Instructor_ID) REFERENCES Instructors(Instructor_ID),
    FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID)
);

CREATE TABLE Enrollments (
    Enrollment_ID INT AUTO_INCREMENT PRIMARY KEY,
    Student_ID INT,
    Course_ID INT,
    Semester CHAR,
    Year INT,
    Grade CHAR(2),
    FOREIGN KEY (Student_ID) REFERENCES Students(Student_ID),
    FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
);

-- ===============================
-- INSERT TEST DATA
-- ===============================

-- Insert into Departments
INSERT INTO Departments (Department_Name) VALUES 
('Computer Science'),
('Mathematics'),
('Physics');

-- Insert into Students
INSERT INTO Students (Name, Age, Email, Department_ID) VALUES
('Alice Johnson', 20, 'alice@univ.edu', 1),
('Bob Smith', 22, 'bob@univ.edu', 2),
('Charlie Lee', 21, 'charlie@univ.edu', 1),
('Diana Kim', 23, 'diana@univ.edu', 3),
('Edward Blake', 24, 'edward@univ.edu', 2),
('Fatima Noor', 20, 'fatima@univ.edu', 1),
('George Adebayo', 22, 'george@univ.edu', 3);

-- Insert into Instructors
INSERT INTO Instructors (Name, Salary, Department_ID) VALUES
('Dr. John Doe', 85000.00, 1),
('Dr. Linda Scott', 92000.00, 2),
('Dr. Rajiv Mehta', 78000.00, 3);

-- Insert into Courses
INSERT INTO Courses (Course_Name,credits , Instructor_ID, Department_ID) VALUES
('Data Structures', 3 , 1, 1),
('Linear Algebra', 4 , 2, 2),
('Quantum Mechanics', 4 , 3, 3),
('Algorithms', 2 , 1, 1),
('Database Systems', 3 , 1, 1),
('Statistical Methods', 4 , 2, 2);

-- Insert into Enrollments
INSERT INTO Enrollments (Student_ID, Course_ID, Semester, Year, Grade) VALUES
(1, 1, 'Fall', 2024, 'A'),
(2, 2, 'Winter', 2024, 'B'),
(3, 1, 'Fall', 2024, 'A'),
(3, 4, 'Winter', 2024, 'B'),
(4, 3, 'Fall', 2024, 'A'),
(5, 6, 'Winter', 2024,'B'),
(6, 1, 'Fall', 2024, 'A'),
(6, 5, 'Winter', 2024,'A'),
(7, 3, 'Fall', 2024, 'B'),
(2, 6, 'Fall', 2024,'A'),
(1, 5, 'Winer', 2024,'B');
