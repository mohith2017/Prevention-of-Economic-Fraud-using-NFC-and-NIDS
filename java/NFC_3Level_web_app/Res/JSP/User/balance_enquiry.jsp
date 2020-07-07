<%@ page language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.Database.*"%>
<%@page import="com.Database.adduserdao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance Enquiry</title>
</head>
<body bgcolor="white">

<%
	String accountNumber="",accountHolderName="",balance="",uid="";
	int accId = 0;
	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
	String today = f.format(date);
	ResultSet rs = null;
	
	uid = (String)session.getAttribute("userid");
	
	
	rs = adduserdao.getAccountDetailsById1(uid);
	
	while(rs.next())
	{
		accId=rs.getInt(1);
		accountNumber=rs.getString(2);
		accountHolderName = rs.getString(4);
		balance = rs.getString(7);
	}
	
	
%>

<center>

<div align="left">

	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#000000">Account Balance Details</font></b></td>
		</tr>
	  </table>
	  <hr>	  
</div>
<br>

<table align="center">
	<tr>
			<td>
					Account Number
			</td>
			
			<td width="30px">
					:
			</td>
			
			<td>
					<%=accountNumber%>
			</td>
	</tr>
	
	<tr>
			<td>
					Account Holder
			</td>
			
			<td width="30px">
					:
			</td>
			
			<td>
					<%=accountHolderName%>
			</td>
	</tr>
	
	<tr>
			<td>
					Account Balance
			</td>
			
			<td width="30px">
					:
			</td>
			
			<td>
				 <b> Rs.&nbsp;<%=balance%> </b>
			</td>
	</tr>
	
	<tr>
			<td>
					Date
			</td>
			
			<td width="30px">
					:
			</td>
			
			<td>
				 <b> <%=today%> </b>
			</td>
	</tr>
	
</table>

</center>
</body>
</html>
