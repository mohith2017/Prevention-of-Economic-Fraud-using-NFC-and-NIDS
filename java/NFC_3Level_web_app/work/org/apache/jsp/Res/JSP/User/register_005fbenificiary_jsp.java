package org.apache.jsp.Res.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_005fbenificiary_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Add Branch</title>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write(" \t\r\n");
      out.write(" \tfunction checkFormValidator()\r\n");
      out.write(" \t{\r\n");
      out.write(" \t\r\n");
      out.write(" \t\tif(document.reg_benificiary.acc_no.value==\"\")\r\n");
      out.write(" \t\t{\r\n");
      out.write(" \t\t\talert(\"Plese Enter The Account Number.\");\r\n");
      out.write(" \t\t\tdocument.reg_benificiary.acc_no.focus();\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("\r\n");

	String existenceStatus="",getAccInfo="";
	String add=""; 
	

      out.write("\r\n");
      out.write("\r\n");
	
	existenceStatus=(String) session.getAttribute("existenceStatus");

	if(existenceStatus==null)
	{
		
	}
	else if(existenceStatus=="Yes")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=red><b>Sorry,This Account Number Does not Exists!</b></font></center></h2>\r\n");

		session.removeAttribute("existenceStatus");
	}
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"reg_benificiary\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/RegisterBenificiary\" onsubmit=\"return checkFormValidator()\">\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("   \r\n");
      out.write("\t<div align=\"left\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" >Register Benificiary </font></b></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <hr>\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t  <center>\r\n");
      out.write("\t  <br>\r\n");
      out.write("\t  <table border=\"0\" width=\"50%\">\r\n");
      out.write("\t  \r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Number\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_no\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<!-- \t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tEmailId\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_no\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr height=\"20px\"></tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        <input type=\"reset\" value=\"Reset\" />\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        <input type=\"submit\" value=\"Register\" onclick=\"return checkFormValidator()\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</center>\r\n");
      out.write("   \r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
