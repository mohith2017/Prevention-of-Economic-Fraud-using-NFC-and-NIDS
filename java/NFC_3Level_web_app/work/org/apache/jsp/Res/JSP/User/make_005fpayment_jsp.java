package org.apache.jsp.Res.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.support.Utility;
import java.sql.ResultSet;
import com.Database.UserDAO;
import com.Database.admindao;

public final class make_005fpayment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs = null;
	String validationMsg="",confirmationStatus="",userAccNumber="",transLimit="",error="";
	String add=""; 
	

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
      out.write("       \r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write(" \t\tif(document.make_payment.acc_no.value==\"0\")\r\n");
      out.write(" \t\t{\r\n");
      out.write(" \t\t\talert(\"Please,Select A Benificiary From The Dropdown.\");\r\n");
      out.write(" \t\t\tdocument.make_payment.acc_no.focus();\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t}\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\tif(document.make_payment.amt_toPaid.value==\"\")\r\n");
      out.write(" \t\t{\r\n");
      out.write(" \t\t\talert(\"Please,Enter The Transfer Amount To Pay.\");\r\n");
      out.write(" \t\t\tdocument.make_payment.amt_toPaid.focus();\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t}\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\r\n");
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
	
userAccNumber = (String) session.getAttribute("userid");


String accno = admindao.getAccNo(userAccNumber);
	rs = UserDAO.getConfirmedBenificiaryDetails(accno);
    
     
    validationMsg=(String) session.getAttribute("validationMsg");
    transLimit=(String) session.getAttribute("transLimit");
    error=(String) session.getAttribute("error");

	
	if(!rs.next())
	{


      out.write("\r\n");
      out.write("<div align=\"left\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" >Confirm/Reject Benificiary</font></b></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <hr>\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("<h2><center><font color=red><b>Opps,There is no benificiary to make Payment.</b><br>\r\n");
      out.write("                               Register Benificiary First,Then Try to make Payment.\r\n");
      out.write("</font></center></h2>\r\n");
      out.write("\r\n");

	}
	else
	{
		rs.previous();//Pointing the Cursor to the previous row.
		

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"make_payment\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/MakePaymentToBenificiary\" onsubmit=\"return checkFormValidator()\">\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("\t<div align=\"left\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" >Make Payment</font></b></td>\r\n");
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
      out.write("\t\t \t\t\t\tBanificiary Name\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<select name=\"acc_no\" required=\"yes\" style=\"width: 158px;\">\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"0\">--Select Benificiary--</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							
		 						    while(rs.next())
		 						    {
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t<option value=\"");
      out.print(rs.getString(3));
      out.write('"');
      out.write('>');
      out.print(rs.getString(4));
      out.write("</option>\r\n");
      out.write("\t\t \t\t\t\t\t\t\r\n");
      out.write("\t\t \t\t\t\t\t\t");

		 							} 
		 						
      out.write("\r\n");
      out.write("\t\t \t\t\t\t</select>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAmount To Pay\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"text\" name=\"amt_toPaid\"/>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr height=\"20px\"></tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        <input type=\"submit\" name=\"Action\" value=\"Pay Amount\" onclick=\"return checkFormValidator()\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  </center>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</center>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin-left: 400px;top: 205px;position: absolute;left: 100\">\r\n");
      out.write("<form action=\"MakePaymentToBenificiary\" method=\"post\">\r\n");
      out.write("\t<input type=\"submit\" name=\"Action\" value=\"Cancel\"/>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\t  \r\n");

	if(validationMsg == null )
	{
		
	}
	else if(validationMsg.equals("outOfLimit"))
	{

      out.write("\r\n");
      out.write("<h2><center><font color=red>Opps,Amount to pay is Out of Transaction Limit.<br></font></center></h2>\r\n");
      out.write("\r\n");

    session.removeAttribute("validationMsg");
	}
	if(transLimit == null )
	{
		
	}
	else 
	{
	
      out.write("\r\n");
      out.write("<h2><center><font color=green>Your Transaction Limit = Rs. ");
      out.print(transLimit);
      out.write(" </h2>\r\n");
      out.write("\r\n");
      out.write("\t");

	session.removeAttribute("transLimit");
	}
	if(error == null )
	{
		
	}
	else if(error.equals("Yes"))
	{

      out.write("\r\n");
      out.write("<h2><center><font color=red>Opps,Something Went Wrong Try It Again...<br></font></center></h2>\r\n");
      out.write("\r\n");

    session.removeAttribute("error");
	}

      out.write("\t  \r\n");
      out.write("\r\n");
      out.write("\t  \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");

}

      out.write("\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert(\"Opps,Something Went Wrong, Try Again...!!!!\");\r\n");
      out.write("\t\t</script>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert(\"Amount Tranfered Successfully!!!!!!!\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\r\n");

	}
	
	
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
