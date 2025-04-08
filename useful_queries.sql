
-- 1. List all students with their department names
SELECT s.Student_ID, s.Name, d.Department_Name
FROM Students s
JOIN Departments d ON s.Department_ID = d.Department_ID;

-- 2. List students enrolled in a specific course
SELECT s.Name, c.Course_Name
FROM Enrollments e
JOIN Students s ON e.Student_ID = s.Student_ID
JOIN Courses c ON e.Course_ID = c.Course_ID
WHERE c.Course_Name = 'Intro to CS';

-- 3. Find the average grade (as GPA-style letters) per student
SELECT Student_ID, AVG(
  CASE Grade
    WHEN 'A' THEN 4
    WHEN 'B' THEN 3
    WHEN 'C' THEN 2
    WHEN 'D' THEN 1
    ELSE 0
  END
) AS GPA
FROM Enrollments
GROUP BY Student_ID;

-- 4. Count of students enrolled in each course
SELECT c.Course_Name, COUNT(e.Student_ID) AS Enrolled_Students
FROM Courses c
LEFT JOIN Enrollments e ON c.Course_ID = e.Course_ID
GROUP BY c.Course_Name;

-- 5. Courses offered by each department
SELECT d.Department_Name, c.Course_Name
FROM Courses c
JOIN Departments d ON c.Department_ID = d.Department_ID
ORDER BY d.Department_Name;

-- 6. Courses not enrolled by any student
SELECT c.Course_Name
FROM Courses c
LEFT JOIN Enrollments e ON c.Course_ID = e.Course_ID
WHERE e.Enrollment_ID IS NULL;

-- 7. Instructors and the courses they teach
SELECT i.Name AS Instructor, c.Course_Name
FROM Instructors i
JOIN Courses c ON i.Instructor_ID = c.Instructor_ID;

-- 8. Highest paid instructor per department
SELECT d.Department_Name, i.Name, MAX(i.Salary) AS Highest_Salary
FROM Instructors i
JOIN Departments d ON i.Department_ID = d.Department_ID
GROUP BY d.Department_Name;

-- 9. List each student's grades across all courses
SELECT s.Name, c.Course_Name, e.Grade
FROM Enrollments e
JOIN Students s ON e.Student_ID = s.Student_ID
JOIN Courses c ON e.Course_ID = c.Course_ID
ORDER BY s.Name;

-- 10. Students who have failed any course (Grade D or lower)
SELECT s.Name, c.Course_Name, e.Grade
FROM Enrollments e
JOIN Students s ON e.Student_ID = s.Student_ID
JOIN Courses c ON e.Course_ID = c.Course_ID
WHERE e.Grade = 'D' OR e.Grade = 'F';
