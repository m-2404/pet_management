package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;

public final class addcart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Add to Cart</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Item Added to Cart</h2>\n");
      out.write("\n");
      out.write("    ");
 
        // Retrieve the cart from the request
        List<String> cart = (List<String>) request.getAttribute("cart");

        // If cart is null, create a new one
        if (cart == null) {
            cart = new ArrayList<String>();
        }

        // Get product details from request parameters
        String productName = request.getParameter("name/breed");
        String price = request.getParameter("price");

        // If product details are available, add to the cart
        if (productName != null && price != null) {
            cart.add(productName + " - ₹" + price);
        }

        // Set the cart back to request scope for the next page (if needed)
        request.setAttribute("cart", cart);

        // Check if the cart is not empty to display the "Go to Cart" option
        boolean isCartEmpty = cart.isEmpty();
    
      out.write("\n");
      out.write("\n");
      out.write("    <p>The item has been successfully added to your cart.</p>\n");
      out.write("\n");
      out.write("    <h3>Cart Summary</h3>\n");
      out.write("    <ul>\n");
      out.write("        ");
 for (String item : cart) { 
      out.write("\n");
      out.write("            <li>");
      out.print( item );
      out.write("</li>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    ");
 if (!isCartEmpty) { 
      out.write("\n");
      out.write("        <a href=\"cart.jsp\">Go to Cart</a>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    <a href=\"food.jsp\">Back to Food</a> | <a href=\"petProducts.jsp\">Back to Products</a>\n");
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
