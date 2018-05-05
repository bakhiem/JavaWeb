package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("<div id=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <h3 class=\"footertext\">About Us:</h3>\n");
      out.write("            <br>\n");
      out.write("              <div class=\"col-md-4\">\n");
      out.write("                <center>\n");
      out.write("                  <img src=\"http://oi60.tinypic.com/w8lycl.jpg\" class=\"img-circle\" alt=\"the-brains\">\n");
      out.write("                  <br>\n");
      out.write("                  <h4 class=\"footertext\">Programmer</h4>\n");
      out.write("                  <p class=\"footertext\">You can thank all the crazy programming here to this guy.<br>\n");
      out.write("                </center>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-4\">\n");
      out.write("                <center>\n");
      out.write("                  <img src=\"http://oi60.tinypic.com/2z7enpc.jpg\" class=\"img-circle\" alt=\"...\">\n");
      out.write("                  <br>\n");
      out.write("                  <h4 class=\"footertext\">Artist</h4>\n");
      out.write("                  <p class=\"footertext\">All the images here are hand drawn by this man.<br>\n");
      out.write("                </center>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-4\">\n");
      out.write("                <center>\n");
      out.write("                  <img src=\"http://oi61.tinypic.com/307n6ux.jpg\" class=\"img-circle\" alt=\"...\">\n");
      out.write("                  <br>\n");
      out.write("                  <h4 class=\"footertext\">Designer</h4>\n");
      out.write("                  <p class=\"footertext\">This pretty site and the copy it holds are all thanks to this guy.<br>\n");
      out.write("                </center>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("            <p><center><a href=\"#\">Contact Stuff Here</a> <p class=\"footertext\">Copyright 2014</p></center></p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
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
