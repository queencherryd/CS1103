import java.sql.*;
import java.util.*;
/**
 * Write a description of class StudentDAO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// StudentDAO.java
// Handles CRUD operations for Student table
public class StudentDAO {
    // Insert a new student
    public void addStudent(int id, String name, int age, String email, int deptId) {
        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, email);
            stmt.setInt(5, deptId);
            stmt.executeUpdate();

            System.out.println("Student added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update student's email
    public void updateStudentEmail(int id, String newEmail) {
        String sql = "UPDATE Student SET Email = ? WHERE Student_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Email updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        String sql = "DELETE FROM Student WHERE Student_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Student deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all students
    public void listAllStudents() 
    {
        String sql = "SELECT * FROM Student";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) 
            {
                System.out.println("ID: " + rs.getInt("Student_ID") +
                        ", Name: " + rs.getString("Name") +
                        ", Age: " + rs.getInt("Age") +
                        ", Email: " + rs.getString("Email") +
                        ", Dept: " + rs.getInt("Department_ID"));
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
    }
    //This code is to update the students name 
         public void updateStudentName(int id, String newName) 
    {
        String sql = "UPDATE Student SET Name = ? WHERE Student_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) 
        {

            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Student name updated.");
        } 
            catch (SQLException e) 
        {
            e.printStackTrace();
        }

         // This code is to update  student's age
    public void updateStudentAge(int id, int newAge) 
    {
        String sql = "UPDATE Student SET Age = ? WHERE Student_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) 
        {

            stmt.setInt(1, newAge);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Student age updated.");
        }
            catch (SQLException e) 
        {
            e.printStackTrace();
        }

         // This code is to update student's department
    public void updateStudentDepartment(int id, int newDeptId) 
    {
        String sql = "UPDATE Student SET Department_ID = ? WHERE Student_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) 
        {

            stmt.setInt(1, newDeptId);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Student department updated.");
        } 
            catch (SQLException e) 
        {
            e.printStackTrace();
        }        
    }    
}

