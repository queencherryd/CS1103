package dao;

import util.DBConnection;

import java.sql.*;

public class InstructorDAO {
    public void addInstructor(int id, String name, int deptId, double salary) throws SQLException {
        String sql = "INSERT INTO Instructors (Instructor_ID, Name, Department_ID, Salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, deptId);
            stmt.setDouble(4, salary);
            stmt.executeUpdate();
        }
    }

    public void updateSalary(int id, double newSalary) throws SQLException {
        String sql = "UPDATE Instructors SET Salary = ? WHERE Instructor_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteInstructor(int id) throws SQLException {
        String sql = "DELETE FROM Instructors WHERE Instructor_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
