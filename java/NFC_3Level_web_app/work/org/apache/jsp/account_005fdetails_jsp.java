package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.Database.*;
import java.util.Date;
import com.amutha.*;

public final class account_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Account Type Details</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("\r\n");

	String accountNumber = "",accountHolderName="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
	String add="",update="",delete="";
	int accountId = 0,accountTypeId=0,branchId=0;
	Date acc_open_date = null; 
	
	DAO dao = new DAO();
	Connection con=dao.connector();
	Statement st=(Statement) con.createStatement();
	
	String query="select * from m_account";
	ResultSet rs=st.executeQuery(query);
	
	add=(String) session.getAttribute("add");

	if(add==null)
	{
		
	}
	else if(add=="success")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Account Details Added Successfully !!!<br>\t\r\n");

		session.removeAttribute("add");
	}
	
	else if(add=="failed")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Opps,Something Went Wrong Try Again..<br>\t\r\n");

		session.removeAttribute("add");
	}
	
	update=(String) session.getAttribute("update");

	if(update==null)
	{
		
	}
	else if(update=="success")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Account Details Updated Successfully !!!<br>\r\n");

	}
	
	else if(update=="failed")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Opps,Updation Process Failed Try Again..<br>\r\n");

		session.removeAttribute("update");
	}
	
	delete=(String) session.getAttribute("delete");

	if(delete==null)
	{
		
	}
	else if(delete=="success")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Account Details Deleted Successfully !!!<br>\r\n");
      out.write("\t\t\r\n");

		session.removeAttribute("delete");

	}
	
	else if(delete=="failed")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=red><b>Account Details Deletion Failed!!!<br>\r\n");
      out.write("\t\t\r\n");

		session.removeAttribute("delete");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"acc_form\" action=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/Admin/add_account.jsp\" method=\"post\">\r\n");
      out.write("    <center>\r\n");
      out.write("<div align=\"left\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" color=\"#0000CD\">Account Details</font></b></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("<table align=\"center\" border=\"2\" width=\"100%\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Account Number</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("   \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Account Holder</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Opening Date</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">AccountType</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Email Id</font></b></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Contact</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Status</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Edit</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Delete</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("   </tr>\r\n");
      out.write(" ");

	while(rs.next())
	{
		accountId = rs.getInt(1);
		accountNumber = rs.getString(2);
		acc_open_date=rs.getDate(3);
		accountHolderName = rs.getString(4);
		accountTypeId = rs.getInt(5);
		branchId = rs.getInt(6);
		accClosingBalance = rs.getString(7);
		accReferedBy = rs.getString(8);
		mobileNumber = rs.getString(10);
		accStatus = rs.getString(9);
		emailId = rs.getString(11);
		


      out.write("\r\n");
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(accountNumber );
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(accountHolderName );
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(acc_open_date);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(adduserdao.getAccountTypeById(accountTypeId));
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(emailId);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(mobileNumber );
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(accStatus);
      out.write("</td>\r\n");
      out.write("    \r\n");
      out.write("    <td width=\"4%\" align=\"center\">\r\n");
      out.write("      <p align=\"center\"><a href=\"Res/JSP/Admin/edit_account.jsp?acc_no=");
      out.print(accountNumber);
      out.write("\">Edit</a></p>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td width=\"5%\" align=\"center\">\r\n");
      out.write("      <p align=\"center\"><a href=\"DeleteAccountDetails?acc_no=");
      out.print(accountNumber);
      out.write("\" onclick=\"return confirm('Do you want to delete ");
      out.print(branchId);
      out.write("?')\">Delete</a></p>\r\n");
      out.write("    </td>\r\n");
      out.write("    \r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<br><br>\r\n");
      out.write("\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Add Account\">\r\n");
      out.write("\t</center>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
