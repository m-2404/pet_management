import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            // SQL query to delete employee by ID
            String query = "DELETE FROM Employees WHERE EMPLOYEE_ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, employeeId);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                response.sendRedirect("manageEmployees.jsp?message=Employee deleted successfully!");
            } else {
                response.sendRedirect("manageEmployees.jsp?message=Employee ID not found.");
            }
        } catch (SQLException e) {
            response.sendRedirect("manageEmployees.jsp?message=Error: " + e.getMessage());
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
