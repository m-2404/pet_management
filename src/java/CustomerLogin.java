//package yourpackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import model.Customer;

public class CustomerLogin extends HttpServlet {
    
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "password";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the username and password from the request
        PrintWriter pw=response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Authenticate the user and fetch user details
        //Customer user = authenticateUser(username, password);

        /*if (user != null) {
            // Store customer details in the session
            HttpSession session = request.getSession();
            session.setAttribute("firstName", user.getName());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("phone", user.getPhone());
            session.setAttribute("address", user.getAddress());
            
            // Redirect to Customer Dashboard (Customer.jsp)
            response.sendRedirect("Customer.jsp");
        } else {
            // If invalid credentials, set the error message and redirect to login page
            request.setAttribute("errorMessage", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginCustomer.html");
            dispatcher.forward(request, response);
        }
    }

    // Method to authenticate the user
    private Customer authenticateUser(String username, String password) {
        Customer user = null; */
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve customer details
                /*user = new Customer();
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));*/
                HttpSession ses=request.getSession();
                ses.setAttribute("firstName",rs.getString("first_name"));
                ses.setAttribute("lastName",rs.getString("last_name"));
                 ses.setAttribute("phone",rs.getString("phonw_no"));
                  ses.setAttribute("address",rs.getString("address"));;
                RequestDispatcher rd=request.getRequestDispatcher("/Customer.jsp");
            }
            else{
                
                RequestDispatcher rd=request.getRequestDispatcher("/loginCustomer.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return user;
    }
}
