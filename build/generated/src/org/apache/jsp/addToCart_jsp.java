package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class addToCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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

    // Retrieve the cart from the session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    
    // Initialize cart if it's null
    if (cart == null) {
        cart = new ArrayList<>();
    }

    // Retrieve item parameters from the request
    String itemName = request.getParameter("name");
    String itemPrice = request.getParameter("price");
    String itemType = request.getParameter("type");
    String itemBreed = request.getParameter("breed");

    // Ensure that item name and price are not null
    if (itemName != null && itemPrice != null) {
        // Create a map to represent the item
        Map<String, Object> cartItem = new HashMap<>();
        cartItem.put("productName", itemName);
        cartItem.put("price", Double.parseDouble(itemPrice));
        cartItem.put("breed", itemBreed != null ? itemBreed : "N/A");
        cartItem.put("quantity", 1);  // Default quantity
        cartItem.put("productId", UUID.randomUUID().toString()); // Generate a unique ID

        // Add the item to the cart
        cart.add(cartItem);

        // Store the updated cart back in the session
        session.setAttribute("cart", cart);
    }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Item Added to Cart</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Item Added to Cart</h1>\n");
      out.write("    <p>");
      out.print( itemName );
      out.write(" has been added to your cart!</p>\n");
      out.write("    <a href=\"cart.jsp\">Go to Cart</a>\n");
      out.write("    <br>\n");
      out.write("    <a href=\"PetCategories.jsp\">Back to Pet Categories</a>\n");
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
