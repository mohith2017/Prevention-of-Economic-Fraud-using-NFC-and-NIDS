
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
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/Admin/acc_type_details.jsp" target="myIframe">
				<h3>Account Type</h3>
				
			</a>
</div>



<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/Admin/account_details.jsp" target="myIframe">
				<h3>Account Details</h3>
				
			</a>
</div>


<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/Admin/branch_details.jsp" target="myIframe">
				<h3>Branch Details</h3>
				
			</a>
</div>

<div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/Res/JSP/Admin/adminchangepwd.jsp" target="myIframe">
				<h3>Change Password</h3>
				
			</a>
</div>



<%-- <div class ="link">      
			<a class="a" href="<%=request.getContextPath()%>/JSP/ChangePassword.jsp" target="myIframe">
				<h3>ChangePassword</h3>
				
			</a>
</div>
 --%>

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
	frameborder="0" scrolling="auto" name="myIframe" height="470px" width="850px"></iframe>
</div>
	
</body>
</html>