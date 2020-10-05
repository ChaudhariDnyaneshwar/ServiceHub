function validate()
{
			// Mobile No validation
			var mno =document.getElementById('mobileNo');
			var regx=/^[7-9]\d{9}$/;
			if(regx.test(mno.value) && mno.value.trim()=="") {
				document.getElementById('noError').style.visibility="hidden";
				document.getElementById('noSuccess').style.visibility="visible";
				document.getElementById('mmsg').style.visibility="hidden";
			}
			else{
				document.getElementById('noSuccess').style.visibility="hidden";
				document.getElementById('noError').style.visibility="visible";
				document.getElementById('mmsg').style.visibility="visible";
			}
			


			//blank space validation
			//fname
			var fname=document.getElementById('firstname');
			if(fname.value.trim()=="") 
			{
			   document.getElementById('fnameError').style.visibility="visible";
				document.getElementById('fnameSuccess').style.visibility="hidden";
				document.getElementById('fmsg').style.visibility="visible";
			}
			else
			{
				document.getElementById('fnameSuccess').style.visibility="visible";
				document.getElementById('fnameError').style.visibility="hidden";
				document.getElementById('fmsg').style.visibility="hidden";
			}

			// lastname
			var lname=document.getElementById('lastname');
			if(lname.value.trim()=="") 
			{
			    document.getElementById('lnameError').style.visibility="visible";
				document.getElementById('lnameSuccess').style.visibility="hidden";
				document.getElementById('lmsg').style.visibility="visible";
			}
			else
			{
				document.getElementById('lnameSuccess').style.visibility="visible";
				document.getElementById('lnameError').style.visibility="hidden";
				document.getElementById('lmsg').style.visibility="hidden";
			}
			// email
			var email=document.getElementById('emailId');
			if(email.value.trim()=="") 
			{
			   document.getElementById('emailError').style.visibility="visible";
				document.getElementById('emailSuccess').style.visibility="hidden";
				document.getElementById('emsg').style.visibility="visible";
			}
			else{
				document.getElementById('emailSuccess').style.visibility="visible";
				document.getElementById('emailError').style.visibility="hidden";
				document.getElementById('emsg').style.visibility="hidden";
			}
			//radio
			//add
			var add=document.getElementById('address');
			// firstname
			//city
			var city=document.getElementById('city');
			if (city.value.trim()=="") {
				document.getElementById('cityError').style.visibility="visible";
				document.getElementById('citySuccess').style.visibility="hidden";
				document.getElementById('cmsg').style.visibility="visible";
			}
			else{
				document.getElementById('cityError').style.visibility="hidden";
				document.getElementById('citySuccess').style.visibility="visible";
				document.getElementById('cmsg').style.visibility="hidden";
			}
			// taluka
			var taluka=document.getElementById('taluka');
			if (taluka.value.trim()=="") {
				document.getElementById('talukaError').style.visibility="visible";
				document.getElementById('talukaSuccess').style.visibility="hidden";
				document.getElementById('tmsg').style.visibility="visible";
			}
			else{
				document.getElementById('talukaError').style.visibility="hidden";
				document.getElementById('talukaSuccess').style.visibility="visible";
				document.getElementById('tmsg').style.visibility="hidden";
			}
			// district
			var dist=document.getElementById('district');
			if (dist.value.trim()=="") {
				document.getElementById('distError').style.visibility="visible";
				document.getElementById('distSuccess').style.visibility="hidden";
				document.getElementById('dmsg').style.visibility="visible";
			}
			else{
				document.getElementById('distError').style.visibility="hidden";
				document.getElementById('distSuccess').style.visibility="visible";
				document.getElementById('dmsg').style.visibility="hidden";
			}
			//state
			var state=document.getElementById('state');
			if (state.value.trim()=="") {
				document.getElementById('stateError').style.visibility="visible";
				document.getElementById('stateSuccess').style.visibility="hidden";
				document.getElementById('smsg').style.visibility="visible";
			}
			else{
				document.getElementById('stateError').style.visibility="hidden";
				document.getElementById('stateSuccess').style.visibility="visible";
				document.getElementById('smsg').style.visibility="hidden";
			}
			// dob
			var dob=document.getElementById('dob');
			if (dob.value.trim()=="") {
				document.getElementById('dobError').style.visibility="visible";
				document.getElementById('dobSuccess').style.visibility="hidden";
				document.getElementById('dobmsg').style.visibility="visible";
			}
			else{
				document.getElementById('dobError').style.visibility="hidden";
				document.getElementById('dobSuccess').style.visibility="visible";
				document.getElementById('dobmsg').style.visibility="hidden";
			}
			// username
			var user=document.getElementById('username');
			if (user.value.trim()=="") {
				document.getElementById('userError').style.visibility="visible";
				document.getElementById('userSuccess').style.visibility="hidden";
				document.getElementById('umsg').style.visibility="visible";
			}
			else{
				document.getElementById('userError').style.visibility="hidden";
				document.getElementById('userSuccess').style.visibility="visible";
				document.getElementById('umsg').style.visibility="hidden";
			}
			// password
			var pass=document.getElementById('password');
			if (pass.value.trim()=="") {
				document.getElementById('passError').style.visibility="visible";
				document.getElementById('passSuccess').style.visibility="hidden";
				document.getElementById('pmsg').style.visibility="visible";
			}
			else{
				document.getElementById('passError').style.visibility="hidden";
				document.getElementById('passSuccess').style.visibility="visible";
				document.getElementById('pmsg').style.visibility="hidden";
			}

			

}

			
			
		

//show password
function showPassword(){
	var password = document.getElementById("password");
  			if (password.type === "psw") {
    			password.type = "text";
  			} else {
   			 password.type = "psw";
  			}
}


