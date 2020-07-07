<%@ page language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.Database.*"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Type Details</title>
</head>
<body bgcolor="white">

<%
	String accountType="",desc="",acc_trans_limit="";
	String add="",update="",delete="";
	int accTypeId = 0;
	
	DAO connectobj = new DAO();
	Connection con=connectobj.connector();
	Statement st=(Statement) con.createStatement();
	
	String query="select * from m_acc_type";
	ResultSet rs=st.executeQuery(query);
	
	add=(String) session.getAttribute("add");

	if(add==null)
	{
		
	}
	else if(add=="success")
	{
%>
		<h2><center><font color=blue><b>Account Type Details Added Successfully !!!<br>	
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
		<h2><center><font color=blue><b>Account Type Details Successfully !!!<br>
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
		<h2><center><font color=blue><b>Account Type Details Deleted Successfully !!!<br>
		
<%
		session.removeAttribute("delete");

	}
	
	else if(delete=="failed")
	{
%>
		<h2><center><font color=red><b>Account Type Details Deletion Failed!!!<br>
		
<%
		session.removeAttribute("delete");

	}
%>


<form name="acc_type_form" action="adduser.jsp" method="post">
    <center>
<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#0000CD">Account Type Details</font></b></td>
		</tr>
	  </table>
	</div>
	<br>
<table align="center" border="2" width="100%">
  <tr>
    <th>
      <p align="center">Account TypeID</b></font></p>
    </th>
    <th>
      <p align="center">Account Type</b></font></p>
    </th>
    <th>
      <p align="center">Description</font></b></p>
    </th>
   <th>
      <p align="center">Transaction Limit</b></font></p>
    </th>
    
   </tr>
 <%
	while(rs.next())
	{
		accTypeId=rs.getInt(1);
		accountType=rs.getString(2);
        desc=rs.getString(3);
        acc_trans_limit=rs.getString(4);

%>

  <tr>
    <td width="10%" align="center"><%=accTypeId %></td>
    <td width="25%" align="center"><%=accountType%></td>
    <td width="40%" align="center">
      <p align="center"><%=desc%></p>
    </td>
    <td width="25%" align="center">
      <p align="center"><%=acc_trans_limit%></p>
    </td>
  </tr>


<%
	
	}
%>


</table>

<br><br>
<%-- 
	<center>
		<input type="submit" value="Add AccountType">
	</center>
--%>
</form>


</body>
</html>
