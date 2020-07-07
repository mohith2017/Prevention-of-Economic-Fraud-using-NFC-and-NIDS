<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script language="javascript">
 	
 	function checkFormValidator()
 	{
 	
 		if(document.branch_form.branch_name.value=="")
 		{
 			alert("Plese Enter The Branch Name.");
 			document.branch_form.branch_name.focus();
 			return false;
 		}
 		
 		
        else if(document.branch_form.branch_remarks.value=="")
 		{
 			alert("Plese Enter The Branch Description.");
 			document.branch_form.branch_remarks.focus();
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
 
<%
	String existenceStatus="";
	String add=""; 
	
%>

<%	
	existenceStatus=(String) session.getAttribute("existenceStatus");

	if(existenceStatus==null)
	{
		
	}
	else if(existenceStatus=="yes")
	{
%>
		<h2><center><font color=red><b>Sorry,This Branch Name Already Exists!</b></font></center></h2>
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

<form name="branch_form" method="post" action="<%=request.getContextPath()%>/AddBranchDetails" onsubmit="return checkFormValidator()">

<center>
    <br>
    <br>
	<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#0000CD">Add Branch Details</font></b></td>
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
		 				Branch Name 
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="branch_name"/>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				Remarks 
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="branch_remarks"/>
		 		</td>
		</tr>
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="3">
				        
				        <input type="reset" value="Reset" />
				        
				        <input type="submit" value="Add Branch" onclick="return checkFormValidator()" />
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
		alert("Branch Already Exist Please Try Again!!");
		</script>			
<%
	}
	
%>

</body>
</html>