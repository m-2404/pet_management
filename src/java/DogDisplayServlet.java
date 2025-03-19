import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Dog;

@WebServlet("/dogDisplayServlet")
public class DogDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dog> dogList = new ArrayList<>();

        // Database connection setup
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM Dog"; 
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Dog dog = new Dog();
                dog.setBreed(rs.getString("breed"));
                dog.setAge(rs.getString("age"));
                dog.setPrice(rs.getInt("price"));
                dog.setQuantity(rs.getInt("quantity"));
                dogList.add(dog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the dog list as a request attribute and forward to dog.jsp
        request.setAttribute("dogList", dogList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dog.jsp");
        dispatcher.forward(request, response);
    }
}
