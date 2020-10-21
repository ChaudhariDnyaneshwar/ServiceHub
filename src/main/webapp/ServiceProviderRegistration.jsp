<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
 <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- decalaring spring valriable for static resources -->
   <spring:url var="css" value="/resources/css" ></spring:url>
   <spring:url var="image" value="/resources/image"></spring:url>
    <spring:url var="js" value="/resources/js"></spring:url>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="${css}/ServiceProviderRegistration.css">
	<link rel="stylesheet" type="text/css" href="${css}/Home.css">
   <%@include file="Header.jsp" %>
	<title>create account</title>
</head>

 <body>
 
 	<!-- navbar -->
	
 	<nav class="navbar navbar-expand-lg sticky-top">
  <a class="navbar-brand" href="#">
    <img src="${image}/logo.png" class="logo">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fa fa-bars nav-icon" aria-hidden="true"></i>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="About.jsp">About Us</a>
      </li>
     
      <li class="nav-item">
        <a class="nav-link" href="Contact.jsp">contact</a>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">login/Register
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="AdminLogin.jsp">Admin</a>
          <a class="dropdown-item" href="UserLogin.jsp">User</a>
          <a class="dropdown-item" href="ServiceProviderLogin.jsp">Service Provider</a>
        </div>
      </li>
      
    </ul>
  </div>
  </nav> 
 
 <!-- ---------------------------------------------------------------------------------- -->
   <div class="row">
      <div class="col-lg-3"></div>
     <div class="col-lg-6" >
   <form name="form" onsubmit="return validateForm()" action="ServiceProviderRegistration" method="POST" enctype="multipart/form-data" >
      <!-- form header -->
      <div class="form-header">
        <h1>Service Provider Form</h1>
      </div>

      <!-- form body -->
      <div class="form-body">

        <!-- Firstname and Lastname -->
        <div class="row">
          <div   class="col-lg-6">
            <label for="firstname" class="label-title">First name *</label>
            <input type="text" id="fname"  name="fname" class="form-input" placeholder="enter your first name" required="required" />
          </div>
          <div class="col-lg-6">
            <label for="lastname" class="label-title">Last name *</label>
            <input type="text" id="lname" name="lname" class="form-input" placeholder="enter your last name" />
          </div>
        </div>

      

        <!-- Mobile -->
       <div class="row"> 
          <div  class="col-lg-6">
            <label for="mobile" class="label-title">Mobile No *</label>
            <input type="mobile" id="mobile"  name="mob" class="form-input" 
            placeholder="enter your mobile Number" required="required">
          </div>
            <!-- Email -->
        
            <div  class="col-lg-6">
          <label for="email" class="label-title">Email*</label>
          <input type="email" id="email"  name="email" class="form-input" 
          placeholder="enter your email" required="required">
        </div>
        </div>
<!-- Adhar Number And Designation-->
 <div class="row">
        <div  class="col-lg-6">
          <label for="aadhar" class="label-title">Adhar No. *</label>
          <input type="aadhar" id="aadhar"  name="adhar" class="form-input" 
          placeholder="enter your adhar Number" required="required">
        </div>
          <!-- Designation -->
      
          <div  class="col-lg-6">
        <label for="designation" class="label-title">Designation*</label>
         <select name="design" id="designation"  class="form-input" 
          placeholder="select designation" required="required"> >
         
         <jstl:forEach items="${des}" var="desi">
         
         <option>${desi.designation}</option>
         
         </jstl:forEach>
         
         </select>
      
      </div>
     </div>


        <!-- Gender  -->
        <div class="row">
          <div  class="col-lg-6">
            <label class="label-title">Gender:</label>
            <div class="input-group">
              <label for="male"><input type="radio" name="gender" value="male" id="male"> Male</label>
              <label for="female"><input type="radio" name="gender" value="female" id="female"> Female</label>
              <label for="female"><input type="radio" name="gender" value="other" id="other"> Other</label>
            </div>
          
          </div>

<!-- Date Of Birth-->

  
    <div  class="col-lg-6">
  <label for="date"  class="label-title">Date Of Birth *</label>
  
  <input type="Date" id="date" name="date" class="form-input" required="required" />
  </div>
   </div> 



  <!-- Address -->
  
  <div class="row">  
     <div class="col-lg-12"> 


     <label for="adrress"class="label-title">Enter Office Adrress *</label>
    <textarea  cols="80" rows="5" id="address"  class="form-input1" name="address" placeholder="Write something.." >
     </textarea> 
 
