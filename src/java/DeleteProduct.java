import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            String query = "DELETE FROM Products WHERE PRODUCT_ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, productId);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                response.sendRedirect("manageProducts.jsp?message=Product deleted successfully!");
            } else {
                response.sendRedirect("manageProducts.jsp?message=Product ID not found.");
            }
        } catch (SQLException e) {
            response.sendRedirect("manageProducts.jsp?message=Error: " + e.getMessage());
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
