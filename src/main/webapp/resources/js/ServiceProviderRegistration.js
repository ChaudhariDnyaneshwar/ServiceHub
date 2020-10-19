function validateForm() {

// FirstName And Lastname Validation

var firstname = document.form.firstname.value;  
var lastname = document.form.lastname.value;  

if (firstname==null || firstname==""){  
  alert("Name can't be blank");  
  return false;  
}
else{  
  return true;  
  }  

if (lastname==null || lastname==""){  
  alert("Name can't be blank");  
  return false; 
}
else{  
  return true;  
  }  

  // password
 
 var password = document.form.password.value; 
 if(password.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  }  
  else{
    return true
  }
  
  // mobile valid
 var mobile=document.form.mobile.value; 
 if (isNaN(mobile)){  
  document.getElementById("mobile").innerHTML="Enter Numeric value only";  
  return false;  
}
else{
  return true;
}

// aadhar valid
var aadhar = document.form.aadhar.value;
 if (isNaN(aadhar)){  
  document.getElementById("aadhar").innerHTML="Enter Numeric value only";  
  return false;  
}
else{
  return true;
}




// email validation
var email = document.form.email.value; 

 if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(email)) {
                alert("You have entered an invalid email address!")
                return (false)
            }
            else{

              return true;
            }


// designation valid
var designation = document.form.designation.value;  
 if (designation.value == "")                               
    { 
        window.alert("Please enter your designation."); 
       
        return false; 
    } 
    else{
      return true;
    }

// gender validation
var gender = document.form.gender.value;
ErrorText= "";
  if ( ( gender[0].checked == false ) && (gender[1].checked == false ) && (gender[2].checked == false ) ) 
  {
  alert ( "Please choose your Gender: Male or Female" ); 
  return false;
  }
  if (ErrorText= "") 
  { 
    submit();
   }
  

//  date of birth vallid
var date = document.form.date.value;  

   var date=saildates.split('/')[2];
   var d = new Date();
   var lipday=((d.getFullYear()-date)/4);
   var month = d.getMonth()+1;
   var day = d.getDate();
   var output = day + '/' + month + '/' + d.getFullYear();
   var age=((daydiff(parseDate(output), parseDate(saildates))-lipday)/365);
   if(age > 18.000 || age== 18.000)
   {
       return true;
   }
   else
   {
       alert('Your age should be 18 or greater than 18 yrs!!!');
   }


function parseDate(str)
{
    var mdy = str.split('/')
    return new Date(mdy[2], mdy[1]-1, mdy[0]);
}

function daydiff(first, second) 
{
    return (first-second)/(1000*60*60*24)
}



// address valid
var address = document.form.address.value; 
if (address.value == "")                               
    { 
        window.alert("Please enter your address."); 
       
        return false; 
    } 
    else{

      return true;
    }

    // city

var city = document.form.city.value;  

if(state.value == "Please enter"){
document.getElementById('state').innerText = alertMsg;
state.focus();
return false;
}
else
{
return true;

}

//taluka
var taluka = document.form.taluka.value;  

if(taluka.value == "Please enter"){
document.getElementById('taluka').innerText = alertMsg;
taluka.focus();
return false;
}
else
{
return true;

}

//district valid
var district = document.form.district.value;

if(district.value == "Please enter"){
document.getElementById('district').innerText = alertMsg;
district.focus();
return false;
}
else
{
return true;

}

// state valid
var state = document.form.state.value; 

if(state.value == "Please Choose"){
document.getElementById('state').innerText = alertMsg;
state.focus();
return false;
}
else
{
return true;

}

// qualification
var qali = document.form.qali.value;  

if(quali.value == "Please Choose"){
document.getElementById('quali').innerText = alertMsg;
quali.focus();
return false;
}
else
{
return true;

}
// university valid
var uni = document.form.uni.value; 
if(uni=="")
{
alert("Please Enter university");
uni.focus();
return false;
}
else{
  return true;
}
// specialization valid
var spec = document.form.spec.value;
if(spec=="")
{
alert("Please specialization");
spec.focus();
return false;
}
else{
  return true;
}

// experience valid
var exp = document.form.exp.value; 
if(exp == "Select") {
        printError("exp", "Please select your experience");
    } else {
        printError("exp", "");
        exp = false;
    }

    //upload valid 

var upload = document.form.upload.value; 
 var upload = fileInput.value; 
          
            // Allowing file type 
            var allowedExtensions =  
                    /(\.jpg|\.jpeg|\.png|\.gif)$/i; 
              
            if (!allowedExtensions.exec(filePath)) { 
                alert('Invalid file type'); 
                fileInput.value = ''; 
                return false; 
            }  
            else  
            { 
              
                // Image preview 
                if (fileInput.files && fileInput.files[0]) { 
                    var reader = new FileReader(); 
                    reader.onload = function(e) { 
                        document.getElementById( 
                            'imagePreview').innerHTML =  
                            '<img src="' + e.target.result 
                            + '"/>'; 
                    }; 
                      
                    reader.readAsDataURL(fileInput.files[0]); 
                } 
            } 
// username valid
var username = document.form.username.value;
if(username=="")
{
alert("Please Enter Your Name");

username.focus();
return false;
}
else{
  return true;
}

















// first and confirm password
var firstpassword = document.form.password1.value;  
var secondpassword = document.form.password2.value;

if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  










}