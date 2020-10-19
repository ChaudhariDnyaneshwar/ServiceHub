<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
     <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>User Services</title>

	<!-- CSS only -->
	<link rel="stylesheet" type="text/css" href="${css}/UserServicesDetail.css">
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
  </head>

<body>
 <% 

response.setHeader("Cache-Control"," no-cache,no-store,must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server  

if(session.getAttribute("cuname")==null)
	{
	response.sendRedirect("UserLogin.jsp");
	}
	%>

<%@ include file="UserNav.jsp" %>
 <jstl:forEach items="${list}" var="list">
 <div class="fixed" >
  
		<div class="panel panel-info " style="margin-left: 350px;margin-right: 350px;margin-top:50px ;border-width: 5px;">
			<div class="panel-heading">
			
				<div id="text" style="display: left;"><b>Name :</b>  ${list.fname}   ${list.lname}
				
					<img class="img img-thumbnail" src='getDrelatedImg?id=${list.sp_id}' width="100px" height="150px" align="right" >
		          
				</div>
			
		</div>
			<div class="panel-body">
			<b>Designation :</b> ${list.designation}</div>
			<div class="panel-body"><b>Experience :</b>${list.experiance}</div>
			<div class="panel-body "><b>Specialization :</b> ${list.specialization }</div>
			<div class="panel-body"><b>Mobile No :</b>${list.mob_number }</div>
			<div class="panel-body"><b>Email :</b> ${list.email }</div>
			<div class="panel-body ">
			<b>Office Address :</b> ${list.office_address }</div>
		<br><br>    <a href="getAppointmentDrsp?cuname=${cuname}&spuname=${list.user_name}"  class="btn btn-info">Appointment</a>
		</div>

	</div>
</jstl:forEach>  
 


</body>
</html>