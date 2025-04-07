import java.sql.*;
/**
 * Write a description of class EnrollmentDAO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// EnrollmentDAO.java
// Handles report: top student(s) based on highest grade
public class EnrollmentDAO {

    // Find and print student(s) with the highest grade overall
    public void printTopStudentsOverall() {
        String sql = """
            SELECT Student_ID, Grade
            FROM Enrollment
            WHERE Grade = (
                SELECT MAX(Grade)
                FROM Enrollment
            );
        """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Top Student(s) with Highest Grade:");
            while (rs.next()) {
                int studentId = rs.getInt("Student_ID");
                double grade = rs.getDouble("Grade");

                System.out.println("Student ID: " + studentId + " | Grade: " + grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
