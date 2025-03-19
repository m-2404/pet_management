import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            String query = "DELETE FROM Customers WHERE CUSTOMER_ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, customerId);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                response.sendRedirect("manageCustomers.jsp?message=Customer deleted successfully!");
            } else {
                response.sendRedirect("manageCustomers.jsp?message=Customer ID not found.");
            }
        } catch (SQLException e) {
            response.sendRedirect("manageCustomers.jsp?message=Error: " + e.getMessage());
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
