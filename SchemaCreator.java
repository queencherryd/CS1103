import java.sql.Connection;
import java.sql.Statement;
/**
 * Write a description of class SchemaCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// SchemaCreator.java
// Creates tables for the university system if they don't exist

public class SchemaCreator {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // Create Department table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Department (
                    Department_ID INT PRIMARY KEY
                );
            """);

            // Create Student table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Student (
                    Student_ID INT PRIMARY KEY,
                    Name VARCHAR(100),
                    Age INT,
                    Email VARCHAR(100),
                    Department_ID INT,
                    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)
                );
            """);

            // Create Instructor table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Instructor (
                    Instructor_ID INT PRIMARY KEY,
                    Name VARCHAR(100),
                    Salary DOUBLE,
                    Department_ID INT,
                    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)
                );
            """);

            // Create Course table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Course (
                    Course_ID INT PRIMARY KEY,
                    Name VARCHAR(100),
                    Instructor_ID INT,
                    Department_ID INT,
                    FOREIGN KEY (Instructor_ID) REFERENCES Instructor(Instructor_ID),
                    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)
                );
            """);

            // Create Enrollment table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Enrollment (
                    Enrollment_ID INT PRIMARY KEY,
                    Student_ID INT,
                    Course_ID INT,
                    Grade DOUBLE,
                    FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID),
                    FOREIGN KEY (Course_ID) REFERENCES Course(Course_ID)
                );
            """);

            System.out.println("✅ Tables created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
