<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
      <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

	<!-- CSS only -->
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<%@include file="Header.jsp" %>
		<title>About Us</title>
</head>

<body>
	<div class= "about">

		<div class="row division about-body">
			<div class="col-lg-6">
				<img src="${image}/about.jpg" class="img-fluid about-img">
			</div>
			<div class="col-lg-6 column">
				<h4>Explore New Life</h4>
				<h1 class="heading1 about-animate">We Are A Team Of Experts <br>In This Field...</h1>
				<p  class="about-info">We work for establishment of communication between different service provider and user/ client.We bring multiple service provider at one place for user convinience.</p>
				
			</div>
		</div>

		<!-- Section: Team v.2 -->
<div class="team-member division">
	<section class="team-section text-center my-5">

  <!-- Section heading -->
  <h2 class="h1-responsive font-weight-bold my-5">Our Amazing Team</h2>

  <!-- Grid row -->
  <div class="row text-center">

    <!-- Grid column -->
    <div class="col-md-3 ">
      <div class="mx-auto">
        <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20(10).jpg" class="rounded z-depth-1-half">
      </div>
      <h4 class="font-weight-bold dark-grey-text my-4">Maria Kate</h4>
      <h6 class="text-uppercase grey-text mb-3"><strong>Photographer</strong></h6>
      <!-- Facebook-->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-fb">
        <i class="fa fa-facebook-f"></i>
      </a>
      <!--Dribbble -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-dribbble">
        <i class="fa fa-dribbble"></i>
      </a>
      <!-- Twitter -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-tw">
        <i class="fa fa-twitter"></i>
      </a>
    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-md-3">
      <div class="avatar mx-auto">
        <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20(10).jpg" class="rounded z-depth-1-half">
      </div>
      <h4 class="font-weight-bold dark-grey-text my-4">Sarah Melyah</h4>
      <h6 class="text-uppercase grey-text mb-3"><strong>Web Developer</strong></h6>
      <!--Linkedin -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-li">
        <i class="fa fa-linkedin"></i>
      </a>
      <!-- Twitter -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-tw">
        <i class="fa fa-twitter "></i>
      </a>
      <!--Pinterest -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-pin">
        <i class="fa fa-pinterest "></i>
      </a>
    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-md-3">
      <div class="mx-auto">
        <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20(10).jpg"  class="rounded z-depth-1-half">
      </div>
      <h4 class="font-weight-bold dark-grey-text my-4">Sarah Melyah</h4>
      <h6 class="text-uppercase grey-text mb-3"><strong>Web Developer</strong></h6>
      <!--Linkedin -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-li">
        <i class="fa fa-linkedin"></i>
      </a>
      <!-- Twitter -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-tw">
        <i class="fa fa-twitter "></i>
      </a>
      <!--Pinterest -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-pin">
        <i class="fa fa-pinterest "></i>
      </a>
    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-md-3">
      <div class="avatar mx-auto">
        <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20(10).jpg" class="rounded z-depth-1-half" alt="Sample avatar">
      </div>
      <h4 class="font-weight-bold dark-grey-text my-4">Sarah Melyah</h4>
      <h6 class="text-uppercase grey-text mb-3"><strong>Web Developer</strong></h6>
      <!--Linkedin -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-li">
        <i class="fa fa-linkedin"></i>
      </a>
      <!-- Twitter -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-tw">
        <i class="fa fa-twitter "></i>
      </a>
      <!--Pinterest -->
      <a type="button" class="btn-floating btn-sm mx-1 mb-0 btn-pin">
        <i class="fa fa-pinterest "></i>
      </a>
    </div>
    <!-- Grid column -->


  </div>
  <!-- Grid row -->

</section>
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
          <i class="fab fa-google-plus-g" > </i>
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
	
</div>
</div>

</body>
</html>