</div> 
</div>

 
        
  <!-- City  Name And Taluka -->
  <div class="row">
    <div  class="col-lg-6">
      <label for="city" class="label-title">City *</label>
      <input type="text" id="city" class="form-input" name="city" placeholder="enter your city" required="required" />
    </div>

    <div c class="col-lg-6">
      <label for="taluka" class="label-title">Tehsil *</label>
      <input type="text" id="Taluka" class="form-input" name="taluka" placeholder="enter your tehsil" />
    </div>
  </div>

<!-- District Name Ans State-->
<div class="row">
    <div class="col-lg-6">
      <label for="district" class="label-title">District *</label>
      <input type="text" id="district" class="form-input" name="dist" placeholder="enter your district" required="required" />
    </div>
    
    <div  class="col-lg-6">

      <label for="state" class="label-title">State *</label>
      <select id="state" name="state"  class="form-input">
        <option value="Maharashtra">Maharashtrah</option>
        <option value="Haryana">Haryana</option>
        <option value="Utterpardesh">Utterpardesh</option>
        <option value="Punjab">Punjab </option>
      </select>

      
    </div>
  </div>
       
       


              <!-- qualification -->
  <div class="row">
    <div  class="col-lg-6">
      <label for="quali" class="label-title">Highst Qualification *</label>
      <input type="text" id="uni" class="form-input" name="hqualification" placeholder="enter your Qualification" />
      
          </div>

    <div  class="col-lg-6">
      <label for="uni" class="label-title">Enter University Name *</label>
      <input type="text" id="uni" class="form-input" name="univercity" placeholder="enter your Univercity name" />
    </div>
  </div>
  
  
  <div class="row">  
  
  
          <!-- Experience -->
        
            <div  class="col-lg-6">
            <label  for="exp" class="label-title">Experince Year *</label>
                <select class="form-input" id="exp" name="experiance">
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9+">9+</option>

                </select>
            </div>
  
  <!--   specialization -->
    <div class="col-lg-6">
     <label for="spec"class="label-title">Enter Specilization *</label>
    <textarea  cols="80" rows="5" id="spec"  class="form-input1" name="specialization" placeholder="Write something.." >
     </textarea> 
      </div> 
  </div>
      
      <div class="row">
                    <!-- licences -->
         
          <div class="col-lg-6">
            <label for="Upload" class="label-title">Licence certificate *</label>
            <input type="file" id="upload"  name="licence" size="80">
          </div>
             
        <!-- Highest  Certificate -->
        
          <div class="col-lg-6" >
            <label for="upload" class="label-title">Highest Qualification certificate *</label>
            <input type="file" id="upload" name="qualification" size="80">
          </div>
        </div>  
        
        <div class="row">
        
       <!-- Upload Photo  -->
  
            <div  class="col-lg-6" >
              <label for="upload" class="label-title">Upload Photo *</label>
              <input type="file" id="upload" name="photo" size="80">
             </div>
      
  
      <!-- upload Adhar Card -->     
       <div  class="col-lg-6">
                <label for="upload" class="label-title">Upload adhar card*</label>
                <input type="file" id="upload" name="adhard" size="80">
              </div>
      
         </div>  
            
             <div class="row">
           
            <!-- licence certificate -->
         
                              
        <!--UserName-->
       
        <div  class="col-lg-6" >
          <label class="label-title">User Name *</label>
          <input type="text" id="firstname" name="username"    class="form-input" placeholder="enter your user name" required="required" />
          
      </div>
      
     </div>

       <!-- Password And Confirm password -->
 <div class="row">
    <div  class="col-lg-6">
      <label for="password" class="label-title">Password *</label>
      <input type="password" id="password1" name="password1" class="form-input" placeholder="enter your password" required="required" />
    </div>
    <div  class="col-lg-6">
      <label for="lastname" class="label-title">Confirm Password *</label>
      <input type="password" id="password2" name="password2" class="form-input" placeholder="enter your confirm password" />
    </div>
  
  </div>
</div>

      <!-- form-footer -->
      <div class="form-footer">  
        <button type="submit"  value="Request"  class="btn btn-success">Send Registration Request </button>
      </div>
      
    </form>
<!-- Form is End -->
</div>
 <div class="col-lg-3"></div>
 </div>
 
  </body>

</html>