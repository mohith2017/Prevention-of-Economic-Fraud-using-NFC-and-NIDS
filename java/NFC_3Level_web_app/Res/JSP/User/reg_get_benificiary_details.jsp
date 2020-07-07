<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
</head>
<body bgcolor="white">

<%
	String existenceStatus="",getAccInfo="";
	String add="",accountNumber="",accountHolderName=""; 
	
%>

<%	
	
	accountNumber=(String) session.getAttribute("acc_no");
    accountHolderName=(String) session.getAttribute("acc_name");
	existenceStatus=(String) session.getAttribute("existenceStatus");

	if(existenceStatus==null)
	{
		
	}
	else if(existenceStatus=="Yes")
	{
%>
		<h2><center><font color=red><b>Sorry,This Account Number Does not Exists!</b></font></center></h2>
<%
		session.removeAttribute("existenceStatus");
	}
	
%>

<form name="reg_benificiary" method="post" action="<%=request.getContextPath()%>/ConfirmBenificiary">

<center>
   
	<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" >Register Benificiary </font></b></td>
		</tr>
	  </table>
	  
	  <hr>
	  
	</div>
	<div align="center">
	  <center>
	  <br>
	  <table border="0" width="50%">
	  
	   <tr align="center">
		 		<td colspan="3" align="center">
		 				<font color="green" size="5">Check Benificiary Account Details</font>
		 		</td>
		 		
		</tr>
		
		<tr align="center">
		    <td colspan="3">
		    	<hr>
		    </td>
		</tr>
		
		<tr height="20px">
		</tr>
	  
		<tr align="center">
		 		<td width="150px">
		 				Account Number
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td width="200px">
		 				<%= accountNumber %>
		 		</td>
		</tr>
		
		<tr align="center">
		 		<td width="150px">
		 				Account Holder Name
		 		</td>
		 		
		 		<td >
		 				:
		 		</td>
		 		
		 		<td width="200px">
		 				<%= accountHolderName %>
		 		</td>
		</tr>
		
		<tr height="20px" align="center"></tr>
		
		<tr align="center">
				<td align="center" colspan="3">
				        
				        <input type="hidden" name="acc_no" value="<%=accountNumber %>"/>
				        <input type="hidden" name="acc_name" value="<%=accountHolderName %>"/>
				        <input type="submit" name="RegAction" value="Cancel" />
				        <input type="submit" name="RegAction" value="Confirm Registeration"  />
				</td>
		</tr>
		
	  </table>
	  </center>
	</div>
	</center>
   
</form>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("URN Number Successfully Sent to your EmailId.  Now You Can Confirm Benificiary by providing the URN Number through Confirn/Reject Link.!!");
		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<script type="text/javascript">
		alert("Opps,Unable to Send URN Number to EmailId !!!!!!!");
		</script>
		
				
<%
	}
	
%>
</body>
</html>