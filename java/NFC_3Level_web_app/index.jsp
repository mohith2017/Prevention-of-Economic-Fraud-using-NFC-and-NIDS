<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.support.*" %>
    <%@ page import="java.util.*" %>
    <%@page import="com.Database.*"%>
 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Day - HTML Bootstrap Template</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link href="css/animate.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet" />
  <!-- =======================================================
    Theme Name: Day
    Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
   <script type="text/javascript">
    
    function checkvariability()
    {
    	document.getElementById("feature").style.display="none";
    	document.getElementById("gallery").style.display="none";
    	
    	
    }
   
   
    </script>
    
    
    
    <script type="text/javascript">
    
    function checkvariabilityy2()
    {
    	document.getElementById("feature").style.display="none";
    	document.getElementById("gallery").style.display="";
    
    	
    	
    	
    }
    
    </script>
    
    <script type="text/javascript">
    
    function checkvariability1()
    {
    	document.getElementById("feature").style.display="";
    	document.getElementById("gallery").style.display="none";
    	
    	
    }
   
    </script>
</head>

<body>
  <header id="header">
    <nav class="navbar navbar-default navbar-static-top" role="banner">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                  
          <div class="navbar-brand" style="position: fixed; top: -15px; left: 290px; ">
            <a href="index.html"><h1><b>NFC Featured 3 Level Authentication Systems for ATM</b></h1></a>
          </div>
        </div>
        </br></br> </br></br>
        <div class="navbar-collapse collapse">
          <div class="menu">
            <ul class="nav nav-tabs" role="tablist">
              <li role="presentation"><a href="#header" onclick="checkvariability();" class="active">Home</a></li>
              <li role="presentation"><a href="#feature" onclick="checkvariability1();" >Admin Login</a></li>
            <!--   <li role="presentation"><a href="about.html">About Us</a></li>
              <li role="presentation"><a href="services.html">Services</a></li>
              <li role="presentation"><a href="gallery.html">Gallery</a></li> -->
              <li role="presentation"><a href="#gallery" onclick="checkvariabilityy2();">UserLogin</a></li>
                           <!--  <li role="presentation"><a href="contact.html">Gallery</a></li>  -->
            </ul>
          </div>
        </div>
      </div>
      <!--/.container-->
    </nav>
    <!--/nav-->
  </header>
  <!--/header-->

  <div class="slider">
    <div id="about-slider">
      <div id="carousel-slider" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators visible-xs">
          <li data-target="#carousel-slider" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-slider" data-slide-to="1"></li>
          <li data-target="#carousel-slider" data-slide-to="2"></li>
        </ol>

        <div class="carousel-inner">
          <div class="item active">
            <img src="img/slide.jpg" class="img-responsive" alt="">
            <div class="carousel-caption">
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.3s">
               <!--  <h2><span>Clean & Modern Design Template</span></h2> -->
              </div>
              <div class="col-md-10 col-md-offset-1">
                <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.6s">
                 <!--  <p>Lorem ipsum dolor sit amet consectetur adipisicing</p> -->
                </div>
              </div>
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.9s">
                <form class="form-inline">
                  <div class="form-group">
                    <!-- <button type="livedemo" name="Live Demo" class="btn btn-primary btn-lg" required="required">Live Demo</button> -->
                  </div>
                  <div class="form-group">
                   <!--  <button type="getnow" name="Get Now" class="btn btn-primary btn-lg" required="required">Get Now</button> -->
                  </div>
                </form>
              </div>
            </div>
          </div>

          <div class="item">
            <img src="img/slide1.jpg" class="img-responsive" alt="">
            <div class="carousel-caption">
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="1.0s">
              <!--   <h2>Fully Responsive</h2> -->
              </div>
              <div class="col-md-10 col-md-offset-1">
                <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.6s">
                  <!-- <p>Lorem ipsum dolor sit amet consectetur adipisicing</p> -->
                </div>
              </div>
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="1.6s">
                <form class="form-inline">
                  <div class="form-group">
                  <!--   <button type="livedemo" name="purchase" class="btn btn-primary btn-lg" required="required">Live Demo</button> -->
                  </div>
                  <div class="form-group">
                    <!-- <button type="getnow" name="subscribe" class="btn btn-primary btn-lg" required="required">Get Now</button> -->
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="item">
            <img src="img/slide2.jpg" class="img-responsive" alt="">
            <div class="carousel-caption">
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.3s">
               <!--  <h2>Modern Design</h2> -->
              </div>
              <div class="col-md-10 col-md-offset-1">
                <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.6s">
                <!--   <p>Lorem ipsum dolor sit amet consectetur adipisicing</p> -->
                </div>
              </div>
              <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.9s">
                <form class="form-inline">
                  <div class="form-group">
                   <!--  <button type="livedemo" name="purchase" class="btn btn-primary btn-lg" required="required">Live Demo</button> -->
                  </div>
                  <div class="form-group">
                  <!--   <button type="getnow" name="subscribe" class="btn btn-primary btn-lg" required="required">Get Now</button> -->
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <a class="left carousel-control hidden-xs" href="#carousel-slider" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				</a>

        <a class=" right carousel-control hidden-xs" href="#carousel-slider" data-slide="next">
					<i class="fa fa-angle-right"></i>
				</a>
      </div>
      <!--/#carousel-slider-->
    </div>
    <!--/#about-slider-->
  </div>
  <!--/#slider-->

  <footer>
    <div class="container">
    
    <div id="feature" name="feature">
		<div class="container">
			<div class="row">
				<div class="text-center">
					<h2><font color="#FF0099"size="5">Admin Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></h2>
					
					<form name="loginform" action="AdminLogin" method="post">
