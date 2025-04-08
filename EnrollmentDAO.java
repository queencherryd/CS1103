package dao;

import util.DBConnection;

import java.sql.*;

public class EnrollmentDAO {
    public void enrollStudent(int enrollId, int studentId, int courseId, String grade) throws SQLException {
        String sql = "INSERT INTO Enrollments (Enrollment_ID, Student_ID, Course_ID, Grade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, enrollId);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            stmt.setString(4, grade);
            stmt.executeUpdate();
        }
    }

    public void updateGrade(int enrollId, String newGrade) throws SQLException {
        String sql = "UPDATE Enrollments SET Grade = ? WHERE Enrollment_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newGrade);
            stmt.setInt(2, enrollId);
            stmt.executeUpdate();
        }
    }

    public void deleteEnrollment(int enrollId) throws SQLException {
        String sql = "DELETE FROM Enrollments WHERE Enrollment_ID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, enrollId);
            stmt.executeUpdate();
        }
    }
}
