package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class Employee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Employee Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            width: 80%;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            color: #333;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .employee-info {\n");
      out.write("            background-color: #e0f7fa;\n");
      out.write("            padding: 15px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .employee-info b {\n");
      out.write("            color: #00796b;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .button-container {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .button-container form {\n");
      out.write("            margin: 10px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .button-container button {\n");
      out.write("            background-color: #00796b;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .button-container button:hover {\n");
      out.write("            background-color: #004d40;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        footer {\n");
      out.write("            text-align: center;\n");
      out.write("            font-size: 14px;\n");
      out.write("            color: #777;\n");
      out.write("            margin-top: 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Welcome to the Employee Dashboard</h1>\n");
      out.write("\n");
      out.write("        ");

            // Check if session exists and if "name" is present
            if (session == null || session.getAttribute("name") == null) {
                response.sendRedirect("SignUpEmployee.jsp"); 
                return;
            }

            // Retrieve the employee name and position from the session
            String name = (String) session.getAttribute("name");
            String position = (String) session.getAttribute("position");
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Employee Information -->\n");
      out.write("        <div class=\"employee-info\">\n");
      out.write("            <p>Welcome, <b>");
      out.print( name );
      out.write("</b>!</p>\n");
      out.write("            <p>Your Position: <b>");
      out.print( position );
      out.write("</b></p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Navigation Buttons -->\n");
      out.write("        <div class=\"button-container\">\n");
      out.write("            <!-- Button to Manage Customers -->\n");
      out.write("            <form action=\"manageCustomer.jsp\" method=\"get\">\n");
      out.write("                <button type=\"submit\">Manage Customers</button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <!-- Button to View Order Details -->\n");
      out.write("            <form action=\"orderDetails.jsp\" method=\"get\">\n");
      out.write("                <button type=\"submit\">Order Details</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Employee Management System</p>\n");
      out.write("    </footer>\n");
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