<center>
<b>
  USER ID&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  :&nbsp<input type="text" name="adminid"></br></br>
<b>
 PASSWORD&nbsp&nbsp :  <input type="password" name="pwd"><br><br></br></b>


<input style="background-color: #33CCFF;" type="submit" value="LOGIN" onclick="return checkformvalidater()">
</center>
</form>
					
			</div>
		</div>
	</div> 
	
	</div>
<%String data=DAO.getusername(); %>	
	<div id="gallery" name="gallery">
		<div class="container">
			<div class="row">
				<div class="text-center">
					<h2><font color="#FF0099"size="5">Welcome <%=data %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></h2>
					
				<form name="loginform1" action="<%=request.getContextPath()%>/Login" method="post">
<center>
<input type="hidden" name="uid" value=" <%=data %>"><br><br>
 <b>Pattern Pin : &nbsp;&nbsp;<input type="password" name="pwd"></b><br><br>
 
<input style="background-color: #33CCFF;" type="submit" value="LOGIN" onclick="return checkformvalidater()">
</center>
</form>
	</div>
		</div>
	</div> 
	</div>
	
     
    </div>
  </footer>

  <div class="sub-footer">
    <div class="container">
      <div class="social-icon">
        <div class="col-md-4">
          <ul class="social-network">
           <!--  <li><a href="#" class="fb tool-tip" title="Facebook"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#" class="twitter tool-tip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
            <li><a href="#" class="gplus tool-tip" title="Google Plus"><i class="fa fa-google-plus"></i></a></li>
            <li><a href="#" class="linkedin tool-tip" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
            <li><a href="#" class="ytube tool-tip" title="You Tube"><i class="fa fa-youtube-play"></i></a></li> -->
          </ul>
        </div>
      </div>

      <div class="col-md-4 col-md-offset-4">
        <div class="copyright">
          <span><b>Email id: </b>info@dhsinformatics.com</span></br>
                 <span><b>Contact No: </b>8769878987</span>
          <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Day
            -->
            <!-- <a href="https://bootstrapmade.com/">Free Bootstrap Themes</a> by <a href="https://bootstrapmade.com/">BootstrapMade</a> -->
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="js/jquery.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
  <script src="js/wow.min.js"></script>
  <script>
    wow = new WOW({}).init();
  </script>
</body>
 <%
 
	if(Utility.parse(request.getParameter("no"))==1)
	{
	%>
	
	<script type="text/javascript">
	alert("Your Dash MAtrix Password is wrong");
</script>
	
<% 	
	}

%>


 <%
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		<script type="text/javascript">
    		
    		alert('Enter Userid or Password is wrong');
    		
    		</script>		
<%
	}
%>
</html>
