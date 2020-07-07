package org.apache.jsp.Res.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("   \n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title></title>\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/menu.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
String uname=request.getParameter("name");
System.out.println("=============home========"+uname);


      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("    body \n");
      out.write("    {\n");
      out.write("      background-image:url('bg.jpg');\n");
      out.write("    \n");
      out.write("        background-repeat: no-repeat;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body >\n");
      out.write("\n");
      out.write("<IMG SRC=\"");
      out.print(request.getContextPath());
      out.write("/img/header.png\" >\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("<nav class=\"menu animated flipInX\">\n");
      out.write("\n");
      out.write("\t\t<ul class=\"ul\">\n");
      out.write("      \n");
      out.write(" \n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/userprofile.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>User Profile</h3>\n");
      out.write("\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/balance_enquiry.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>Balance Enquiry</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/mini_statement.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t<!-- <a href=\"#\" ><span>Fund Transfer</span></a> -->\n");
      out.write("\t\t\t\t<h3>Mini Statement</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("<!-- <div class =\"link\">   \n");
      out.write("<h3><b>Fund Transfer</b></h3>  \n");
      out.write("</div> -->\n");
      out.write(" \n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/register_benificiary.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>Register Benificiary</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write(" <div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/confirm_benificiary.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>Confirm/Reject Benificiary</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write(" <div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/make_payment.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>Make Payment</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class=\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/transaction.jsp\" target=\"myIframe\">\n");
      out.write("\t\t\t\t<h3>Transactions</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class =\"link\">      \n");
      out.write("\t\t\t<a class =\"a\" href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">\n");
      out.write("\t\t\t\t<h3>Logout</h3>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("</div>\n");
      out.write("      \n");
      out.write("\t\t</ul>\n");
      out.write("\t</nav>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div style=\"position:absolute;top:150px;left:300px;\">\n");
      out.write("\t<iframe align=\"middle\"  style=\"margin-left: 60px;\" \n");
      out.write("\tframeborder=\"0\" scrolling=\"auto\" name=\"myIframe\" height=\"610px\" width=\"850px\"></iframe>\n");
      out.write("</div>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
