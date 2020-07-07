<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script language="javascript">
 	
 	function checkFormValidator()
 	{
 	
 		if(document.reg_benificiary.acc_no.value=="")
 		{
 			alert("Plese Enter The Account Number.");
 			document.reg_benificiary.acc_no.focus();
 			return false;
 		}
 	
	}

</script>
</head>
<body bgcolor="white">

<%
	String existenceStatus="",getAccInfo="";
	String add=""; 
	
%>

<%	
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

<form name="reg_benificiary" method="post" action="<%=request.getContextPath()%>/RegisterBenificiary" onsubmit="return checkFormValidator()">

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
	  
		<tr>
		 		<td>
		 				Account Number
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_no"/>
		 		</td>
		</tr>
	<!-- 	<tr>
		 		<td>
		 				EmailId
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="acc_no"/>
		 		</td>
		</tr> -->
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="3">
				        
				        <input type="reset" value="Reset" />
				        
				        <input type="submit" value="Register" onclick="return checkFormValidator()" />
				</td>
		</tr>
		
		
	  </table>
	  </center>
	</div>
	</center>
   
</form>


</body>
</html>