<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.sql.ResultSet"%>
<%@page import="com.Database.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script language="javascript">
 	
 	function checkFormValidator()
 	{
 	
 		if(document.acc_form.acc_type.value=="0")
 		{
 			alert("Plese,Select The Account Type.");
 			document.acc_form.acc_type.focus();
 			return false;
 		}
 		
 		
        else if(document.acc_form.branch.value=="0")
 		{
 			alert("Plese,Select The Branch.");
 			document.acc_form.branch.focus();
 			return false;
 		}
 		
	}

</script>
</head>
<body bgcolor="white">

<DIV id=popCal onclick=event.cancelBubble=true style="BORDER-BOTTOM: 2px ridge; BORDER-LEFT: 2px 
ridge; BORDER-RIGHT: 2px ridge; BORDER-TOP: 2px ridge; POSITION: absolute; VISIBILITY: hidden; 
WIDTH: 10px; Z-INDEX: 100">
<IFRAME frameBorder=0 height=188 name=popFrame scrolling=no src="images/popcjs.htm" width=183>
</IFRAME>
</DIV>
<script event=onclick() 
                for=document>popCal.style.visibility = "hidden";
 </script>
 
<%!
	ResultSet rs = null;

	String existenceStatus="";
	String add=""; 
	
	SimpleDateFormat formate = null;
	String year = "",month = "",day="",today="";
	
	String accountNumber = "",accountHolderName="",accClosingBalance="",accReferedBy="",accStatus="",mobileNumber="",emailId="";
	int accountId = 0,accountTypeId=0,branchId=0;
	Date acc_open_date = null; 
	
%>

<%	
    
    accountNumber = request.getParameter("acc_no");
    rs = adduserdao.getAccountDetailsById(accountNumber);
    
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

    formate = new SimpleDateFormat("yyyy-MM-dd");
    today = formate.format(acc_open_date);
    String data[] = today.split("-");
    year = data[0];
    month = data[1];
    day = data[2];
    
	existenceStatus=(String) session.getAttribute("existenceStatus");

	if(existenceStatus==null)
	{
		
	}
	else if(existenceStatus=="yes")
	{
%>
		<h2><center><font color=red><b>Sorry,This Account Number Already Exists!</b></font></center></h2>
<%
		session.removeAttribute("existenceStatus");
	}
	
	add=(String) session.getAttribute("add");

	if(add==null)
	{
		
	}
	else if(add=="failed")
	{
%>
		<h2><center><font color=red><b>Opps,Something Went Wrong,Try Again..</b></font></center></h2>
<%
		session.removeAttribute("add");
	}

%>

<form name="acc_form" method="post" action="<%=request.getContextPath()%>/UpdateAccountDetails" onsubmit="return checkFormValidator()">

  
<center>
 
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
		 				<input type="text" name="acc_no" value="<%=accountNumber %>" disabled="disabled"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Account Holder Name 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_holder" value="<%=accountHolderName %>" required="yes"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Opening Date 
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="date_yyyy" value="<%=year%>" size="1"/>
		 				/
		 				<input type="text" name="date_mm" value="<%=month%>" size="1"/>
		 				/
		 				<input type="text" name="date_dd" value="<%=day%>" size="1"/>
		 				<br>
		 				&nbsp;&nbsp;yyyy &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mm
		 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; dd
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Account Type 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td> 
		 		       
		 				<select name="acc_type" required="yes" style="width: 158px;" required="yes">
		 						<option value="<%=accountTypeId %>" selected="selected"><%=adduserdao.getAccountTypeById(accountTypeId)%></option>
		 						<%
		 							rs = adduserdao.getAccountType();
		 						    while(rs.next())
		 						    {
		 						%>
		 						
		 						<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
		 						
		 						<%
		 							} 
		 						%>
		 				</select>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Branch 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<select name="branch" style="width: 158px;" required="yes">
		 						<option value="<%=branchId %>" selected="selected"><%=adduserdao.getBranchById(branchId)%></option>
		 						<%
		 							rs = adduserdao.getBranchDetails();
		 						    while(rs.next())
		 						    {
		 						%>
		 						
		 						<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
		 						
		 						<%
		 							} 
		 						%>
		 				</select>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Closing Balance 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="closing_balance" value="<%=accClosingBalance%>" />
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Reffered By 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="reffered_by" value="<%=accReferedBy %>"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Contact Number
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="contact" value="<%=mobileNumber %>" required="yes"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				EmailId 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="email_id" value="<%=emailId %>" required="yes"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Account Status 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<select name="status" style="width: 158px;">
		 				        <option value="<%=accStatus %>" selected="selected"><%=accStatus %></option>
		 						<option value="Active">Active</option>
		 						<option value="Closed">Closed</option>
		 				</select>
		 		</td>
		</tr>
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="3">
				        
				        <input type="hidden" name="acc_id" value="<%=accountId%>">
				        <input type="reset" value="Reset" />
				        <input type="submit" value="Update Account" onclick="return checkFormValidator()" />
				</td>
		</tr>
		
	  </table>
	  </center>
	</div>
	</center>
   
</form>


</body>
</html>