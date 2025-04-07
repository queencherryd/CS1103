import java.sql.*;

/**
 * Write a description of class InstructorDAO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// InstructorDAO.java
// Handles CRUD for Instructor + Tax report

public class InstructorDAO {

    // Add instructor
    public void addInstructor(int id, String name, double salary, int deptId) {
        String sql = "INSERT INTO Instructor VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, salary);
            stmt.setInt(4, deptId);
            stmt.executeUpdate();

            System.out.println("Instructor added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Show tax (10% of salary)
    public void showInstructorTax() {
        String sql = "SELECT Name, Salary, (Salary * 0.10) AS Tax FROM Instructor";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("Name") +
                        ", Salary: $" + rs.getDouble("Salary") +
                        ", Tax (10%): $" + rs.getDouble("Tax"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

