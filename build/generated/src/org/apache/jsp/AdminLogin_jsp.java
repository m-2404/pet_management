package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Admin Login</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div style=\"width: 300px; margin: 50px auto; padding: 20px; background-color: white; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">\n");
      out.write("        <h2 style=\"text-align: center; color: #4CAF50;\">Admin Login</h2>\n");
      out.write("\n");
      out.write("        <!-- Show error message if provided -->\n");
      out.write("        ");
 String errorMessage = (String) request.getAttribute("errorMessage"); 
      out.write("\n");
      out.write("        ");
 if (errorMessage != null) { 
      out.write("\n");
      out.write("            <p style=\"color: red; text-align: center;\">");
      out.print( errorMessage );
      out.write("</p>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"AdminLoginServlet\" method=\"post\">\n");
      out.write("            <label for=\"adminId\">Admin ID:</label>\n");
      out.write("            <input type=\"number\" id=\"adminId\" name=\"adminId\" required style=\"width: 100%; padding: 10px; margin-top: 10px;\">\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required style=\"width: 100%; padding: 10px; margin-top: 10px;\"><br><br>\n");
      out.write("            \n");
      out.write("            <button type=\"submit\" style=\"width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;\">Login</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div style=\"text-align: center; margin-top: 10px;\">\n");
      out.write("            <a href=\"AdminSignUp.jsp\" style=\"color: #4CAF50; text-decoration: none;\">Create Admin Account</a>\n");
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
