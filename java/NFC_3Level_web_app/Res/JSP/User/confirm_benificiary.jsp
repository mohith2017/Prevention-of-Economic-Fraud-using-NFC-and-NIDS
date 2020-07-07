<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.sql.ResultSet"%>
<%@page import="com.Database.adduserdao"%>
<%@page import="com.Database.admindao"%>

<%@page import="com.Database.UserDAO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script language="javascript">
 	
 	function checkFormValidator()
 	{
 	
 		if(document.confirm_benificiary.acc_no.value=="0")
 		{
 			alert("Please,Select A Benificiary From The Dropdown.");
 			document.confirm_benificiary.acc_no.focus();
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
	String existenceStatus="",confirmationStatus="",userAccNumber="";
	String add=""; 
	
%>

<%	
	userAccNumber = (String) session.getAttribute("userid");

	String accno = admindao.getAccNo(userAccNumber);
	rs = UserDAO.getPendingBenificiaryDetails(accno);
    
     
	existenceStatus=(String) session.getAttribute("urnExistenceStatus");
	confirmationStatus=(String) session.getAttribute("confirmationStaus");

	
	if(!rs.next())
	{

%>
<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" >Confirm/Reject Benificiary</font></b></td>
		</tr>
	  </table>
	  
	  <hr>
	  
</div>

<%
	}
	else
	{
		rs.previous();//Pointing the Cursor to the previous row.
		
%>

<form name="confirm_benificiary" method="post" action="<%=request.getContextPath()%>/ConfirmOrRejectBenificiary" onsubmit="return checkFormValidator()">

<center>
    <br>
    <br>
	<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" >Confirm/Reject Benificiary</font></b></td>
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
		 				Banificiary Name
		 		</td>
		 		
		 		<td width="50px">
		 				:
		 		</td>
		 		
		 		<td>
		 				<select name="acc_no" required="yes" style="width: 158px;">
		 						<option value="0">--Select Benificiary--</option>
		 						<%
		 							
		 						    while(rs.next())
		 						    {
		 						%>
		 						
		 						<option value="<%=rs.getString(3)%>"><%=rs.getString(4)%></option>
		 						
		 						<%
		 							} 
		 						%>
		 				</select>
		 		</td>
		</tr>
		
		<tr>
		 		<td>
		 				URN Number
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="urn"/>
		 		</td>
		</tr>
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="3">
				        
				        <input type="submit" name="Action" value="Reject"/>
				        
				        <input type="submit" name="Action" value="Confirm" onclick="return checkFormValidator()" />
				</td>
		</tr>
		
	  </table>
	  </center>
	  
<%
	if(existenceStatus == null)
	{
		
	}
	else
	{
%>
<h2><center><font color=red>Opps,This URN Number Does Not Exisists!!!<br></br></font></center></h2>

<%
    session.removeAttribute("urnExistenceStatus");
	}
	if(confirmationStatus == null)
	{
		
	}
	else
	{
%>
<h2><center><font color=red>Opps,Somthing Went Wrong,Try Again...<br></br></font></center></h2>

<%
	session.removeAttribute("confirmationStaus");
	}
%>	  

	  
	</div>
	</center>
   
</form>

<%
}
%>
<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("URN Number Successfully Sent to your Email.  Now You Can Confirm Benificiary by providing the URN Number through Confirn/Reject Link.!!");
		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<script type="text/javascript">
		alert("Opps,Unable to Send URN Number to Email !!!!!!!");
		</script>
		
				
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>

		<script type="text/javascript">
		alert("Benificiary Confirmed Sucessfully.....!!!");
		</script>
		
				
<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
%>

		<script type="text/javascript">
		alert("Opps,Something Went Wrong, Try Again...!!");
		</script>
		
				
<%
	}
	
	
	
	
%>

</body>
</html>