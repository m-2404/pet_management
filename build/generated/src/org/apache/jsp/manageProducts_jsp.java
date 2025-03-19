package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class manageProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Manage Products</title>\n");
      out.write("    <style>\n");
      out.write("        /* Styles for the page */\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("        }\n");
      out.write("        .header {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            margin: 20px;\n");
      out.write("        }\n");
      out.write("        .product-table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .product-table th, .product-table td {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            padding: 8px;\n");
      out.write("        }\n");
      out.write("        .product-table th {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("        .form-container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("        }\n");
      out.write("        .form {\n");
      out.write("            background-color: #ffffff;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            padding: 20px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            width: 48%;\n");
      out.write("        }\n");
      out.write("        .form label {\n");
      out.write("            display: block;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .form input, .form button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("        .form button {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .form button:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("        .back-link {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .back-link a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <h1>Manage Products</h1>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Products Table -->\n");
      out.write("        <h2>Product List</h2>\n");
      out.write("        <table class=\"product-table\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                        String query = "SELECT * FROM Products";  // Assuming table is named "Products"
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getInt("PRODUCT_ID") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("PRODUCT_NAME") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getDouble("PRICE") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("IMAGE_LINK") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("PRODUCT_LINK") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error loading products: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <!-- Add Product Form -->\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <h3>Add Product</h3>\n");
      out.write("                <form action=\"AddProduct\" method=\"post\">\n");
      out.write("                    <label for=\"name\">Product Name</label>\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" required>\n");
      out.write("\n");
      out.write("                    <label for=\"price\">Price</label>\n");
      out.write("                    <input type=\"number\" id=\"price\" name=\"price\" step=\"0.01\" required>\n");
      out.write("\n");
      out.write("                    <label for=\"image\">Image_link</label>\n");
      out.write("                    <input type=\"text\" id=\"image\" name=\"image\" required>\n");
      out.write("                    \n");
      out.write("                    <label for=\"product\">Product_Link</label>\n");
      out.write("                    <input type=\"text\" id=\"product\" name=\"product\" required>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    <button type=\"submit\">Add Product</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Delete Product Form -->\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <h3>Delete Product</h3>\n");
      out.write("                <form action=\"DeleteProduct\" method=\"post\">\n");
      out.write("                    <label for=\"productId\">Product ID</label>\n");
      out.write("                    <input type=\"number\" id=\"productId\" name=\"productId\" required>\n");
      out.write("\n");
      out.write("                    <button type=\"submit\">Delete Product</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"back-link\">\n");
      out.write("            <a href=\"Admin.jsp\">Back to Admin Dashboard</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
