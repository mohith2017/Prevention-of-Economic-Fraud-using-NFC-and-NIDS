<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.sql.ResultSet"%>
   <%@ page import="com.Database.*" %>
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
	
	Date date = null;
	SimpleDateFormat formate = null;
	String year = "",month = "",day="",today="";
	
%>

<%	
	date = new Date();
    formate = new SimpleDateFormat("yyyy-MM-dd");
    today = formate.format(date);
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

<form name="acc_form" method="post" action="<%=request.getContextPath()%>/AddAccountDetails" onsubmit="return checkFormValidator()">

<center>
   
	<div align="center">
	  <center>
	  	<p align="center"><b><font size="5" color="#0000CD">Add Account Details</font></b></td>
	  
	  <table border="0"  style="position: absolute;width: 800px;height: 400px;">
	  
		<tr>
		 		<td>
		 				Account Number 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_no" required="yes" placeholder="Please Enter Acc No"/>
		 		</td>
		 		
		 		<td width="50px">
		 				&nbsp;
		 		</td>
		 		
		 		<td>
		 				Account Holder Id 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_id" required="yes" placeholder="Please Enter Id"/>
		 		</td>
		 		
		</tr>
		
			
		<tr>
		 		<td>
		 				Account Holder Password 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="password" name="acc_pwd" required="yes" placeholder="Please Enter Password"/>
		 		</td>
		 		
		 		<td width="50px">
		 				&nbsp;
		 		</td>
		 		<td>
		 				Account Holder Name 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_holder" required="yes" placeholder="Please Enter Name"/>
		 		</td>
		 		
		 		
		</tr>
		
		<tr>
		 		<td>
		 				Account Holder Card Number 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_card_no" required="yes" placeholder="Please Enter Card No"/>
		 		</td>
		 		
		 		<td width="50px">
		 				&nbsp;
		 		</td>
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
		 		       
		 				<select name="acc_type" required="yes">
		 						<option value="0">-Select Account Type-</option>
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
		 		<td width="50px">
		 				&nbsp;
		 		</td>
		 		
		 		<td>
		 				Branch 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<select name="branch" style="width: 158px;" required="yes">
		 						<option value="0">--Select Branch--</option>
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
		 				<input type="text" name="closing_balance" required="yes" placeholder="Enter Closing Balance"/>
		 		</td>
		 		<td width="50px">
		 				&nbsp;
		 		</td>
		 		
		 		<td>
		 				Reffered By 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="reffered_by" required="yes" placeholder="Enter Reffered By"/>
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
		 				<input type="text" name="contact" required="yes" placeholder="Enter Cantact Number"/>
		 		</td>
		 		<td width="50px">
		 				&nbsp;
		 		</td>
		 		<td>
		 				EmailId 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="email_id" required="yes" placeholder="Enter Email Id"/>
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
		 						<option value="Active">Active</option>
		 						<option value="Closed">Closed</option>
		 				</select>
		 		</td>
		 		
		 		
		</tr>
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="10">
				        
				        <input type="reset" value="Reset" />
				        
				        <input type="submit" value="Add Account" onclick="return checkFormValidator()" />
				</td>
		</tr>
		
	  </table>
	  </center>
	</div>
	</center>
   
</form>


</body>
</html>