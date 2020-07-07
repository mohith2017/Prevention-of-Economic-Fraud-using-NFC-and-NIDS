<%@ page language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.Database.*" %>
      <%@ page import="com.support.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Type Details</title>
</head>
<body bgcolor="white">

<%
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
%>
		<h2><center><font color=blue><b>Account Details Added Successfully !!!<br>	
<%
		session.removeAttribute("add");
	}
	
	else if(add=="failed")
	{
%>
		<h2><center><font color=blue><b>Opps,Something Went Wrong Try Again..<br>	
<%
		session.removeAttribute("add");
	}
	
	update=(String) session.getAttribute("update");

	if(update==null)
	{
		
	}
	else if(update=="success")
	{
%>
		<h2><center><font color=blue><b>Account Details Updated Successfully !!!<br>
<%
	}
	
	else if(update=="failed")
	{
%>
		<h2><center><font color=blue><b>Opps,Updation Process Failed Try Again..<br>
<%
		session.removeAttribute("update");
	}
	
	delete=(String) session.getAttribute("delete");

	if(delete==null)
	{
		
	}
	else if(delete=="success")
	{
%>
		<h2><center><font color=blue><b>Account Details Deleted Successfully !!!<br>
		
<%
		session.removeAttribute("delete");

	}
	
	else if(delete=="failed")
	{
%>
		<h2><center><font color=red><b>Account Details Deletion Failed!!!<br>
		
<%
		session.removeAttribute("delete");

	}
%>


<form name="acc_form" action="<%=request.getContextPath()%>/Res/JSP/Admin/add_account.jsp" method="post">
    <center>
<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#0000CD">Account Details</font></b></td>
		</tr>
	  </table>
	</div>
	<br>
<table align="center" border="2" width="100%">
  <tr>
    <th>
      <p align="center">Account Number</b></font></p>
    </th>
   
    <th>
      <p align="center">Account Holder</b></font></p>
    </th>
    
    <th>
      <p align="center">Opening Date</b></font></p>
    </th>
    
    <th>
      <p align="center">AccountType</b></font></p>
    </th>
    <th>
      <p align="center">Email Id</font></b></p>
    </th>
    
    <th>
      <p align="center">Contact</b></font></p>
    </th>
    
    <th>
      <p align="center">Status</b></font></p>
    </th>
    
    <th>
      <p align="center">Edit</b></font></p>
    </th>
    
    <th>
      <p align="center">Delete</b></font></p>
    </th>
    
   </tr>
 <%
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
		

%>

  <tr>
    <td  align="center"><%=accountNumber %></td>
    <td  align="center"><%=accountHolderName %></td>
    <td  align="center"><%=acc_open_date%></td>
    <td  align="center"><%=adduserdao.getAccountTypeById(accountTypeId)%></td>
    <td  align="center"><%=emailId%></td>
    <td  align="center"><%=mobileNumber %></td>
    <td  align="center"><%=accStatus%></td>
    
    <td width="4%" align="center">
      <p align="center"><a href="edit_account.jsp?acc_no=<%=accountNumber%>">Edit</a></p>
    </td>
    <td width="5%" align="center">
      <p align="center"><a href="<%=request.getContextPath()%>/DeleteAccountDetails?acc_no=<%=accountNumber%>" onclick="return confirm('Do you want to delete <%=branchId%>?')">Delete</a></p>
    </td>
    
  </tr>


<%
	}
%>

</table>

<br><br>

	<center>
		<input type="submit" value="Add Account">
	</center>

</form>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("User Added Successfully!!");
		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<div class="error" id="message" style="position:absolute;top:421px;left:11px">	
			<p>Opps,Something Went Wrong Try Again Latter!!!!!</p>
		</div>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<script type="text/javascript">
		alert("Account Details Updated Successfully!!");
		</script>			
<%
	}
	
%>


</body>
</html>
