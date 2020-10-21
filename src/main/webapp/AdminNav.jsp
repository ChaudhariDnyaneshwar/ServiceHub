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
	<%@include file="Header.jsp" %>
		<title>Admin nav</title>
	
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
    <ul class="navbar-nav justify-content-ends">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
           
      <li class="nav-item">
        <a class="nav-link" href="spregistration_request">Service Provider Request</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddDesignation.jsp">Add Designation</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="getServiceProvider">Service Provider</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="getAllusers">User</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminAbout.jsp">About Us</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="AdminContact.jsp">Contact</a>
      </li>
     
      
      <li class="nav-item">
        <a class="nav-link" href="#">Logout</a>
      </li>
      
      
    </ul>
  </div>
  </nav>

</body>
</html>