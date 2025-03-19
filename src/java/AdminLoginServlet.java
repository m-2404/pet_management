import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int adminId = Integer.parseInt(request.getParameter("adminId"));
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Database connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            // Query to validate admin credentials
            String query = "SELECT * FROM Admin WHERE admin_id = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, adminId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Set admin attributes in the session
                HttpSession session = request.getSession();
                session.setAttribute("adminId", rs.getInt("admin_id"));
                session.setAttribute("firstName", rs.getString("first_name"));
                session.setAttribute("lastName", rs.getString("last_name"));
                session.setAttribute("email", rs.getString("email_id"));
                session.setAttribute("roleDescription", rs.getString("role_description"));

                // Forward to Admin.jsp
                RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
                rd.forward(request, response);
            } else {
                // Invalid credentials
                request.setAttribute("errorMessage", "Invalid Admin ID or Password.");
                RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred during login.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
