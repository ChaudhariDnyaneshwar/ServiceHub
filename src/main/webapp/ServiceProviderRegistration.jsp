<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
  <!-- decalaring spring variable for static resources -->
 
 <spring:url var="css" value="/resources/css"></spring:url>
 <spring:url var="image" value="/resources/image"></spring:url>
 <spring:url var="js" value="/resources/js"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="${css}/ServiceProviderRegistration.css">
	

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

 <body>
    <form class="signup-form" action="ServiceProviderRegistration" method="POST" enctype="multipart/form-data" >

      <!-- form header -->
      <div class="form-header">
        <h1>Service Provider Form</h1>
      </div>

      <!-- form body -->
      <div class="form-body">

        <!-- Firstname and Lastname -->
        <div class="horizontal-group">
          <div class="form-group left">
            <label for="firstname" class="label-title">First name *</label>
            <input type="text" id="firstname" name="fname" class="form-input" placeholder="enter your first name" required="required" />
          </div>
          <div class="form-group right">
            <label for="lastname" class="label-title">Last name *</label>
            <input type="text" id="lastname" name="lname" class="form-input" placeholder="enter your last name" />
          </div>
        </div>

      

        <!-- Mobile -->
        
          <div class="form-group left">
            <label for="mobile" class="label-title">Mobile No *</label>
            <input type="mobile" id="mobile" class="form-input" name="mob" placeholder="enter your mobile Number" required="required">
          </div>
            <!-- Email -->
        <div class="horizontal-group">
            <div class="form-group right">
          <label for="email" class="label-title">Email*</label>
          <input type="email" id="email" class="form-input"  name="email" placeholder="enter your email" required="required">
        </div>
        </div>
<!-- Adhar Number And Designation-->

        <div class="form-group left">
          <label for="mobile" class="label-title">Adhar No. *</label>
          <input type="mobile" id="mobile" class="form-input" name="addarn"  placeholder="enter your adhar Number" required="required">
        </div>
          <!-- Designation -->
      <div class="horizontal-group">
          <div class="form-group right">
        <label for="email" class="label-title">Designation*</label>
        <input type="text" id="email" class="form-input" name="design" placeholder="enter your designation" required="required">
      </div>
      </div>


        <!-- Gender and Hobbies -->
        <div class="horizontal-group">
          <div class="form-group left">
            <label class="label-title">Gender:</label>
            <div class="input-group">
              <label for="male"><input type="radio" name="gender" value="male" id="male"> Male</label>
              <label for="female"><input type="radio" name="gender" value="female" id="female"> Female</label>
              <label for="female"><input type="radio" name="gender" value="other" id="other"> Other</label>
            </div>
          
          </div>

<!-- Date Of Birth-->

  
    <div class="form-group right">
  <label for="date"  class="label-title">Date Of Birth *</label>
  
  <input type="Date" id="date" name="date" class="form-input" required="required" />
  </div>
   </div> 


<!-- Specialization -->
  
  <div class="horizontal-group">  
    <!-- <div class="form-group left"> -->


     <label for="adrress"class="label-title">Enter your specialization *</label>
    <textarea  cols="80" rows="5" id="adrress"  class="form-input1" name="specialization" placeholder="Ex. if you are docter the specialization 1)dental" >
     </textarea> 
 
</div> 



  <!-- Address -->
  
  <div class="horizontal-group">  
    <!-- <div class="form-group left"> -->


     <label for="adrress"class="label-title">Enter Office Adrress *</label>
    <textarea  cols="80" rows="5" id="adrress"  class="form-input1" name="adrress" placeholder="Write something.." >
     </textarea> 
 
</div> 


 
        
  <!-- City  Name And Taluka -->
  <div class="horizontal-group">
    <div class="form-group left">
      <label for="city" class="label-title">City *</label>
      <input type="text" name="city" id="city" class="form-input" placeholder="enter your city" required="required" />
    </div>

    <div class="form-group right">
      <label for="taluka" class="label-title">Tehsil *</label>
      <input type="text" id="Taluka" class="form-input" placeholder="enter your tehsil"  name="tahsil"/>
    </div>
  </div>

<!-- District Name Ans State-->
<div class="horizontal-group">
    <div class="form-group left">
      <label for="district" class="label-title">District *</label>
      <input type="text" id="district" class="form-input" placeholder="enter your district" required="required" name="dist" />
    </div>
    
    <div class="form-group right">

      <label for="state" class="label-title">State *</label>
      <select id="state" name="state"  class="form-input" name="state">
        <option value="mah">Maharashtrah</option>
        <option value="har">Haryana</option>
        <option value="utt">Utterpardesh</option>
        <option value="pun">Punjab </option>
      </select>

      
    </div>
  </div>
       
       


              <!-- City  Name And Taluka -->
  <div class="horizontal-group">
    <div class="form-group left">
      <label for="city" class="label-title">Highst Qualification *</label>
     <input type="text" name="hqualification">  
     </div>

    <div class="form-group right">
      <label for="taluka" class="label-title">Enter University Name *</label>
      <input type="text" id="Taluka" class="form-input" placeholder="enter your tehsil" name="univercity"/>
    </div>
  </div>


        <!-- Experience Year And Certificate-->
        <div class="horizontal-group">
            <div class="form-group left">

                <label  for="exp" class="label-title">Experince Year *</label>
                <select class="form-input" id="exp" name="experiance" >
                  <option value="0">0</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>

                </select>
            </div>
           
  
        <!-- Highest And Licence Certificate -->
        <div class="horizontal-group">
          <div class="form-group left">
            <label for="Upload" class="label-title">qualification certificate *</label>
            <input type="file" id="upload" size="80" name="qualification">
          </div>

          <div class="form-group right">
            <label for="Upload" class="label-title">Licence certificate *</label>
            <input type="file" id="upload" size="80" name="licence">
          </div>
        </div>

         <!-- Upload Photo  -->
         <div class="horizontal-group">
            <div class="form-group left" >
              <label for="upload" class="label-title">Upload Photo *</label>
              <input type="file" id="upload" size="80" name="photo">
             </div>
           
             <div class="horizontal-group">
              <div class="form-group left" >
                <label for="upload" class="label-title">Upload adhar card*</label>
                <input type="file" id="upload" size="80" name="adhard">
              </div>
             </div>
        <!--UserName-->
       <!-- <div class="horizontal-group"> -->
        <div class="form-group right" >
          <label class="label-title">User Name *</label>
          <input type="text" id="firstname" class="form-input" placeholder="enter your user name" required="required" name="username"/>
       
      </div>
         </div>

       <!-- Password And Confirm password -->
 <div class="horizontal-group">
    <div class="form-group left">
      <label for="password" class="label-title">Password *</label>
      <input type="password" id="password" class="form-input" placeholder="enter your password" required="required" name="password"/>
    </div>
    <div class="form-group right">
      <label for="lastname" class="label-title">Confirm Password *</label>
      <input type="password" id="password" class="form-input" placeholder="enter  confirm password" />
    </div>
    


  </div>

      <!-- form-footer -->
      <div class="form-footer">
        <span>* required</span>
        <button type="submit" class="btn">Register</button>
      </div>

    </form>

${msg}
  </body>

</html>