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
response.setHeader("Cache-Control"," no-cache,no-store,must-revalidate");
if(session.getAttribute("auname")==null)
	{
	response.sendRedirect("AdminLogin.jsp");
	}
	%>

${auname}

<div class="container">
  <h2>Striped Rows</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Mobile Number</th>
        <th>Email Id</th>
        <th>Gender</th>
        <th>Address </th>
        <th>City</th>
        <th>Tahsil</th>
        <th>District</th>
        <th>state</th>
        <th>Date of Birth</th>
        <th>Operation</th>
      </tr>
    </thead>
    
     <jstl:forEach var="list" items="${list}">
    <tbody>
      <tr>
        <td>${list.uid}</td>
        <td>${list.fname}</td>
        <td>${list.lname}</td>
        <td>${list.mobilenumber}</td>
        <td>${list.email}</td>
        <td>${list.gender}</td>
        <td>${list.address}</td>
        <td>${list.city}</td>
        <td>${list.tahasil}</td>
        <td>${list.district}</td>
        <td>${list.state}</td>
        <td>${list.dateofbirth}</td>
        <td><a href="deleteUser?id=${list.uid}" class="btn btn-danger">delete</a></td>
      </tr>
      
    </tbody>
    </jstl:forEach>
  </table>
</div>



</body>
</html>