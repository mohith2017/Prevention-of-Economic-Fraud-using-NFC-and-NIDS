
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="<%=request.getContextPath()%>/css/menu.css" rel="stylesheet" type="text/css" />
<%String uname=request.getParameter("name");
System.out.println("=============home========"+uname);

%>

<style type="text/css">

    body 
    {
      background-image:url('bg.jpg');
    
        background-repeat: no-repeat;
    }

</style>

</head>


<body >

<IMG SRC="<%=request.getContextPath()%>/img/header.png" >

<div class="container">
<nav class="menu animated flipInX">

		<ul class="ul">
      
 
  
<%--  <div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/Admin/home.jsp" target="myIframe">
				<h3>Home</h3>
				
			</a>
</div>
 --%>

<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/userprofile.jsp" target="myIframe">
				<h3>User Profile</h3>
		
			</a>
</div>



<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/balance_enquiry.jsp" target="myIframe">
				<h3>Balance Enquiry</h3>
				
			</a>
</div>


<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/mini_statement.jsp" target="myIframe">
			<!-- <a href="#" ><span>Fund Transfer</span></a> -->
				<h3>Mini Statement</h3>
				
				
			</a>
</div>
<!-- <div class ="link">   
<h3><b>Fund Transfer</b></h3>  
</div> -->
 
<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/register_benificiary.jsp" target="myIframe">
				<h3>Register Benificiary</h3>
				
			</a>
</div>


 <div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/confirm_benificiary.jsp" target="myIframe">
				<h3>Confirm/Reject Benificiary</h3>
				
			</a>
</div>

 <div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/make_payment.jsp" target="myIframe">
				<h3>Make Payment</h3>
				
			</a>
</div>


<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/User/transaction.jsp" target="myIframe">
				<h3>Transactions</h3>
				
			</a>
</div>

<div class ="link">      
			<a class ="a" href="<%=request.getContextPath()%>/index.jsp">
				<h3>Logout</h3>
				
			</a>
</div>
      
		</ul>
	</nav>
</div>



<div style="position:absolute;top:150px;left:300px;">
	<iframe align="middle"  style="margin-left: 60px;" 
	frameborder="0" scrolling="auto" name="myIframe" height="610px" width="850px"></iframe>
</div>
	
</body>
</html>