<%@ page language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.Database.*"%>
<%@page import="com.Database.UserDAO"%>
<%@page import="com.Database.adduserdao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Type Details</title>
</head>
<body bgcolor="white">

<%!
	String userAccount="";
	String transactionType="",TransactionAccount,transactionAmount="",transDate="",accBalance="",benificiaryAccountHolder="";
	ResultSet rs = null;
	ResultSet rs1 = null;
%>

<%
	Date date = new Date();
	SimpleDateFormat f = new SimpleDateFormat("EEEE dd-MM-yyyy HH:mm");
	String today = f.format(date);
	userAccount = (String)session.getAttribute("userid");
	
	String accno = admindao.getAccNo(userAccount);
	
	rs = UserDAO.getTransactionDetails(accno);
	
%>

<center>
<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#000000">Transaction Details</font></b></td>
		</tr>
	  </table>
	  
	  <hr>
	  
	</div>
	<br>
<table align="center" border="2" width="80%">
  <tr>
    <th>
      <p align="center">Transaction Date</b></font></p>
    </th>
    <th>
      <p align="center">Amount</b></font></p>
    </th>
    <th>
      <p align="center">Transaction Type</font></b></p>
    </th>
   <th>
      <p align="center">Funded Account</b></font></p>
    </th>
    
     <th>
      <p align="center">Funded AccountHolder</b></font></p>
    </th>
    
   </tr>
 <%
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

%>

  <tr>
    <td align="center"><%=transDate%></td>
    <td  align="center"><%=transactionAmount%></td>
    <td  align="center"><%=transactionType%></td>
    <td  align="center"><%=TransactionAccount%></td>
    <td  align="center"><%=benificiaryAccountHolder%></td>
    
  </tr>
  
<%
	}
%>


</table>



</body>
</html>
