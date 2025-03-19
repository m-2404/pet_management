import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/AddPet")
public class AddPets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petType = request.getParameter("petType");
        //String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        String age = (request.getParameter("age"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity=Integer.parseInt(request.getParameter(quantity));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            String query = "";
            if (petType.equalsIgnoreCase("Cat")) {
                query = "INSERT INTO Cat (BREED, AGE, PRICE,QUANTITY) VALUES (?, ?, ?, ?)";
            } else if (petType.equalsIgnoreCase("Dog")) {
                query = "INSERT INTO Dog ( BREED, AGE, PRICE,QUANTITY) VALUES (?, ?, ?, ?)";
            }

            pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, breed);
            pstmt.setString(2, age);
            pstmt.setDouble(3, price);
            pstmt.setDouble(4, quantity);
            

            int rowsInserted = pstmt.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rowsInserted > 0) {
                out.println("<script>alert('Pet added successfully!'); location='managePets.jsp';</script>");
            } else {
                out.println("<script>alert('Failed to add pet.'); location='managePets.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
