import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/SignUpEmployee")
public class SignUpEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String securityQuestion = request.getParameter("securityQuestion");
        String securityAnswer = request.getParameter("securityAnswer");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phoneNo");
        String position = request.getParameter("position");
        String salaryStr = request.getParameter("salary");
        double salary = salaryStr != null && !salaryStr.isEmpty() ? Double.parseDouble(salaryStr) : 0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            // Insert employee details
            String insertQuery = "INSERT INTO Employees (NAME, EMAIL, PASSWORD, SECURITY_QUESTION, SECURITY_ANSWER, GENDER, ADDRESS, PHONE_NO, POSITION, SALARY) "
                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, securityQuestion);
            pstmt.setString(5, securityAnswer);
            pstmt.setString(6, gender);
            pstmt.setString(7, address);
            pstmt.setString(8, phoneNo);
            pstmt.setString(9, position);
            pstmt.setDouble(10, salary);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                // Store name and position in session
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("position", position);

                // Redirect to Employee.jsp
                //response.sendRedirect("Employee.jsp")
                RequestDispatcher dispatcher = request.getRequestDispatcher("Employee.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("Error signing up employee.");
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
