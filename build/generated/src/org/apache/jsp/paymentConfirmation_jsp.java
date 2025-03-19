package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public final class paymentConfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    String orderId = request.getParameter("orderId");
    String deliveryDate = request.getParameter("deliveryDate");

    // Fetch order details from the database
    List<Map<String, Object>> products = new ArrayList<>();
    try {
        // Database connection
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

        // Fetch order details
        String orderQuery = "SELECT * FROM Orders WHERE ORDER_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(orderQuery);
        stmt.setString(1, orderId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Order details fetched, can be displayed if needed
        }

        // Fetch products for this order
        String productQuery = "SELECT * FROM ORDER_PRODUCTS WHERE ORDER_ID = ?";
        stmt = conn.prepareStatement(productQuery);
        stmt.setString(1, orderId);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Map<String, Object> product = new HashMap<>();
            product.put("productName", rs.getString("PRODUCT_NAME"));
            product.put("breed", rs.getString("BREED"));
            product.put("quantity", rs.getInt("QUANTITY"));
            product.put("price", rs.getDouble("PRICE"));
            products.add(product);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Order Confirmation</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1><center>Thank You for Your Order!</center></h1>\n");
      out.write("    <p>Your Order ID: ");
      out.print( orderId );
      out.write("</p>\n");
      out.write("    <p>Delivery Date: ");
      out.print( deliveryDate );
      out.write("</p>\n");
      out.write("\n");
      out.write("    <h2>Order Details:</h2>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>Product Name</th>\n");
      out.write("                <th>Breed</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                for (Map<String, Object> item : products) {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( item.get("productName") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.get("breed") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.get("quantity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( item.get("price") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <p>Thank you for shopping with us!</p>\n");
      out.write("    <a href=\"home.jsp\">Go to Home</a>\n");
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
