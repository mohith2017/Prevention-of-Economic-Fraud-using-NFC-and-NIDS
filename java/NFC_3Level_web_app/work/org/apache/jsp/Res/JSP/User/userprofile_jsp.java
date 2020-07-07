package org.apache.jsp.Res.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.support.Utility;
import com.Database.*;

public final class userprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("       \r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>User Profile</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"m_account\" action=\"");
      out.print(request.getContextPath());
      out.write("/Res/JSP/User/edit_account.jsp\" method=\"post\">\r\n");
      out.write("\r\n");

	
    ResultSet rs = null;
	String accountNumber = "",accountHolderName="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
	int accountId = 0,accountTypeId=0,branchId=0;
	Date acc_open_date = null; 
	
	String uid="",update="";

	uid=(String) session.getAttribute("userid");
	
	
	
	//update=(String)request.getAttribute("update");
	
	rs = adduserdao.getAccountDetailsById1(uid);
	
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
	}
	System.out.println("accountTypeId :"+accountTypeId);
	

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<div align=\"left\">\r\n");
 
	  
    if(update==null)
	{
		
	}
	else if(update=="success")
	{
	  

      out.write("\r\n");
      out.write("  <h2><center><font color=blue><b>Profile Details Updated Successfully !!!</b></font></center></h2>\r\n");

	}
	
	else if(update=="failed")
	{

      out.write("\r\n");
      out.write("\t\t<h2><center><font color=blue><b>Opps,Updation Process Failed Try Again..</b></font></center></h2>\r\n");

	}

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" > User Profile Details </font></b>\r\n");
      out.write("\t\t  </td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t\t<td colspan=\"5\" align=\"center\"><hr></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  \r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t  <center>\r\n");
      out.write("\t  <br>\r\n");
      out.write("\t  <table border=\"0\" width=\"50%\">\r\n");
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
      out.write("\t\t \t\t\t\t");
      out.print( accountNumber );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tAccount Holder Name \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t");
      out.print( accountHolderName );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tOpening Date \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t");
      out.print( acc_open_date );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
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
      out.write("\t\t \t\t       ");
      out.print( adduserdao.getAccountTypeById(accountTypeId));
      out.write("\r\n");
      out.write("\t\t \t\t\t\t\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tBranch \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t");
      out.print( adduserdao.getBranchById(branchId) );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
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
      out.write("\t\t \t\t\t\t");
      out.print( accClosingBalance );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tReffered By \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t");
      out.print(accReferedBy );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
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
      out.write("\t\t \t\t\t\t");
      out.print( mobileNumber );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\tEmailId \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td width=\"50px\">\r\n");
      out.write("\t\t \t\t\t\t:\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t \t\t\t\t");
      out.print( emailId );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
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
      out.write("\t\t \t\t\t\t");
      out.print( accStatus );
      out.write("\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr></tr>\r\n");
      out.write("\t\t<tr height=\"25px\"></tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t \t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t \t\t\t\t<input type=\"hidden\" name=\"acc_no\" value=\"");
      out.print(accountNumber);
      out.write("\"/>\r\n");
      out.write("\t\t \t\t\t\t<input type=\"submit\" value=\"Update Profile\">\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t \r\n");
      out.write("\t  </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</center>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert(\"User Details Updated Successfully!!\");\r\n");
      out.write("\t\t</script>\t\t\t\r\n");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:421px;left:11px\">\t\r\n");
      out.write("\t\t\t<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");

	}
	

      out.write("\r\n");
      out.write("\r\n");
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
