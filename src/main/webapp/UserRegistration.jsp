

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
    <spring:url var="js" value="/resources/js"></spring:url>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/UserRegistration.css">
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
	<script src="${js}/UserRegistration.js"></script>
   <%@include file="Header.jsp" %>
	<title>create account</title>
</head>
<body>
	<!-- navbar -->
	
 	<nav class="navbar navbar-expand-lg sticky-top">
  <a class="navbar-brand" href="#">
    <img src="${image}/logo.png" class="logo">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fa fa-bars nav-icon" aria-hidden="true"></i>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="About.jsp">About Us</a>
      </li>
     
      <li class="nav-item">
        <a class="nav-link" href="Contact.jsp">contact</a>
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
		<form class="form-group" action="userRegistration">
		<!-- heading -->
		<h1 class="heading">Create Acoount</h1>
		<!-- close button -->
		<div class="close"> 
     		 <span onclick="document.getElementById('main').style.display='none'"
       			 title="Close Modal">&times;</span>
    	</div>
		
			<div class="control">
				<div class="row">
					<div class="col-lg-6">
						<!-- first name -->
						<label for="First name">First Name</label>
						<input type="text" name="firstName" id="firstname" placeholder="enter first name" class="form-control" required="">
						<i class="fa fa-check-circle" id="fnameSuccess"></i>
						<i class="fa fa-exclamation-circle" id="fnameError"></i>
						<span id="fmsg" class="errormsg">**invalid first name**</span>
					</div>
					<div class="col-lg-6">
						<!-- lastname -->
						<label for="lastName">Last Name</label>
						<input type="text" name="lastName" id="lastname" placeholder="enter last name" class="form-control" required="">
						<i class="fa fa-check-circle" id="lnameSuccess"></i>
						<i class="fa fa-exclamation-circle"  id="lnameError"></i>
						<span id="lmsg" class="errormsg">**invalid last name**</span>
					</div>
				</div>
			</div>

			<div class="control">
				<div class="row">
					<!-- emailid -->
					<div class="col-lg-6">
						<label for="email">Email Id</label>
						<input type="email" name="emailId" id="emailId" placeholder="enter email Id" class="form-control" required="">
						<i class="fa fa-check-circle" id="emailSuccess"></i>
						<i class="fa fa-exclamation-circle" id="emailError"></i>
						<span id="emsg" class="errormsg">**invalid email id**</span>
					</div>
					<!-- mobile no -->
					<div class="col-lg-6">
						<label for="mobileNo">Mobile No</label>
						<input type="tel" name="mobileNo" id="mobileNo" placeholder="enter mobileNo" class="form-control" required="">
						<i class="fa fa-check-circle" id="noSuccess"></i>
						<i class="fa fa-exclamation-circle"  id="noError"></i>
						<span id="mmsg" class="errormsg">**invalid mobile no**</span>
					</div>
				</div>
				
			</div>
			<br>
			<!-- gender -->
			<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<label for="gender">Gender:</label>
        				<input type="radio" id="gender" name="gender" value="Male" required="">
       					 <label for="male">Male</label>
       					 <input type="radio" id="gender" name="gender" value="Female" required="">
        				<label for="female">Female</label>
        				<input type="radio" id="gender" name="gender" value="Other" required="">
        				<label for="other">Other</label>
					</div>
					
				</div>
			</div>
			<!-- address -->
			<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<label for="adrress">Address:</label>
						<textarea cols="80" rows="4" id="adrress" name="adrress" placeholder="enter your adrress" class="form-control" required=""></textarea>
					</div>
					
				</div>
			</div>

			<div class="control">
				<div class="row">
					<div class="col-lg-6">
						<!-- city-->
						<label for="city">City</label>
						<input type="text" name="city" id="city" placeholder="enter your city" class="form-control" required="">
						<i class="fa fa-check-circle" id="citySuccess"></i>
						<i class="fa fa-exclamation-circle" id="cityError"></i>
						<span id="cmsg" class="errormsg">**invalid city name**</span>
					</div>
					<div class="col-lg-6">
						<!-- taluka -->
						<label for="taluka">Tahshil</label>
						<input type="text" name="taluka" id="taluka" placeholder="enter your taluka" class="form-control" required="">
						<i class="fa fa-check-circle" id="talukaSuccess"></i>
						<i class="fa fa-exclamation-circle"  id="talukaError"></i>
						<span id="tmsg" class="errormsg">**invalid Tahshil name**</span>
					</div>
				</div>
			</div>
			<br>
			<div class="control">
				<div class="row">
					<div class="col-lg-6">
						<!-- district-->
						<label for="district">District</label>
						<input type="text" name="district" id="district" placeholder="enter your district" class="form-control" required="">
						<i class="fa fa-check-circle" id="distSuccess"></i>
						<i class="fa fa-exclamation-circle" id="distError"></i>
						<span id="dmsg" class="errormsg">**invalid district name**</span>
						
					</div>
					<div class="col-lg-6">
						<!-- state -->
						<label for="state">State</label>
						<select id="state" name="state" required="" class="form-control">
							<option value="selectState" >Select state</option>
  							<option value="Maharashtra">Maharashtrah</option>
  							<option value="Haryana">Haryana</option>
  							<option value="Utterpardesh">Utterpardesh</option>
  							<option value="Punjab">Punjab </option>
						</select>
						<i class="fa fa-check-circle" id="stateSuccess"></i>
						<i class="fa fa-exclamation-circle" id="stateError"></i>
						<span id="smsg" class="errormsg">**invalid **</span>
					</div>
				</div>
			</div>
			<!-- dob -->
			<div class="control">
				<div class="row">
					<div class="col-lg-6">
						<label for="dob">Date of Birth:</label>
						<input type="Date" name="dob" required="" class="form-control" id="dob">
						<i class="fa fa-check-circle" id="dobSuccess"></i>
						<i class="fa fa-exclamation-circle" id="dobError"></i>
						<span id="dobmsg" class="errormsg">**select your date-of-birth**</span>
					</div>
					<div class="col-lg-6">
						<!-- username-->
						<label for="username">User Name:</label>
						<input type="text" name="username" id="username" placeholder="enter your username" class="form-control" required="">
						<i class="fa fa-check-circle" id="userSuccess"></i>
						<i class="fa fa-exclamation-circle" id="userError"></i>
						<span id="umsg" class="errormsg">**invalid user name**</span>
					</div>
					
				</div>
			</div>

			<div class="control">
				<div class="row">
					
					<div class="col-lg-6">
						<!-- pass-->
						<label for="password">Password:</label>
						<input type="password" name="password" id="password" placeholder="enter your password" class="form-control" required="">
						<i class="fa fa-check-circle" id="passSuccess"></i>
						<i class="fa fa-exclamation-circle" id="passError"></i>
						<span id="pmsg" class="errormsg">**invalid password**</span>
						
					</div>
					<div class="col-lg-6">
						<!-- pass-->
						<label for="conpassword">confirm Password:</label>
						<input type="password" name="password" id="confirm" placeholder="confirm password" class="form-control" required="">
						<i class="fa fa-check-circle" id="conSuccess"></i>
						<i class="fa fa-exclamation-circle" id="conError"></i>
						<span id="conmsg" class="errormsg">**invalid password**</span>
						
					</div>
				</div>
			</div>

			<br>
			<button class="btn btn-success" type="submit" onclick="validate();">submit
			</button>

		</form>
	</div>

</body>
</html>