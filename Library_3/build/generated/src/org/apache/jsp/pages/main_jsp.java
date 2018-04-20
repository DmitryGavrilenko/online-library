package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.connectiondatabase.DatabaseConnection;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/left_bar.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
  }

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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"header\">Library</div>\n");
      out.write("        \n");
      out.write("        <div id=\"search\">\n");
      out.write("            <img src=\"../images/search.png\" width=\"25px\" height=\"25px\">\n");
      out.write("            <form name=\"search_form\">\n");
      out.write("                <input id=\"search_input\" type=\"search\">\n");
      out.write("                <input id=\"search_button\" type=\"button\" value=\"Искать\">\n");
      out.write("                <select>\n");
      out.write("                    <option> По автору</option>\n");
      out.write("                    <option> По жанру</option>\n");
      out.write("                </select>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
DatabaseConnection db = new DatabaseConnection();
      out.write('\n');
      out.write('\n');
      com.database.GenreList genre = null;
      synchronized (_jspx_page_context) {
        genre = (com.database.GenreList) _jspx_page_context.getAttribute("genre", PageContext.PAGE_SCOPE);
        if (genre == null){
          genre = new com.database.GenreList();
          _jspx_page_context.setAttribute("genre", genre, PageContext.PAGE_SCOPE);
          out.write("    \n");
          out.write("        <div id=\"authors\">\n");
          out.write("             <h4 id=\"authors_font\">Genre</h4>\n");
          out.write("        ");
for(String genreName: genre.getGenreList()){
          out.write("\n");
          out.write("        <a id=\"genre_link\" href=\"book.jsp\"><li id=\"author_li\">");
          out.print(genreName);
          out.write("</li></a>\n");
          out.write("        ");
}
          out.write("\n");
          out.write("     \n");
          out.write("        </div>\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("    </body>\n");
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
