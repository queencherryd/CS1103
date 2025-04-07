import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Write a description of class DBConnection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// DBConnection.java
// Utility class for connecting to the MySQL database

public class DBConnection {
    // Update with your actual DB credentials
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "Lifted2018!";

    // Method to get database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println(" Connected to the database successfully!");
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }

}
