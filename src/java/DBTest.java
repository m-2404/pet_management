import java.sql.*;

public class DBTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Establish the connection
            String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Make sure this is correct
            String username = "system";  // Use your actual username
            String password = "password";  // Use your actual password
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection established successfully!");

            // Perform database operations here (if needed)

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
