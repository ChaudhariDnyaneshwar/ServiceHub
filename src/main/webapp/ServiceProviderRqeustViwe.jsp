<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
   <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
    <spring:url var="js" value="/resources/js"></spring:url>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/ServiceProviderForAdmin.css">
     <%@include file="Header.jsp" %>	
	<title>create account</title>
</head>

<body class="body">
 <%

response.setHeader("Cache-Control"," no-cache,no-store,must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server
  
  if(session.getAttribute("auname")==null)
	{
	response.sendRedirect("AdminLogin.jsp");
	}
	%>
 
 
 <%@include file="AdminNav.jsp" %>

<jstl:if test="${not empty list}">  
  <jstl:forEach var="list" items="${list}">
  <div class="fixed" >
  
     
	<div class="card" style="margin-left: 100px;margin-right: 100px;margin-top:50px ;border-width: 5px;" >
		 <div class="card-body">
		<div class="card-title font" ><b>SPID :</b>${list.sp_id}<br/><b>Name :</b> ${list.fname}  ${list.lname}</div>
	
	  <div class="card-text"> 	
		<table class="table" style="text-align: left; ">
		<tr >
			<td colspan="3" width="300px">
		<b>Designation :</b>${list.designation}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Experience :</b> ${list.experiance}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		</tr>
		<tr><td><b>Specialization :</b>${list.specialization}</td>
		</tr>
		<tr>
			<td colspan="2" width="50%"><b>Qualification :</b>${list.high_qualification}</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>University :</b> ${list.university_name }
		<!--</div>-->
		</td></tr>
		
		<tr >
			<td colspan="3">
		<b>Mobile No :</b> ${list.mob_number}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Email :</b> ${list.email }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Adhar :</b> ${list.addar_number }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<b>DOB :</b> ${list.dateofbirth }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Gender :</b> ${list.gender}&nbsp;
		</td>
		</tr>
		<tr>
			<td colspan="2">
		<b>Office Address :</b>${list.office_address }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		</td>
		</tr>
		<tr class="a">
		<td colspan="4">
		<b>City :</b>${list.city }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<b>Tahsil :</b>${list.tahsil }</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>District :</b> ${list.district}</h45>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>State :</b> ${list.state }</h45>
		</td>
		</tr>
		<tr>
			<td colspan="4">
		<b>Image :</b>&nbsp;<img src='getSPImage_req?id=${list.sp_id}' width="100px" height="100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>QC :</b>&nbsp;<img src='getSpQualification_req?id=${list.sp_id}' width="100px" height="100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Aadhar :</b>&nbsp;<img src='getSpAdharImage_req?id=${list.sp_id}' width="100px" height="100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b>Licence :</b> &nbsp;<img src='getSplicence_req?id=${list.sp_id}' width="100px" height="100px">
		</td></tr>
		<tr>
			<td colspan="2" style="text-align: center;">
			<a href="acceptSpRequesta?id=${list.sp_id}&mail=${list.email }" class="btn btn-success">ACCEPT</a>
			<a href="RejectServiceProvider?id=${list.sp_id}&mail=${list.email }" class="btn btn-danger">REJECT</a> 
			
			
			</td>	
			
		</tr>
		</table>
		  </div>
		</div>
	
	</div>
     </jstl:forEach>
  </jstl:if>
  
  <jstl:if test="${!not empty list}">
  <br><br><h3>Sorry ,you don't have any service provider registration request is available</h3>
  </jstl:if>
 
</body>
</html>