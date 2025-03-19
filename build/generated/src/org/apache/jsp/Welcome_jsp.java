package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Welcome to PawsTrack</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: 'Roboto', Arial, sans-serif;\n");
      out.write("            background: linear-gradient(to bottom, #e8f5e9, #b2dfdb); /* Gradient background */\n");
      out.write("            color: #333; /* Darker text for better contrast */\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            max-width: 1000px;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #fff; /* White background for content */\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2); /* Subtle shadow */\n");
      out.write("            overflow: hidden;\n");
      out.write("        }\n");
      out.write("        .header {\n");
      out.write("            background-color: #4caf50; /* Green header */\n");
      out.write("            padding: 20px;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            border-radius: 15px 15px 0 0; /* Rounded top corners */\n");
      out.write("        }\n");
      out.write("        .header .logo {\n");
      out.write("            font-size: 2.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .header .tagline {\n");
      out.write("            font-size: 1.2rem;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            font-style: italic;\n");
      out.write("        }\n");
      out.write("        .content {\n");
      out.write("            padding: 30px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .content .about {\n");
      out.write("            font-size: 1.4rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #1b5e20;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .images {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            gap: 15px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .images img {\n");
      out.write("            width: 180px;\n");
      out.write("            height: auto;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            transition: transform 0.3s ease, box-shadow 0.3s ease;\n");
      out.write("        }\n");
      out.write("        .images img:hover {\n");
      out.write("            transform: scale(1.1); /* Slight zoom effect */\n");
      out.write("            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);\n");
      out.write("        }\n");
      out.write("        .quotes-section {\n");
      out.write("            margin-top: 30px;\n");
      out.write("        }\n");
      out.write("        .quote {\n");
      out.write("            font-size: 1.3rem;\n");
      out.write("            font-style: italic;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #388e3c;\n");
      out.write("            margin: 10px 0;\n");
      out.write("        }\n");
      out.write("        .buttons {\n");
      out.write("            margin-top: 30px;\n");
      out.write("        }\n");
      out.write("        .button {\n");
      out.write("            text-decoration: none;\n");
      out.write("            padding: 12px 25px;\n");
      out.write("            margin: 10px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: white;\n");
      out.write("            background-color: #4caf50; /* Green button */\n");
      out.write("            border-radius: 25px; /* Rounded buttons */\n");
      out.write("            transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("        }\n");
      out.write("        .button:hover {\n");
      out.write("            background-color: #388e3c; /* Darker green on hover */\n");
      out.write("            transform: translateY(-3px); /* Lift effect */\n");
      out.write("        }\n");
      out.write("        .footer {\n");
      out.write("            margin-top: 30px;\n");
      out.write("            background-color: #1b5e20;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 0 0 15px 15px; /* Rounded bottom corners */\n");
      out.write("        }\n");
      out.write("        .footer p {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 0.9rem;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Header Section -->\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"logo\">Welcome to PawsTrack</div>\n");
      out.write("            <div class=\"tagline\">Your ultimate companion for pet care and tracking!</div>\n");
      out.write("            <div class=\"tagline\">At Paws Track, we understand that your pets are more than just animals?they?re family. Our mission is to provide innovative and reliable solutions to ensure the safety, health, and happiness of your furry companions.</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Content Section -->\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div class=\"about\">We care about your pet and provide the best solutions to keep them safe and happy.</div>\n");
      out.write("\n");
      out.write("            <!-- Puppy Images -->\n");
      out.write("            <div class=\"images\">\n");
      out.write("                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcSg6lyW2veKh0oyj4yEwZwye8SW8RgNVAiDGAr3YGpmyp_M0VIyzLiMwtp17Ih8z1qX8&usqp=CAU\" alt=\"Cute Puppy 1\">\n");
      out.write("                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV74tirzUCE4VmuHR5IZcQDY1Pk825ww8inzkjygY_yhSSFdp2Ya26MlFC0n4Fzv6jw6A&usqp=CAU\" alt=\"Cute Puppy 2\">\n");
      out.write("                <img src=\"https://i.pinimg.com/originals/b9/c4/35/b9c435d70bf634a723f45e884dd24876.jpg\" alt=\"Cute Kitten\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Quotes Section -->\n");
      out.write("            <div class=\"quotes-section\">\n");
      out.write("                <div class=\"quote\">\"A dog is the only thing on earth that loves you more than he loves himself.\" ? Josh Billings</div>\n");
      out.write("                <div class=\"quote\">\"Time spent with cats is never wasted.\" ? Sigmund Freud</div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Buttons Section -->\n");
      out.write("            <div class=\"buttons\">\n");
      out.write("                <a href=\"SignUp.jsp\" class=\"button\">Sign Up</a>\n");
      out.write("                <a href=\"Login.jsp\" class=\"button\">Login</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Footer Section -->\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <p>&copy; 2024 PawsTrack. All Rights Reserved.</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
