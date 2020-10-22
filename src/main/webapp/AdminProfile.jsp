<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
 <jstl:forEach items="${list}" var="list">
 <div class="card" style="width:400px;margin-top:100px;margin-left:400px;background-color:rgba(116, 208, 251, 0.67);">
  
  <div class="card-body">
    <h4 class="card-title">User name : ${list.username }</h4>
    <p class="card-text">Password : ${list.password }</p> 
     <p class="card-text">email : ${list.email}</p>      
    </div>
</div>
</jstl:forEach>

</body>
</html>