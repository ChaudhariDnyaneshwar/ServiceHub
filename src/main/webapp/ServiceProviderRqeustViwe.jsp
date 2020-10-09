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
   <jstl:forEach var="list" items="${list}">
<div class="container">
  
  <div class="panel panel-default">
    <div class="row">
       <div class="col-lg-6">
    <div class="panel-heading">
       <h3>service provider id: ${list.sp_id}</h3>
       <h3>First name :${list.fname}</h3>
       <h3>Last name :${list.lname}</h3>
     
    </div>
    <div class="panel-body">
     <h4>mobile number is :${list.mob_number }</h4>
     <h4>Email id is:${list.email }</h4>
     <h4>adhar number is:: ${list.addar_number }</h4>
     <h4>gender is :${list.gender}</h4>
     <h4>date of birth is :${list.dateofbirth }</h4>
     <h4> Designation is :${list.designation }</h4>
     <h4>specialization is:${list.specialization }</h4>
     <h4>office address is :${list.office_address }</h4>
     <h4>city is :${list.city }</h4>
     <h4>tahsil is:${list.tahsil }</h4>
     <h4>district is :${list.district}</h4>
     <h4>state is :${list.state }</h4>
     <h4>qualification is :${list.high_qualification}</h4>
     <h4>university name is :${list.university_name }</h4>
     <h4>experiance is :${list.experiance}</h4>
    </div>
    </div>
      <div class="col-lg-6">
      <div class="row">
        <div class="col-lg-6">
      Image:<br><img width="200" height="150"  src='getSPImage_req?id=${list.sp_id}' class="img-thumbnail" >
       <br> Adhar card is:<br><img width="200" height="150"  src='getSpAdharImage_req?id=${list.sp_id}' class="img-thumbnail" >
              <a href="acceptSpRequesta?id=${list.sp_id}&mail=${list.email }" class="btn btn-success">ACCEPT</a>   
                 </div>
                 <div class="col-lg-6">
         Licences:<br><img width="200" height="150"  src='getSplicence_req?id=${list.sp_id}' class="img-thumbnail" >
      <br>Qualification:<br> <img width="200" height="150"  src='getSpQualification_req?id=${list.sp_id}' class="img-thumbnail" >
    <br><br>
       <a href="RejectServiceProvider?id=${list.sp_id}&mail=${list.email }" class="btn btn-danger">REJECT</a>   
    </div>
       </div>
      </div>
  </div>
  </div>
</div>
</jstl:forEach>

</body>
</html>