<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@include file="Header.jsp" %>	
  </head>


<body class="body">
<!-- session maintain -->
<%

response.setHeader("Cache-Control"," no-cache, no-store, must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server
if(session.getAttribute("sp_uname")==null)
	{
	response.sendRedirect("SeviceProviderLogin.jsp");
	}
	%>
<!-- nav bar  -->

 <%@ include file="ServiceProviderNav.jsp" %>
  <!-- Panel -->
  <jstl:if test="${not empty list }">
  <jstl:forEach items="${list}" var="list">
  <div class="fixed" >
    <div class="panel panel-info " style="margin-left: 300px;margin-right: 300px;margin-top:50px ;border-width: 5px;">
      <div class="panel-heading">
      
        <div id="text" style="display: left;"><h3>Name : ${list.fname }   ${list.lname}</h3>
        
        </div>
      
    </div>
      <div class="panel-body" ><b> Mobile No :</b>${list.mobilenumber}</div>
      <div class="panel-body" ><b>Email :</b> ${list.email }</div>
      <div class="panel-body " >
      <b >Office Address :</b> ${list.address}</div>
      </div>
  </div>
  </jstl:forEach>
 </jstl:if>
 <!-- -------------------------------------------- -->
 <jstl:if test="${! not empty list }">
 <br><br>
<h2> <p>Sorry ,You don't have any client yet..</p></h2>
 </jstl:if> 
</body>
</html>