<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%

response.setHeader("Cache-Control"," no-cache, no-store, must-revalidate");//HTTP 1.0
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0") ;//proxy server
if(session.getAttribute("sp_uname")==null)
	{
	response.sendRedirect("SeviceProviderLogin.jsp");
	}
	%>

 <!-- nav bar -->
 <%@include file="ServiceProviderNav.jsp" %>
<h4> Well come ${sp_uname}</h4> 
 <!-- body code -->
 <%@ include file="SharHome.jsp" %>
</body>
</html>