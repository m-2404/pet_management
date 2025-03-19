import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginEmployee")
public class LoginEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeIdStr = request.getParameter("employeeId");
        String password = request.getParameter("password");

        int employeeId = 0;
        try {
            employeeId = Integer.parseInt(employeeIdStr);
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid Employee ID format.");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            // Query to check employee_id and password
            String query = "SELECT NAME, POSITION FROM Employees WHERE EMPLOYEE_ID = ? AND PASSWORD = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve name and position
                String name = rs.getString("NAME");
                String position = rs.getString("POSITION");

                // Store name and position in session
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("position", position);

                // Redirect to Employee.jsp
                response.sendRedirect("Employee.jsp");
            } else {
                // Invalid credentials
                response.getWriter().println("Invalid Employee ID or Password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
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
