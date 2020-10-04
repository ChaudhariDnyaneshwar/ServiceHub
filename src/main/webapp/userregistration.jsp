<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 
 <!-- decalaring spring variable for static resources -->
 
 <spring:url var="css" value="/resources/css"></spring:url>
 <spring:url var="image" value="/resources/image"></spring:url>
 <spring:url var="js" value="/resources/js"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" type="text/css" href="${css}/newstart.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- JS, Popper.js, and jQuery -->
	
	<script type="text/javascript" src="${js}/newStart.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
	
	<!-- meta tag -->
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>user login</title>
</head>
<body>

<div class="row">
  
  <div class="col-lg-3"></div>
   <div class="col-lg-6">
   

	<div class="main container-fluid" id="main">
		<form class="form-group" action="userRegistration">
		<!-- heading -->
		<h1 class="heading">Create Account</h1>
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
        				<input type="radio" id="gender" name="gender" value="Male" >
       					 <label for="male">Male</label>
       					 <input type="radio" id="gender" name="gender" value="Female" >
        				<label for="female">Female</label>
        				<input type="radio" id="gender" name="gender" value="Other" >
        				<label for="other">Other</label>
					</div>
					
				</div>
			</div>
			<!-- address -->
			<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<label for="adrress">Address:</label>
						<textarea cols="80" rows="5" id="adrress" name="address" placeholder="enter your adrress" class="form-control" required=""></textarea>
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
						<span id="cmsg" class="errormsg">**Enter city name**</span>
					</div>
					<div class="col-lg-6">
						<!-- taluka -->
						<label for="taluka">Tahsil</label>
						<input type="text" name="taluka" id="taluka" placeholder="enter your taluka" class="form-control" required="">
						<i class="fa fa-check-circle" id="talukaSuccess"></i>
						<i class="fa fa-exclamation-circle"  id="talukaError"></i>
						<span id="tmsg" class="errormsg">**Enter tahasil  name**</span>
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
						<span id="dmsg" class="errormsg">**Envalid district name**</span>
						
					</div>
					<div class="col-lg-6">
						<!-- state -->
						<label for="state">State</label>
						<select id="state" name="state" required="" class="form-control">
  							<option value="mah">Maharashtrah</option>
  							<option value="har">Haryana</option>
  							<option value="utt">Utterpardesh</option>
  							<option value="pun">Punjab </option>
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
					
				</div>
			</div>

			<div class="control">
				<div class="row">
					<div class="col-lg-6">
						<!-- username-->
						<label for="username">User Name:</label>
						<input type="text" name="username" id="username" placeholder="enter your username" class="form-control" required="">
						<i class="fa fa-check-circle" id="userSuccess"></i>
						<i class="fa fa-exclamation-circle" id="userError"></i>
						<span id="umsg" class="errormsg">**invalid user name**</span>
					</div>
					<div class="col-lg-6">
						<!-- pass-->
						<label for="password">Password:</label>
						<input type="password" name="password" id="password" placeholder="enter your password" class="form-control" required="">
						<i class="fa fa-check-circle" id="passSuccess"></i>
						<i class="fa fa-exclamation-circle" id="passError"></i>
						<span id="pmsg" class="errormsg">**invalid password**</span>
						
					</div>
				</div>
			</div>
			<input type="checkbox" name="showpass" onclick="showPassword()"><label>show Password</label>

			<br>
			<button class="btn btn-success" type="submit" onclick="validate();">submit
			</button>

		</form>
	</div>
	${msg}
   </div>
<div class="col-lg-3"></div>
</div>


</body>
</html>