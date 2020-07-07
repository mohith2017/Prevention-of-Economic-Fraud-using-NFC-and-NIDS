package org.apache.jsp.Res.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.Database.*;
import com.Database.UserDAO;
import com.Database.adduserdao;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class mini_005fstatement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	String uid="";
	String transactionType="",TransactionAccount,transactionAmount="",transDate="",accBalance="",benificiaryAccountHolder="";
	ResultSet rs = null;
	ResultSet rs1 = null;

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Account Type Details</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"white\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("EEEE dd-MM-yyyy HH:mm");
	String today = f.format(date);
	uid = (String)session.getAttribute("userid");
	
	rs = UserDAO.getTransactionDetails(uid);
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<div align=\"left\">\r\n");
      out.write("\t  <table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"100%\">\r\n");
      out.write("\t\t\t<p align=\"center\"><b><font size=\"5\" color=\"#000000\">Mini Statement Details</font></b></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <hr>\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("<table align=\"center\" border=\"2\" width=\"80%\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Transaction Date</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Amount</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    <th>\r\n");
      out.write("      <p align=\"center\">Transaction Type</font></b></p>\r\n");
      out.write("    </th>\r\n");
      out.write("   <th>\r\n");
      out.write("      <p align=\"center\">Funded Account</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("     <th>\r\n");
      out.write("      <p align=\"center\">Funded AccountHolder</b></font></p>\r\n");
      out.write("    </th>\r\n");
      out.write("    \r\n");
      out.write("   </tr>\r\n");
      out.write(" ");

	while(rs.next())
	{
		transDate = rs.getString(2);
		transactionType = rs.getString(4);
		transactionAmount = rs.getString(5);
		TransactionAccount = rs.getString(6);
		
		rs1 = adduserdao.getAccountDetailsById(TransactionAccount);
		if(rs1.next())
		{
			benificiaryAccountHolder = rs1.getString(4);
		}
		
		String data[] = transDate.split("-");
		transDate = data[2]+"-"+data[1]+"-"+data[0];


      out.write("\r\n");
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td align=\"center\">");
      out.print(transDate);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(transactionAmount);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(transactionType);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(TransactionAccount);
      out.write("</td>\r\n");
      out.write("    <td  align=\"center\">");
      out.print(benificiaryAccountHolder);
      out.write("</td>\r\n");
      out.write("    \r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");

	}
 
rs = adduserdao.getAccountDetailsById1(uid);
if(rs.next())
{
	accBalance = rs.getString(7);
}

 

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t\t<td colspan=\"4\" align=\"center\"><b> Account Balance </b> </td>\r\n");
      out.write("\t\t<td align=\"center\"><b>Rs. ");
      out.print(accBalance );
      out.write("</b></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t\t<td colspan=\"5\" align=\"center\"><b>Statement Date :        </b>  <b>");
      out.print(today);
      out.write("</td>\r\n");
      out.write("\t\t\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
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
