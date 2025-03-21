package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forgotPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Forgot Password</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Forgot Password</h2>\n");
      out.write("\n");
      out.write("    <form action=\"ForgotPasswordServlet\" method=\"post\">\n");
      out.write("        <!-- Display the email field -->\n");
      out.write("        <label for=\"email\">Email:</label>\n");
      out.write("        <input type=\"email\" id=\"email\" name=\"email\" required><br><br>\n");
      out.write("\n");
      out.write("        <!-- Display error message if exists -->\n");
      out.write("        ");

            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        
      out.write("\n");
      out.write("            <p style=\"color:red;\">Error: ");
      out.print( errorMessage );
      out.write("</p>\n");
      out.write("        ");
 
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Submit\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    ");
 
        // Check if a security question exists after email submission
        String securityQuestion = (String) request.getAttribute("securityQuestion");
        String email = (String) request.getAttribute("email");

        if (securityQuestion != null) {
    
      out.write("\n");
      out.write("        <!-- Show the security question input field -->\n");
      out.write("        <h3>Security Question:</h3>\n");
      out.write("        <form action=\"ForgotPasswordServlet\" method=\"post\">\n");
      out.write("            <label for=\"securityAnswer\">");
      out.print( securityQuestion );
      out.write("</label><br>\n");
      out.write("            <input type=\"text\" id=\"securityAnswer\" name=\"securityAnswer\" required><br><br>\n");
      out.write("\n");
      out.write("            <input type=\"hidden\" name=\"email\" value=\"");
      out.print( email );
      out.write("\"> <!-- Keep email in hidden field -->\n");
      out.write("            <input type=\"submit\" value=\"Submit Answer\">\n");
      out.write("        </form>\n");
      out.write("    ");
 
        }
    
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
