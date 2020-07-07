<%@ page language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.support.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="com.Database.*"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Type Details</title>
</head>
<body bgcolor="white">

<%
	String branchName="";
	String add="",update="",delete="";
	int branchId = 0;
	
	DAO serverconnector=new DAO();
	Connection con=serverconnector.connector();
	Statement st=(Statement) con.createStatement();
	
	String query="select * from m_branch";
	ResultSet rs=st.executeQuery(query);
	
	add=(String) session.getAttribute("add");

	if(add==null)
	{
		
	}
	else if(add=="success")
	{
%>
		<h2><center><font color=blue><b>Branch Details Added Successfully !!!<br>	
<%
		session.removeAttribute("add");
	}
	
	update=(String) session.getAttribute("update");

	if(update==null)
	{
		
	}
	else if(update=="success")
	{
%>
		<h2><center><font color=blue><b>Branch Details Updated Successfully !!!<br>
<%
	}
	
	else if(update=="failed")
	{
%>
		<h2><center><font color=blue><b>Opps,Updation Process Failed Try Again..<br>
<%
		session.removeAttribute("update");
	}
	
	delete=(String) session.getAttribute("delete");

	if(delete==null)
	{
		
	}
	else if(delete=="success")
	{
%>
		<h2><center><font color=blue><b>Branch Details Deleted Successfully !!!<br>
		
<%
		session.removeAttribute("delete");

	}
	
	else if(delete=="failed")
	{
%>
		<h2><center><font color=red><b>Branch Details Deletion Failed!!!<br>
		
<%
		session.removeAttribute("delete");

	}
%>


<form name="acc_type_form" action="<%=request.getContextPath()%>/Res/JSP/Admin/add_branch.jsp" method="post">
    <center>
<div align="left">
	  <table border="0" width="100%">
		<tr>
		  <td width="100%">
			<p align="center"><b><font size="5" color="#0000CD">Bank Branch Details</font></b></td>
		</tr>
	  </table>
	</div>
	<br>
<table align="center" border="2" width="80%">
  <tr>
    <th>
      <p align="center">BranchID</b></font></p>
    </th>
    <th>
      <p align="center">Branch Name</b></font></p>
    </th>
    <th>
      <p align="center">Edit</font></b></p>
    </th>
   <th>
      <p align="center">Delete</b></font></p>
    </th>
    
   </tr>
 <%
	while(rs.next())
	{
		branchId=rs.getInt(1);
		branchName=rs.getString(2);

%>

  <tr>
    <td width="10%" align="center"><%=branchId %></td>
    <td width="40%" align="center"><%=branchName%></td>
    
    <td width="15%" align="center">
      <p align="center"><a href="<%=request.getContextPath()%>/Res/JSP/Admin/edit_branch.jsp?branch_id=<%=branchId%>">Edit</a></p>
    </td>
    <td width="15%" align="center">
      <p align="center"><a href="<%=request.getContextPath()%>/DeleteBranchDetails?branch_id=<%=branchId%>" onclick="return confirm('Do you want to delete <%=branchId%>?')">Delete</a></p>
    </td>
    
  </tr>


<%
	}
%>

</table>

<br><br>

	<center>
		<input type="submit" value="Add Branch">
	</center>

</form>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
		alert("Branch have added Successfully!!");
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
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>

		<script type="text/javascript">
		alert("Branch Details Deleted Successfully!!!");
		</script>	

				
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>

		<script type="text/javascript">
		alert("Branch Details Updated Successfully!!!");
		</script>	

				
<%
	}
	
	
%>
</body>
</html>
