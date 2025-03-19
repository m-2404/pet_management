package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminSignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Admin Sign Up</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: white;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .container h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #4CAF50;\n");
      out.write("        }\n");
      out.write("        .container form label {\n");
      out.write("            display: block;\n");
      out.write("            margin: 10px 0 5px;\n");
      out.write("        }\n");
      out.write("        .container form input, .container form select {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .container form button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Admin Sign Up</h2>\n");
      out.write("    <form action=\"AdminSignUpServlet\" method=\"post\">\n");
      out.write("        <label for=\"firstName\">First Name:</label>\n");
      out.write("        <input type=\"text\" id=\"firstName\" name=\"firstName\" required>\n");
      out.write("\n");
      out.write("        <label for=\"lastName\">Last Name:</label>\n");
      out.write("        <input type=\"text\" id=\"lastName\" name=\"lastName\" required>\n");
      out.write("\n");
      out.write("        <label for=\"username\">Username:</label>\n");
      out.write("        <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("        <label for=\"password\">Password:</label>\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("        <label for=\"gender\">Gender:</label>\n");
      out.write("        <select id=\"gender\" name=\"gender\">\n");
      out.write("            <option value=\"M\">Male</option>\n");
      out.write("            <option value=\"F\">Female</option>\n");
      out.write("            <option value=\"O\">Other</option>\n");
      out.write("        </select>\n");
      out.write("\n");
      out.write("        <label for=\"phoneNo\">Phone Number:</label>\n");
      out.write("        <input type=\"text\" id=\"phoneNo\" name=\"phoneNo\">\n");
      out.write("\n");
      out.write("        <label for=\"emailId\">Email ID:</label>\n");
      out.write("        <input type=\"email\" id=\"emailId\" name=\"emailId\">\n");
      out.write("\n");
      out.write("        <label for=\"roleDescription\">Role Description:</label>\n");
      out.write("        <input type=\"text\" id=\"roleDescription\" name=\"roleDescription\">\n");
      out.write("\n");
      out.write("        <label for=\"permissions\">Permissions:</label>\n");
      out.write("        <input type=\"text\" id=\"permissions\" name=\"permissions\">\n");
      out.write("\n");
      out.write("        <button type=\"submit\">Sign Up</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
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
