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
	 <link rel="stylesheet" type="text/css" href="${css}/UserServices.css">
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
<%@include file="UserNav.jsp" %>
<body class="body" >
<%-- <%

response.setHeader("Cache-Control"," no-cache, no-store, must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server
if(session.getAttribute("cuname")==null)
	{
	response.sendRedirect("UserLogin.jsp");
	}
	%>
	--%>
	<h4>well come ${cuname}</h4> 
<div class="panel panel-default div" >
		
	<div class="control">
				<div class="row">
					<div class="col-lg-12">
						<h1 style="font-weight: bold;">SERVICES</h1><hr><br>
						<h45 ><a href="getAllSpForUser" id="l1" class="btn btn-primary" role="button" > All Services</a></h45>
						
						<jstl:forEach items="${list}" var="li">
	<h45 style="padding-left: 100px">
	<a href="DrelatedSP?des=${li.designation}" id="l2" class="btn btn-primary" role="button" >${li.designation}</a></h45>
                       </jstl:forEach>						
						
					</div>
					
				</div>
				
			</div>
		</div>


</body>
</html>