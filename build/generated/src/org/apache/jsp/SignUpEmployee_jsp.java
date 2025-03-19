package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUpEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Employee Sign Up</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            width: 40%;\n");
      out.write("            margin: auto;\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            border-radius: 8px;\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        input, select, button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Employee Sign Up</h1>\n");
      out.write("        <form action=\"SignUpEmployee\" method=\"post\">\n");
      out.write("            <label for=\"name\">Name</label>\n");
      out.write("            <input type=\"text\" id=\"name\" name=\"name\" required>\n");
      out.write("\n");
      out.write("            <label for=\"email\">Email</label>\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("            <label for=\"securityQuestion\">Security Question</label>\n");
      out.write("            <select id=\"securityQuestion\" name=\"securityQuestion\" required>\n");
      out.write("                <option value=\"\" disabled selected>Select your security question</option>\n");
      out.write("                <option value=\"Teacher\">What is your favorite teacher's name?</option>\n");
      out.write("                <option value=\"Pet\">What is the name of your first pet?</option>\n");
      out.write("                <option value=\"Movie\">What is your favorite movie?</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <label for=\"securityAnswer\">Security Answer</label>\n");
      out.write("            <input type=\"text\" id=\"securityAnswer\" name=\"securityAnswer\" required>\n");
      out.write("\n");
      out.write("            <label for=\"gender\">Gender</label>\n");
      out.write("            <select id=\"gender\" name=\"gender\" required>\n");
      out.write("                <option value=\"\" disabled selected>Select your gender</option>\n");
      out.write("                <option value=\"Male\">Male</option>\n");
      out.write("                <option value=\"Female\">Female</option>\n");
      out.write("                <option value=\"Other\">Other</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <label for=\"address\">Address</label>\n");
      out.write("            <input type=\"text\" id=\"address\" name=\"address\" required>\n");
      out.write("\n");
      out.write("            <label for=\"phoneNo\">Phone Number</label>\n");
      out.write("            <input type=\"text\" id=\"phoneNo\" name=\"phoneNo\" required>\n");
      out.write("\n");
      out.write("            <label for=\"position\">Position</label>\n");
      out.write("            <input type=\"text\" id=\"position\" name=\"position\" required>\n");
      out.write("\n");
      out.write("            <label for=\"salary\">Salary</label>\n");
      out.write("            <input type=\"number\" id=\"salary\" name=\"salary\" step=\"0.01\" required>\n");
      out.write("\n");
      out.write("            <button type=\"submit\">Sign Up</button>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"loginEmployee.jsp\">log In</a>\n");
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
