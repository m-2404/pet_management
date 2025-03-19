import java.sql.*;

public class DogIn {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system";
        String password = "password";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            
            // SQL insert statement
            String query = "INSERT INTO Dog (PRODUCT_ID,PRODUCT_NAME , PRICE, IMAGE_LINK,PRODUCT_LINK) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);

            // Insert Bulldog data
            stmt.setInt(1, 1);
            stmt.setString(2, "Pet Bed");
            stmt.setInt(3, 1500);
            stmt.setString(4, "https://m.media-amazon.com/images/I/718pNqY-24L._SX522_.jpg");
            stmt.setString(5,"https://amzn.in/d/gbvylwR");
            stmt.executeUpdate();

            // Insert Labrador data
            stmt.setInt(1, 1);
            stmt.setString(2, "Dog Chew Toy");
            stmt.setInt(3, 500);
            stmt.setString(4, "https://m.media-amazon.com/images/I/41sTUSYMP8L._SX300_SY300_QL70_FMwebp_.jpg");
            stmt.setString(5,"https://amzn.in/d/762Z7yR");
            stmt.executeUpdate();;

           stmt.setInt(1, 1);
            stmt.setString(2, "Dog Chew Toy");
            stmt.setInt(3, 500);
            stmt.setString(4, "https://m.media-amazon.com/images/I/41sTUSYMP8L._SX300_SY300_QL70_FMwebp_.jpg");
            stmt.setString(5,"https://amzn.in/d/bcAblEo");
            stmt.executeUpdate();;

            
            stmt.setInt(1, 1);
            stmt.setString(2, "Pet Grooming Kit");
            stmt.setInt(3,  5499);
            stmt.setString(4, "https://m.media-amazon.com/images/I/41sTUSYMP8L._SX300_SY300_QL70_FMwebp_.jpg");
            stmt.setString(5,"https://amzn.in/d/762Z7yR");
            stmt.executeUpdate();;

            
            stmt.setInt(1, 1);
            stmt.setString(2, "Dog Leash");
            stmt.setInt(3, 1299);
            stmt.setString(4, "https://m.media-amazon.com/images/I/41SOyfdfSZL._SX300_SY300_QL70_FMwebp_.jpg");
            stmt.setString(5,"https://amzn.in/d/6O5CUiO");
            stmt.executeUpdate();;

            
            
           stmt.setInt(1, 1);
            stmt.setString(2, "Cat Litter Box");
            stmt.setInt(3, 1372);
            stmt.setString(4, "https://m.media-amazon.com/images/I/41bkpFTgTnL._SY300_SX300_QL70_FMwebp_.jpg");
            stmt.setString(5,"https://amzn.in/d/6QHh0Cl");
            stmt.executeUpdate();;


            System.out.println("Data inserted successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
