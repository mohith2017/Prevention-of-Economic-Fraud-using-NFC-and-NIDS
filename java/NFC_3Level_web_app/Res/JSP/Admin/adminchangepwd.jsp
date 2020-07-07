<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Change Password Page</title>

<script language="javascript">

	function window_Onload()
 	{
 	     document.changepasswordform.old_password.focus();
 	     document.changepasswordform.old_password.value="";
 	     document.changepasswordform.new_password.value="";
   	     document.changepasswordform.confirm_password.value="";
     
 	}
 	
 	function checkFormValidator()
 	{
 		if(document.changepasswordform.old_password.value=="")
 		{
 			alert("Plese Enter your Old Password");
 			document.changepasswordform.old_password.focus();
 			return false;
 		}
 		
 		else if(document.changepasswordform.new_password.value=="")
 		{
 			alert("Plese Enter your New Password");
 			document.changepasswordform.new_password.focus();
 			return false;
 		}
 		
 		else if(document.changepasswordform.confirm_password.value=="")
 		{
 			alert("Plese Enter Confirm Password");
 			document.changepasswordform.confirm_password.focus();
 			return false;
 		}
 				
 	}

	function checkPassword()
	{
		var newpassword=document.getElementById("new_password").value;
		var confirmpassword=document.getElementById("confirm_password").value;
		
		if(newpassword!=confirmpassword)
		{
			alert("Password Mismatch");
			document.getElementById("new_password").value="";
			document.getElementById("confirm_password").value="";
			document.getElementById("new_password").focus();
			return false;
		}
		
		return true;
	}
</script>

</head>
<% String admin_id=(String) session.getAttribute("admin_id");%>


<body bgcolor="white" onload="window_Onload()">
<form name="changepasswordform" method=post action="<%=request.getContextPath()%>/adminchangepwdaction" onsubmit="return checkFormValidator()">

		<center>
            <div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#0000CD">Change Password</font></b></td>
		</tr>
	  </table>
	</div>
	<br>
    <div align="center">
	  <center>
	  <table border="1" width="40%"> 
		 <tr>
		  <td width="100%"><br>&nbsp;User ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" name="admin_id" value="<%=admin_id%>" readonly size="20"> <br><br>
		
			&nbsp;Old Password  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="password" name="old_password" size="20"> <br><br>
			
			&nbsp;New Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="password" name="new_password" size="20"> <br><br>
		   
            &nbsp;Confirm Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="password" name="confirm_password" size="20">
			<br><br>
		  </td>
		</tr>
	  </table>
  	</div>
  	<br>
<input type="submit" value="Submit" name="B1" onclick="return checkPassword()">
 <input type="reset" value="Reset" name="B2">
 </center>
</form>
<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("Password have Changed Successfully!!");
		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<script type="text/javascript">
		alert("Opps,Something Went Wrong Try Again Latter!!!!!");
		</script>	

				
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>

		<script type="text/javascript">
		alert("Old Password Mismatch!!!");
		</script>	

				
<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
%>

		<script type="text/javascript">
		alert("New Password and Confirm Password is Mismatch!!!");
		</script>	

				
<%
	}
	
%>
</body>
</html>