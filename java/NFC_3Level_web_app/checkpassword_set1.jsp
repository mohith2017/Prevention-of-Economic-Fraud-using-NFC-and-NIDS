<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@ page import="java.util.*" %>
    <%@page import="com.Database.*"%>
    <%@page import="com.support.*"%>
      <%@page import="com.support.Utility"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GPCheck</title>
<script type="text/javascript" src="jquery-1.8.0.min.js">
    </script>
    
<link rel="stylesheet" media="screen" href="css1/superfish.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css1/nivo-slider.css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css1/tweet.css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css1/style1.css">
<link rel="stylesheet" media="all" href="<%=request.getContextPath()%>/css1/lessframework.css" />

<script src="<%=request.getContextPath()%>/js/modernizr-2.5.3.min.js"></script>
	
<style type="text/css">

div.background {
position:relative;
    width: 150px;
    height: 150px;
    background: url(Test.jpg) repeat;
    border: 0px solid black;
    left: 200px;
    top: 200px;
}

}
</style>
 <%

String num = request.getParameter("no");
//String userid = request.getParameter("user");

String userid=(String)session.getAttribute("userid");
System.out.println("userid>>>>>>>>>>>>>>>>>>>> :"+userid);
System.out.println("num>>>>>>>>>>>>>>>>>>>> :"+num);

String data=DAO.retrieveImageone(userid.trim());

System.out.println("data is>>>>>>>>>>>>>>>>>>>> :"+data);

String dd[]=data.split(",");

System.out.println("<<<<<<<<<<<<<<<<<image"+dd[0]);

%>

</head>

<body>


<div role="main" id="main" class="cf"><!-- headline -->
<div class="headline"><h1><b>NFC Featured 3 Level Authentication Systems for ATM</b></h1></div>
<!-- ENDS headline --></div>

<form action="<%=request.getContextPath()%>/PasswordSetUser1" method="get">

<div class="background" id="pointer_1" style="position:relative;top: 100px;left:400px;width: 150px;height: 150px; ">

<img alt="" id="img1" src="<%=request.getContextPath()%>/Res/SourceImage/<%=dd[0]%>" onclick="test('1','<%=userid%>')" >

<br></br>

					Description
					<input type="text" name="desc" placeholder="Please Enter Description" >
					<input type="hidden" name="userid"   value="<%=userid%>">
					<input type="hidden" name="imgnme" value="<%=dd[0]%>">
	
						<input type="submit" value="ok" style="position: relative;top: 10px;" >
							
				
</div>

</form>	


<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if offline -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.7.1.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via build script -->
<script src="js/custom.js"></script>

<!-- superfish -->
<script src="js/superfish-1.4.8/js/hoverIntent.js"></script>
<script src="js/superfish-1.4.8/js/superfish.js"></script>
<script src="js/superfish-1.4.8/js/supersubs.js"></script>
<!-- ENDS superfish -->

<script src="js/tweet/jquery.tweet.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.nivo.slider.js"></script>
<script src="js/css3-mediaqueries.js"></script>
<script src="js/tabs.js"></script>
<script src="js/poshytip-1.1/src/jquery.poshytip.min.js"></script>
<!-- end scripts -->

<%
int no=Utility.parse(request.getParameter("no"));

	if(no==1)
	{
	%>
	
	<script type="text/javascript">
	alert("Your Captcha Image Description is Wrong");
</script>
	
<% 	
	}

%>
</body>
</html>