
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.Database.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body bgcolor="white">


<form name="m_account" action="<%=request.getContextPath()%>/Res/JSP/User/edit_account.jsp" method="post">

<%
	
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
	
%>	

<center>
<div align="left">
<% 
	  
    if(update==null)
	{
		
	}
	else if(update=="success")
	{
	  
%>
  <h2><center><font color=blue><b>Profile Details Updated Successfully !!!</b></font></center></h2>
<%
	}
	
	else if(update=="failed")
	{
%>
		<h2><center><font color=blue><b>Opps,Updation Process Failed Try Again..</b></font></center></h2>
<%
	}
%>
	
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" > User Profile Details </font></b>
		  </td>
			
		</tr>
		<tr>
			     			<td colspan="5" align="center"><hr></td>
			</tr>
			     	
	  </table>
	  
	
	</div>
	<div align="center">
	  <center>
	  <br>
	  <table border="0" width="50%">
	  
		<tr>
		 		<td>
		 				Account Number 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= accountNumber %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Account Holder Name 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= accountHolderName %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Opening Date 
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= acc_open_date %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Account Type 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td> 
		 		       
		 		       <%= adduserdao.getAccountTypeById(accountTypeId)%>
		 				
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Branch 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= adduserdao.getBranchById(branchId) %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Closing Balance 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= accClosingBalance %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Reffered By 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%=accReferedBy %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Contact Number
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= mobileNumber %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				EmailId 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= emailId %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
		 		<td>
		 				Account Status 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<%= accStatus %>
		 		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr height="25px"></tr>
		
		<tr>
		 		<td colspan="3" align="center">
		 				<input type="hidden" name="acc_no" value="<%=accountNumber%>"/>
		 				<input type="submit" value="Update Profile">
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
		alert("User Details Updated Successfully!!");
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
	
%>



</body>
</html>