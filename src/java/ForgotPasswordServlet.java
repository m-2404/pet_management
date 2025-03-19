import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {

    // Database credentials (replace with your own)
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "system";
    private static final String DB_PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        // Fetch the security question and answer from the database based on email
        String[] securityData = getSecurityQuestionAndAnswer(email);

        if (securityData != null) {
            // If found, display the security question and pass the email for validation
            request.setAttribute("securityQuestion", securityData[0]);
            request.setAttribute("securityAnswer", securityData[1]);  // Store answer temporarily for validation
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
            dispatcher.forward(request, response);
        } else {
            // If email not found
            request.setAttribute("errorMessage", "Email not found.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Fetch security question and answer for the given email
    private String[] getSecurityQuestionAndAnswer(String email) {
        String[] securityData = null;

        try {
            // Establish connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare SQL query to get the security question and answer for the given email
            String query = "SELECT col1, col2 FROM Customer WHERE LOWER(email_id) = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Get the security question and answer from the result set
                securityData = new String[] { rs.getString("col1"), rs.getString("col2") };
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return securityData;
    }
}
