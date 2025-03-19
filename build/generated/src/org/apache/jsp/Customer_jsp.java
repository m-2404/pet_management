package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Customer;

public final class Customer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    
    String firstName = (String) session.getAttribute("firstName");
    String username = (String) session.getAttribute("lastName");
    String phone = (String) session.getAttribute("phone");
    String address = (String) session.getAttribute("address");

    
   /* if (firstName == null || username == null || phone == null || address == null) {
        response.sendRedirect("loginCustomer.html");
        return;
    }*/

      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Customer Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .header {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 15px;\n");
      out.write("        }\n");
      out.write("        .nav-bar {\n");
      out.write("            text-align: center;\n");
      out.write("            margin: 20px;\n");
      out.write("        }\n");
      out.write("        .nav-bar a {\n");
      out.write("            margin: 5px;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            color: white;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .profile {\n");
      out.write("            max-width: 500px;\n");
      out.write("            margin: 20px auto;\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        .profile h2 {\n");
      out.write("            color: #4CAF50;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <h1>Welcome, ");
      out.print( firstName );
      out.write(" !</h1>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"nav-bar\">\n");
      out.write("        <a href=\"PetCategories.jsp\">Pet Categories</a>\n");
      out.write("        <a href=\"petCare.jsp\">Pet Care</a>\n");
      out.write("        <a href=\"petProducts.jsp\">Pet Products</a>\n");
      out.write("        <a href=\"trackOrder.jsp\">Track Orders</a>\n");
      out.write("        <a href=\"logout.jsp\">Logout</a>\n");
      out.write("        <a href=\"cart.jsp\">View Cart</a> <!-- Link to the cart page -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <<div class=\"profile\">\n");
      out.write("        <h2>Your Profile</h2>\n");
      out.write("        <p><strong>Username:</strong> ");
      out.print( username );
      out.write("</p>\n");
      out.write("        <p><strong>Phone Number:</strong> ");
      out.print( phone );
      out.write("</p>\n");
      out.write("        <p><strong>Address:</strong> ");
      out.print( address );
      out.write("</p>\n");
      out.write("    </div>\n");
      out.write("\n");
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
