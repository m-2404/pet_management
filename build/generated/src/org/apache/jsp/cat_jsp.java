package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import model.Cat;

public final class cat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    // Helper method to return image URL based on the breed
    public String getCatImage(String breed) {
        String imageUrl = "";
        switch (breed.toLowerCase()) {
            case "persian cat":
                imageUrl = "images/persian.jpg";
                break;
            case "siamese cat":
                imageUrl = "images/siamese.jpg";
                break;
             case "persian blue cat":
                    imageUrl="images/persian blue.jpg";
                   break;
              case "bengal cat":
                    imageUrl="images/bengal.jpg";
                   break;
              case "maine coon cat":
                    imageUrl="images/maine coon.jpg";
                   break;
              case "ragdoll cat":
                    imageUrl="images/ragdoll.jpg";
                   break;
            default:
                imageUrl = "https://example.com/images/default_cat.jpg";
        }
        return imageUrl;
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    // List to store Cat objects
    List<Cat> cats = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change connection string as needed
        String user = "system";
        String password = "password";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        // Query to retrieve cat data
        String query = "SELECT * FROM Cat";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        // Populate the list of Cat objects
        while (rs.next()) {
            String breed = rs.getString("breed");
            String age = rs.getString("age");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");

            // Create a Cat object and add it to the list
            Cat cat = new Cat(breed, age, price, quantity);
            cats.add(cat);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Cat Products</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .product-container {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("        .product {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            margin: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("            width: 250px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .product img {\n");
      out.write("            width: 200px;\n");
      out.write("            height: 200px;\n");
      out.write("            object-fit: cover;\n");
      out.write("        }\n");
      out.write("        .product h3 {\n");
      out.write("            font-size: 18px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        .product p {\n");
      out.write("            margin: 5px 0;\n");
      out.write("        }\n");
      out.write("        .action-buttons {\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("        .action-buttons a, .action-buttons button {\n");
      out.write("            margin: 5px;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .action-buttons a:hover, .action-buttons button:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Cat Breeds</h1>\n");
      out.write("\n");
      out.write("    <div class=\"product-container\">\n");
      out.write("        ");
 
            // Iterate through the list of cats and display each cat's details
            for (Cat cat : cats) {
        
      out.write("\n");
      out.write("        <div class=\"product\">\n");
      out.write("            <!-- Display breed, age, price, and image -->\n");
      out.write("            <img src=\"");
      out.print( getCatImage(cat.getBreed()) );
      out.write("\" alt=\"");
      out.print( cat.getBreed() );
      out.write("\">\n");
      out.write("            <h3>");
      out.print( cat.getBreed() );
      out.write("</h3>\n");
      out.write("            <p>Age: ");
      out.print( cat.getAge() );
      out.write("</p>\n");
      out.write("            <p>Price: ?");
      out.print( cat.getPrice() );
      out.write("</p>\n");
      out.write("            <p>Available: ");
      out.print( cat.getQuantity() );
      out.write(" left</p>\n");
      out.write("\n");
      out.write("            <!-- Add to Cart and Buy Now buttons -->\n");
      out.write("            <div class=\"action-buttons\">\n");
      out.write("                <!-- Add to Cart -->\n");
      out.write("                <form method=\"post\" action=\"addcart.jsp\">\n");
      out.write("                    <input type=\"hidden\" name=\"catBreed\" value=\"");
      out.print( cat.getBreed() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"catPrice\" value=\"");
      out.print( cat.getPrice() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"catQuantity\" value=\"");
      out.print( cat.getQuantity() );
      out.write("\">\n");
      out.write("                    <button type=\"submit\">Add to Cart</button>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- Buy Now -->\n");
      out.write("                <a href=\"buyNow.jsp?breed=");
      out.print( cat.getBreed() );
      out.write("&price=");
      out.print( cat.getPrice() );
      out.write("&quantity=");
      out.print( cat.getQuantity() );
      out.write("\">\n");
      out.write("                    <button>Buy Now</button>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <a href=\"PetCategories.jsp\">Pet Categories</a>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
