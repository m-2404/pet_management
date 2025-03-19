import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/AdminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String emailId = request.getParameter("emailId");
        String roleDescription = request.getParameter("roleDescription");
        String permissions = request.getParameter("permissions");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

            String insertQuery = "INSERT INTO Admins (ADMIN_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, GENDER, PHONE_NO, EMAIL_ID, ROLE_DESCRIPTION, PERMISSIONS) "
                               + "VALUES (ADMINS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery, new String[] { "ADMIN_ID" });

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setString(5, gender);
            pstmt.setString(6, phoneNo);
            pstmt.setString(7, emailId);
            pstmt.setString(8, roleDescription);
            pstmt.setString(9, permissions);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int adminId = rs.getInt(1);

                    // Store the Admin ID and other details in the session
                    HttpSession session = request.getSession();
                    session.setAttribute("adminId", adminId);
                    session.setAttribute("username", username);
                    session.setAttribute("firstName", firstName);
                    session.setAttribute("lastName", lastName);

                    // Redirect to the Admin page
                    response.sendRedirect("Admin.jsp");
                }
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3 style='color:red;'>Registration failed. Please try again.</h3>");
                out.println("<a href='AdminSignUp.jsp'>Back to Sign Up</a>");
                out.println("</body></html>");
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
