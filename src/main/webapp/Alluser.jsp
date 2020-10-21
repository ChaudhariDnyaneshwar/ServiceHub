<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Header.jsp" %>
<title>All user</title>
</head>
<body >

<%@ include file="AdminNav.jsp" %>
<table class="table table-striped" style="width:1800px;margin-top:50px;margin-left:80px;background-color:#f0e9e6;">
    <thead class="thead-light">
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


</body>
</html>