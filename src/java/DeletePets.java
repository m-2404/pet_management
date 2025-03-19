import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DeletePet")
public class DeletePets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petType = request.getParameter("petType");
        int petId = Integer.parseInt(request.getParameter("petId"));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            String query = "";
            if (petType.equalsIgnoreCase("Cat")) {
                query = "DELETE FROM Cat WHERE CAT_ID = ?";
            } else if (petType.equalsIgnoreCase("Dog")) {
                query = "DELETE FROM Dog WHERE DOG_ID = ?";
            }

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            int rowsDeleted = pstmt.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rowsDeleted > 0) {
                out.println("<script>alert('Pet deleted successfully!'); location='managePets.jsp';</script>");
            } else {
                out.println("<script>alert('Failed to delete pet. Pet ID not found.'); location='managePets.jsp';</script>");
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
