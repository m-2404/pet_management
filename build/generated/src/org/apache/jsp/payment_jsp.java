package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public final class payment_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    // Retrieve the cart and customer information from session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    String address = request.getParameter("address");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");

    // Generate the order ID and calculate the delivery date
    String orderId = "ORD" + System.currentTimeMillis();  // Generate unique order ID
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, 5);  // Delivery date 5 days from now
    String deliveryDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

    // Save order details to the database if valid
    if (cart != null && !cart.isEmpty() && address != null && phone != null && email != null) {
        try {
            // Database connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
            
            // Insert order into Orders table
            String orderQuery = "INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, ADDRESS, PHONE, EMAIL, ORDER_DATE, DELIVERY_DATE) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(orderQuery);
            stmt.setString(1, orderId);
            stmt.setInt(2, Integer.parseInt(request.getParameter("customerId")));  // Assuming customer ID is passed in the form
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));  // Current date as order date
            stmt.setString(7, deliveryDate);
            stmt.executeUpdate();

            // Insert each product in the cart into ORDER_PRODUCTS table
            String productQuery = "INSERT INTO ORDER_PRODUCTS (ORDER_ID, PRODUCT_ID, PRODUCT_NAME, QUANTITY, PRICE) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(productQuery);
            for (Map<String, Object> item : cart) {
                stmt.setString(1, orderId);
                stmt.setInt(2, (Integer) item.get("productId"));
                stmt.setString(3, (String) item.get("productName"));
                stmt.setInt(4, (Integer) item.get("quantity"));
                stmt.setDouble(5, (Double) item.get("price"));
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Payment</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Payment Information</h1>\n");
      out.write("    <form action=\"paymentConfirmation.jsp\" method=\"post\">\n");
      out.write("        <label for=\"cardNumber\">Card Number:</label><br>\n");
      out.write("        <input type=\"text\" name=\"cardNumber\" required /><br>\n");
      out.write("\n");
      out.write("        <label for=\"cvv\">CVV:</label><br>\n");
      out.write("        <input type=\"text\" name=\"cvv\" required /><br>\n");
      out.write("\n");
      out.write("        <label for=\"expiryDate\">Expiry Date (MM/YY):</label><br>\n");
      out.write("        <input type=\"text\" name=\"expiryDate\" required /><br>\n");
      out.write("\n");
      out.write("        <label for=\"emailId\">Email ID:</label><br>\n");
      out.write("        <input type=\"email\" name=\"emailId\" value=\"");
      out.print( email );
      out.write("\" required /><br><br>\n");
      out.write("\n");
      out.write("        <input type=\"hidden\" name=\"orderId\" value=\"");
      out.print( orderId );
      out.write("\" />\n");
      out.write("        <input type=\"hidden\" name=\"deliveryDate\" value=\"");
      out.print( deliveryDate );
      out.write("\" />\n");
      out.write("\n");
      out.write("        <button type=\"submit\">Confirm Payment</button>\n");
      out.write("    </form>\n");
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
