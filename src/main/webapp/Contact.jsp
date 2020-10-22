<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
   

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<%@ include file="Header.jsp" %>
		<title>Contact</title>
</head>


<body>
	<!---------------------------------------------------------------------navbar----------------------------------------->
 <!-- nav-bar -->
	<nav class="navbar navbar-expand-lg sticky-top">
  <a class="navbar-brand" href="#">
    <img src="${image}/logo.png" class="logo">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fa fa-bars nav-icon" aria-hidden="true"></i>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav justify-content-ends">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="About.jsp">About Us</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="Contact.jsp">Contact</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">login/Register
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="AdminLogin.jsp">Admin</a>
          <a class="dropdown-item" href="UserLogin.jsp">User</a>
          <a class="dropdown-item" href="SeviceProviderLogin.jsp">Service Provider</a>
        </div>
      </li>
       
      
    </ul>
  </div>
  </nav> 
  
<div class="division contact" id="contact">
	<div class="row">
		<div class="col-lg-6">
			<div class="map-responsive">
				<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15132.295426137158!2d73.8464113!3d18.5255643!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x3f92335c2e5c8400!2sP.E.S.%20Modern%20College%20of%20Engineering!5e0!3m2!1sen!2sin!4v1602144155328!5m2!1sen!2sin" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>">
				
			</div>
		</div>
		<div class="col-sm-6">
			<form class="text-center" action="insertFeedback">
				<h1 class="heading1"><u>Get In Touch</u></h1>
				<input type="text" name="name" class="form-control mb-3" placeholder="user name/Company name">
				<select class="form-control mb-3" name="position">
					<option value="user" >User</option>
					<option value="service provider">Service Provider</option>
				</select>
				<textarea class="form-control mb-3"  placeholder="Enter Your Message" cols="10" rows="10" name="feedback"></textarea>
				<button class="btn btn-success btn-lg btn-floating btn-block">Submit</button>
			</form>

		</div>
	
	</div>
	<div class="row text-center">
		<div class="col-md-4 mb-5">
			<i class="fa fa-home"></i>
			<h1 class="heading1">Address</h1>
			<p> 1186/A, Off J.M. Road, Shivajinagar,<br> Pune, Maharashtra 411005</p>
		</div>
		<div class="col-md-4 mb-5">
			<i class="fa fa-envelope"></i>
			<h1 class="heading1">Email Id</h1>
			<p><a href="mailto:servicehub@gmail.com">servicehubs@gmail.com</a></p>
		</div>
		<div class="col-md-4 mb-5">
			<i class="fa fa-phone"></i>
			<h1 class="heading1">Phone No</h1>
			<p>020 25533638</p>
		</div>
		
	</div>
	
</div>
<!-- footer -->
<div class="footer bg-dark text-light">
	<!-- Footer -->
<footer class="page-footer">

  <!-- Footer Elements -->
  <div class="container">

    <!-- Social buttons -->
    <ul class="list-unstyled list-inline text-center">
      <li class="list-inline-item">
        <a class="btn-floating btn-fb mx-1" href="https://www.facebook.com/pesmoderncoepune">
          <i class="fab fa-facebook-f"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-tw mx-1" href="https://twitter.com/PESMCOE1">
          <i class="fab fa-twitter"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-gplus mx-1" href="mailto:servicehub@gmail.com">
          <i class="fab fa-google-plus-g"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-li mx-1">
          <i class="fab fa-linkedin-in"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-dribbble mx-1" href="https://www.instagram.com/pesmoderncoe_pune/">
          <i class="fab fa-instagram"> </i>
        </a>
      </li>
    </ul>
    <!-- Social buttons -->

  </div>
  <!-- Footer Elements -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright :Service Hub
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>