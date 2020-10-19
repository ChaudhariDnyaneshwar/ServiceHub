<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
       <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
   
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<!-- CSS only -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js">
	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>




	<!-- meta tag -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	
</head>

<body>

  <div id="carouselExampleInterval" class="carousel slide carousel-fade" data-ride="carousel">
  <div class="carousel-inner division">
    <div class="carousel-item active" data-interval="10000">
      <img src="image/carsoule0.jfif" class="d-block w-100" alt="..." height="400px">
      <div class="carousel-caption mx-auto text-center">
        <h5 class="text-animate mb-3">Service Hub</h5>
      </div>
    </div>
    <div class="carousel-item" data-interval="2000">
      <img src="${image}/carsoule1.jpg" class="d-block w-100" alt="..." height="400px">
    </div>
    <div class="carousel-item">
      <img src="${image}/carsoule2.jpg" class="d-block w-100" alt="..." height="400px">
    </div>
    <div class="carousel-item">
      <img src="${image}/carsoule3.jpg" class="d-block w-100" alt="..." height="400px">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
    <span class="fa fa-chevron-left fa-lg" style="color:red;" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
    <span class="fa fa-chevron-right fa-lg"  style="color:red;"aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<!-- <hr class="line mx-auto"> -->
  <!-- what we do -->
  <div class="division wwd mb-3">
    <h1 class="mx-auto text-center mb-3 wwd-heading"><u>What We Do</u></h1>
    <p class="text-justify wwd-info">We work for establishment of communication between different service provider and user/ client.We bring multiple service provider at one place for user convinience.Find Thousand Services If You are Ready To Get.We have 280,000+ live clients adverts on our site, helping you to find any type of services</p>
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

<script src="http://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/register.js"></script>


</body>
</html>