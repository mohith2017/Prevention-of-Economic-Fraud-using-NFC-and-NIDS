package org.apache.jsp.Res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.Database.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class add_005faccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs = null;

	String existenceStatus="";
	String add=""; 
	
	Date date = null;
	SimpleDateFormat formate = null;
	String year = "",month = "",day="",today="";
	

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Add Branch</title>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write(" \t\r\n");
      out.write(" \tfunction checkFormValidator()\r\n");
      out.write(" \t{\r\n");
      out.write(" \t\r\n");
      out.write(" \t\tif(document.acc_form.acc_type.value==\"0\")\r\n");
      out.write(" \t\t{\r\n");
      out.write(" \t\t\talert(\"Plese,Select The Account Type.\");\r\n");
      out.write(" \t\t\tdocument.acc_form.acc_type.focus();\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\t\r\n");
      out.write("        else if(document.acc_form.branch.value==\"0\")\r\n");
      out.write(" \t\t{\r\n");
      out.write(" \t\t\talert(\"Plese,Select The Branch.\");\r\n");
      out.write(" \t\t\tdocument.acc_form.branch.focus();\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("\r\n");
      out.write("<DIV id=popCal onclick=event.cancelBubble=true style=\"BORDER-BOTTOM: 2px ridge; BORDER-LEFT: 2px \r\n");
      out.write("ridge; BORDER-RIGHT: 2px ridge; BORDER-TOP: 2px ridge; POSITION: absolute; VISIBILITY: hidden; \r\n");
      out.write("WIDTH: 10px; Z-INDEX: 100\">\r\n");
      out.write("<IFRAME frameBorder=0 height=188 name=popFrame scrolling=no src=\"images/popcjs.htm\" width=183>\r\n");
      out.write("</IFRAME>\r\n");
      out.write("</DIV>\r\n");
      out.write("<script event=onclick() \r\n");
      out.write("                for=document>popCal.style.visibility = \"hidden\";\r\n");
      out.write(" </script>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
	
	date = new Date();
    formate = new SimpleDateFormat("yyyy-MM-dd");
    today = formate.format(date);
    String data[] = today.split("-");
    year = data[0];
    month = data[1];
    day = data[2];

	existenceStatus=(String) session.getAttribute("existenceStatus");

	if(existenceStatus==null)
	{
		
	}
	else if(existenceStatus=="yes")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=red><b>Sorry,This Account Number Already Exists!</b></font></center></h2>\r\n");

		session.removeAttribute("existenceStatus");
	}
	
	add=(String) session.getAttribute("add");

	if(add==null)
	{
		
	}
	else if(add=="failed")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=red><b>Opps,Something Went Wrong,Try Again..</b></font></center></h2>\r\n");

		session.removeAttribute("add");
	}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"acc_form\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/AddAccountDetails\" onsubmit=\"return checkFormValidator()\">\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("   \r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t  <center>\r\n");
      out.write("\t  \t<p align=\"center\"><b><font size=\"5\" color=\"#0000CD\">Add Account Details</font></b></td>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <table border=\"0\"  style=\"position: absolute;width: 800px;height: 400px;\">\r\n");
      out.write("\t  \r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Number \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_no\" required=\"yes\" placeholder=\"Please Enter Acc No\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Holder Id \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_id\" required=\"yes\" placeholder=\"Please Enter Id\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Holder Password \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"password\" name=\"acc_pwd\" required=\"yes\" placeholder=\"Please Enter Password\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Holder Name \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_holder\" required=\"yes\" placeholder=\"Please Enter Name\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Holder Card Number \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"acc_card_no\" required=\"yes\" placeholder=\"Please Enter Card No\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tOpening Date \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"date_yyyy\" value=\"");
      out.print(year);
      out.write("\" size=\"1\"/>\r\n");
      out.write("\t\t \t\t\t\t/\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"date_mm\" value=\"");
      out.print(month);
      out.write("\" size=\"1\"/>\r\n");
      out.write("\t\t \t\t\t\t/\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"date_dd\" value=\"");
      out.print(day);
      out.write("\" size=\"1\"/>\r\n");
      out.write("\t\t \t\t\t\t<br>\r\n");
      out.write("\t\t \t\t\t\t&nbsp;&nbsp;yyyy &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mm\r\n");
      out.write("\t\t \t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; dd\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Type \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td> \r\n");
      out.write("\t\t \t\t       \r\n");
      out.write("\t\t \t\t\t\t<select name=\"acc_type\" required=\"yes\">\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"0\">-Select Account Type-</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							rs = adduserdao.getAccountType();
		 						    while(rs.next())
		 						    {
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							} 
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t</select>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tBranch \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<select name=\"branch\" style=\"width: 158px;\" required=\"yes\">\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"0\">--Select Branch--</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							rs = adduserdao.getBranchDetails();
		 						    while(rs.next())
		 						    {
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							} 
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t</select>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tClosing Balance \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"closing_balance\" required=\"yes\" placeholder=\"Enter Closing Balance\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tReffered By \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"reffered_by\" required=\"yes\" placeholder=\"Enter Reffered By\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tContact Number\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"contact\" required=\"yes\" placeholder=\"Enter Cantact Number\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t&nbsp;\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tEmailId \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"email_id\" required=\"yes\" placeholder=\"Enter Email Id\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Status \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<select name=\"status\" style=\"width: 158px;\">\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"Active\">Active</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"Closed\">Closed</option>\r\n");
      out.write("\t\t \t\t\t\t</select>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr height=\"20px\"></tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"10\">\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        <input type=\"reset\" value=\"Reset\" />\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        <input type=\"submit\" value=\"Add Account\" onclick=\"return checkFormValidator()\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
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
