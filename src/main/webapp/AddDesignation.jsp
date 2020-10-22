<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
   <!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
    
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

<form action="addDesignation" style="margin-left:500px;margin-top:100px">
Enter new Designation:
 <input type="text" name="designation">
 <input type="submit" value="add" class="btn btn-success">
${msg}
</form>

 </body>
</html>