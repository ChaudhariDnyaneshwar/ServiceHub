<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<%@ include file="Header.jsp" %>
	<title>shared contact</title>
</head>

<body>
   
   <div class="division contact" id="contact">
	<div class="row">
		<div class="col-lg-6">
			<div class="map-responsive">
				<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15132.295426137158!2d73.8464113!3d18.5255643!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x3f92335c2e5c8400!2sP.E.S.%20Modern%20College%20of%20Engineering!5e0!3m2!1sen!2sin!4v1602144155328!5m2!1sen!2sin" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>">
				
			</div>
		</div>
		<div class="col-sm-6">
			<form class="text-center">
				<h1 class="heading1"><u>Get In Touch</u></h1>
				<input type="text" name="name" class="form-control mb-3" placeholder="user name/Company name">
				<select class="form-control mb-3">
					<option>User</option>
					<option>Service Provider</option>
				</select>
				<textarea class="form-control mb-3" placeholder="Enter Your Message" cols="10" rows="10"></textarea>
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