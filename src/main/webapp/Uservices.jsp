<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<%

response.setHeader("Cache-Control"," no-cache, no-store, must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server
if(session.getAttribute("cuname")==null)
	{
	response.sendRedirect("UserLogin.jsp");
	}
	%>
	<a href="UserlogOut">Logout</a>
	well come ${cuname}
<div class="container">
 
  <div class="panel panel-default">
  
    <div class="panel-body">
   <a href="getAllSpForUser" class="btn btn-success">All Service Provider</a>
    </div>
  </div>
</div>

  
  <jstl:forEach items="${list}" var="li">
<div class="container">
 
  <div class="panel panel-default">
  
    <div class="panel-body">
   
  <a href="DrelatedSP?des=${li.designation}" class="btn btn-success"><h6>${li.designation}</h6></a>
    </div>
  </div>
</div>
</jstl:forEach>
</body>
</html>