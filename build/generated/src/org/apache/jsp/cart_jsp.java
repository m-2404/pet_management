package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    // Retrieve the cart from the session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");

    // Ensure cart is not null, and initialize if it is
    if (cart == null) {
        cart = new ArrayList<>();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Your Cart</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Your Cart</h1>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>Product Name</th>\n");
      out.write("                <th>Breed (If applicable)</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Remove</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                // Check if cart is not empty before iterating
                if (cart != null && !cart.isEmpty()) {
                    // Iterate through the cart items
                    for (Map<String, Object> item : cart) {
                        String productName = (String) item.get("productName");
                        String breed = (String) item.get("breed");
                        Integer quantity = (Integer) item.get("quantity");
                        Double price = (Double) item.get("price");
                        String productId = (String) item.get("productId");

                        // In case price or quantity is null, set default values
                        if (price == null) {
                            price = 0.0;
                        }
                        if (quantity == null) {
                            quantity = 0;
                        }
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( productName != null ? productName : "N/A" );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( breed != null ? breed : "N/A" );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( quantity );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( price );
      out.write("</td>\n");
      out.write("                <td><a href=\"removeFromCart.jsp?productId=");
      out.print( productId );
      out.write("\">Remove</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                } else {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"5\">Your cart is empty.</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    <br>\n");
      out.write("    <a href=\"buynow.jsp\">Proceed to Checkout</a>\n");
      out.write("    <br>\n");
      out.write("    <a href=\"Customer.jsp\">Home</a>\n");
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
