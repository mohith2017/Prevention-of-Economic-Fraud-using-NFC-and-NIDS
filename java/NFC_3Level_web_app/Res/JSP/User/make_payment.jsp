<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.sql.ResultSet"%>
<%@page import="com.Database.UserDAO"%>
<%@page import="com.Database.admindao"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Branch</title>
<script language="javascript">
 	
 	function checkFormValidator()
 	{
 	
 		if(document.make_payment.acc_no.value=="0")
 		{
 			alert("Please,Select A Benificiary From The Dropdown.");
 			document.make_payment.acc_no.focus();
 			return false;
 		}

       
 		
 		if(document.make_payment.amt_toPaid.value=="")
 		{
 			alert("Please,Enter The Transfer Amount To Pay.");
 			document.make_payment.amt_toPaid.focus();
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
	String validationMsg="",confirmationStatus="",userAccNumber="",transLimit="",error="";
	String add=""; 
	
%>

<%	
userAccNumber = (String) session.getAttribute("userid");


String accno = admindao.getAccNo(userAccNumber);
	rs = UserDAO.getConfirmedBenificiaryDetails(accno);
    
     
    validationMsg=(String) session.getAttribute("validationMsg");
    transLimit=(String) session.getAttribute("transLimit");
    error=(String) session.getAttribute("error");

	
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
<h2><center><font color=red><b>Opps,There is no benificiary to make Payment.</b><br>
                               Register Benificiary First,Then Try to make Payment.
</font></center></h2>

<%
	}
	else
	{
		rs.previous();//Pointing the Cursor to the previous row.
		
%>

<form name="make_payment" method="post" action="<%=request.getContextPath()%>/MakePaymentToBenificiary" onsubmit="return checkFormValidator()">

<center>
    <br>
    <br>
	<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" >Make Payment</font></b></td>
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
		 				Amount To Pay
		 		</td>
		 		
		 		<td>
		 				:
		 		</td>
		 		
		 		<td>
		 				<input type="text" name="amt_toPaid"/>
		 		</td>
		</tr>
		
		<tr height="20px"></tr>
		
		<tr>
				<td align="center" colspan="3">
				        
				        <input type="submit" name="Action" value="Pay Amount" onclick="return checkFormValidator()" />
				</td>
		</tr>
		
	  </table>
	  </center>
	  </div>
	</center>
</form>

<div style="margin-left: 400px;top: 205px;position: absolute;left: 100">
<form action="MakePaymentToBenificiary" method="post">
	<input type="submit" name="Action" value="Cancel"/>
</form>
</div>
	  
<%
	if(validationMsg == null )
	{
		
	}
	else if(validationMsg.equals("outOfLimit"))
	{
%>
<h2><center><font color=red>Opps,Amount to pay is Out of Transaction Limit.<br></font></center></h2>

<%
    session.removeAttribute("validationMsg");
	}
	if(transLimit == null )
	{
		
	}
	else 
	{
	%>
<h2><center><font color=green>Your Transaction Limit = Rs. <%=transLimit%> </h2>

	<%
	session.removeAttribute("transLimit");
	}
	if(error == null )
	{
		
	}
	else if(error.equals("Yes"))
	{
%>
<h2><center><font color=red>Opps,Something Went Wrong Try It Again...<br></font></center></h2>

<%
    session.removeAttribute("error");
	}
%>	  

	  
	


<%
}
%>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("Opps,Something Went Wrong, Try Again...!!!!");
		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<script type="text/javascript">
		alert("Amount Tranfered Successfully!!!!!!!");
		</script>
		
				
<%
	}
	
	%>

</body>
</html>