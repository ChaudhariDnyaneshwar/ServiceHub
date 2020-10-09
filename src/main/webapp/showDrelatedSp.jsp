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
<jstl:forEach items="${list}" var="list">
<div class="container">
  
  <div class="panel panel-default">
    <div class="panel-heading">  
        <h3>Name :  ${list.fname}   ${list.lname}</h3>
       
     </div>
          <div class="row">
    <div class="panel-body">
           <div class="col-lg-6">
       <h4><b>mobile number is :</b>  ${list.mob_number }</h4>
     <h4><b>Email id is:</b>  ${list.email }</h4>
     <h4><b>Designation Is :</b>  ${list.designation}</h4>
     <h4><b>specialization is:</b>  ${list.specialization }</h4>
     <h4><b>office address is :</b>  ${list.office_address }</h4>
     <h4><b>qualification is :</b>  ${list.high_qualification}</h4>
     <h4><b>experiance is :</b>  ${list.experiance}</h4>   
    </div>
    <div class="col-lg-6">
     Image:<br><img width="100" height="150"  src='getDrelatedImg?id=${list.sp_id}' class="img-thumbnail" >
   <br><br><a href="#" class="btn btn-info">communicate</a>
    </div>
    
    
    </div>
    </div>
  </div><br><br>
</div>

</jstl:forEach>
</body>
</html>