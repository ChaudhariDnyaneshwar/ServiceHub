<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  
  if(session.getAttribute("cuname")==null)
	{
	response.sendRedirect("UserLogin.jsp");
	}
%>

<%@include file="UserNav.jsp" %>
<div class="row">
   <div class="col-lg-4"></div>
   <div class="col-lg-4">
<jstl:forEach items="${list}" var="list">
<div class="card" style="margin-top:150px;color: white;background-color: #ef8172;padding:50px;border-radius: 25px;">
  <div class="card-header"><h3>Name :${list.fname} ${list.lname}</h3> </div>
  <div class="card-body">
    <h4><p>Mobile No: ${list.mobilenumber}</p>
    <p>Email is:${list.email}</p>
    <p>Gender :${list.gender}</p>
    <p>Date of Birth: ${list.dateofbirth}</p>
    </h4>
  </div>
  <div class="card-footer">
   <h5> <p>Address is : ${list.address} </p>
    <p>city : ${list.city}            tahashil : ${list.tahasil}</p>
    <p>District : ${list.district}           State :${list.state}</p></h5>
    </div>
</div>
</jstl:forEach>
  </div>
<div class="col-lg-4"></div>
 
 </div>      
</body>
</html>