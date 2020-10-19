<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
   <spring:url var="js" value="/resources/js"></spring:url>
   

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<link rel="stylesheet" type="text/css" href="${css}/UserRegistration.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- JS, Popper.js, and jQuery -->
	<script type="text/javascript" src="${js}/UserRegistration.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js">
	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- meta tag -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> user login</title>
	
</head>
<body>
	<!-- nav bar -->
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
<div class="main container-fluid" id="main">
	<form class="form-group" action="userValidation">
		<!-- heading -->
		<h1 class="heading">Sign In for User</h1>		
			<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<!-- first name -->
						<label for="First name">User Name</label>
						<input type="text" name="uname" id="username1" placeholder="enter first name" class="form-control" required="">
						<i class="fa fa-check-circle" id="userSuccess1"></i>
						<i class="fa fa-exclamation-circle" id="userError1"></i>
						<span id="u1msg" class="errormsg">**invalid user name**</span>
					</div>
				</div>
			</div>

			<div class="control">
				<div class="row">
					<!-- password-->
					<div class="col-lg-12">
						<label for="password1">Password</label>
						<input type="password" name="pwd" id="password1" placeholder="password" class="form-control" required="">
						<i class="fa fa-check-circle" id="passSuccess1"></i>
						<i class="fa fa-exclamation-circle" id="passError1"></i>
						<span id="p1msg" class="errormsg">**invalid password id**</span>
					</div>
					
				</div>
			</div>
		 ${msg}<br>
		 ${rmsg}<br>
			<a href="" class="mt-3">Forget password/UserName</a>
			<br>
			<br>
			<button class="btn btn-success btn-lg" type="submit" onclick="loginValidation();">submit
			</button>
			<p class="text-center create"><a href="UserRegistration.jsp" class="btn btn-info">Create account</a></p>

	</form>
</div>
</body>

</html>