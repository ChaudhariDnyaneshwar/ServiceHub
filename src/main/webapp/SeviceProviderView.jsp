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
<div class="row">
    <div class="col-lg-3"></div>
      <div class="col-lg-6">
         <div class="row">
         
         
<div class="panel panel-info">
      <div class="panel-heading">
         <h3>service provider id: ${list.sp_id}</h3>
       <h3>First name :${list.fname}</h3>
       <h3>Last name :${list.lname}</h3>
      </div>
      <div class="col-lg-6">
      <div class="panel-body">
      
       <h4>mobile number is :${list.mob_number }</h4>
     <h4>Email id is:${list.email }</h4>
     <h4>adhar number is:: ${list.addar_number }</h4>
     <h4>gender is :${list.gender}</h4>
     <h4>date of birth is :${list.dateofbirth }</h4>
     <h4>Designation Is :${list.designation}</h4>
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
         Image:<br><img width="100" height="150"  src='getSPimgae?id=${list.sp_id}' class="img-thumbnail" >
         Adhar card is:<img width="100" height="150"  src='getSpAdharImage?id=${list.sp_id}' class="img-thumbnail" >
       <br>  Licences:<br><img width="100" height="150"  src='getSplicence?id=${list.sp_id}' class="img-thumbnail" >
         Qualification:<br> <img width="100" height="150"  src='getSpQualificationImg?id=${list.sp_id}' class="img-thumbnail" >
        <br>
        <a href="deleteSp?id=${list.sp_id}" class="btn btn-danger">DELET</a> 
        
       </div>
      
    
   </div> 
   
   
   <!-- tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt -->
       
       <!-- ------ -->
    </div>
   </div>
   
   
    <div class="col-lg-3"></div>
</div>
  </jstl:forEach>
</body>
</html>