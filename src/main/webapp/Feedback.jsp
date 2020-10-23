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

<%@include file="AdminNav.jsp"%>

<jstl:forEach items="${list}" var="list">
 <div class="card" style="margin-top:100px;margin-left:300px;width:800px;">
  <div class="card-header">${list.name }</div>
  <div class="card-body">
     <p>Position : ${list.position }</p>
     <p>Mobile Number : ${list.mob}</p>
      <p>Mail Id : ${list.mail }</p> 
      <p>Feedback : ${list.feedback}</p>
  </div>
  <div class="card-footer">
      <a href="deleteFeedback?fid=${list.fid}" class="btn btn-danger">DELETE</a>
  </div>
</div>
</jstl:forEach>
</body>
</html>