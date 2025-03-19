import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CatDisplayServlet")
public class CatDisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Database connection variables
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Update as per your setup
        String dbUsername = "system";        // Update as per your setup
        String dbPassword = "password";        // Update as per your setup

        List<Cat> cats = new ArrayList<>();

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            // Fetch data from Cat table
            String query = "SELECT * FROM Cat";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat();
                cat.setCatId(rs.getInt("cat_id"));
                cat.setBreed(rs.getString("breed"));
                cat.setAge(rs.getString("age"));
                cat.setPrice(rs.getInt("price"));
                cat.setQuantity(rs.getInt("quantity"));
                cats.add(cat);
            }

            // Set data as a request attribute
            request.setAttribute("cats", cats);

            // Forward to JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("cat.jsp");
            dispatcher.forward(request, response);

            // Close resources
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Exception: " + e.getMessage());
        }
    }
}
