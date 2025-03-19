import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerSignupServlet")
public class CustomerSignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        String firstName = request.getParameter("FIRST_NAME");
        String lastName = request.getParameter("LAST_NAME");
        String phoneNo = request.getParameter("PHONE_NO");
        String email = request.getParameter("EMAIL_ID");
        String gender = request.getParameter("GENDER");
        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");
        String address = request.getParameter("ADDRESS");
        String securityQuestion = request.getParameter("COL1");
        String securityAnswer = request.getParameter("COL2");

       
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String dbUsername = "system";  
        String dbPassword = "password"; 

        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

           
            String query = "INSERT INTO CUSTOMER (CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE_NO, EMAIL_ID, " +
                           "GENDER, USERNAME, PASSWORD, ADDRESS, COL1, COL2) " +
                           "VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

           
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phoneNo);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setString(6, username);
            ps.setString(7, password);
            ps.setString(8, address);
            ps.setString(9, securityQuestion);
            ps.setString(10, securityAnswer);

          
            int result = ps.executeUpdate();

            if (result > 0) {
              
                request.setAttribute("FIRST_NAME", firstName);
                request.setAttribute("PHONE_NO", phoneNo);
                request.setAttribute("ADDRESS", address);
                request.setAttribute("LAST_NAME",lastName);

             
                RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().write("Error: Unable to sign up. Please try again.");
            }

            
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Exception: " + e.getMessage());
        }
    }
}
