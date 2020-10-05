package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.UserDao;
import pojoclasses.User;
  
  
@Controller
public class UserController {

	@Autowired
	 UserDao ud;
	
	@RequestMapping("/userRegistration")
	  public ModelAndView registerUser(HttpServletRequest request)
	  {
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String email=request.getParameter("emailId");
		String  mobileno=request.getParameter("mobileNo");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String tahasil=request.getParameter("taluka");
		String district=request.getParameter("district");
		String state=request.getParameter("district");
		String dob=request.getParameter("dob");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		ModelAndView mv=new ModelAndView();
		  
		User user=new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setMobilenumber(mobileno);
	    user.setGender(gender);
	    user.setAddress(address);
	    user.setCity(city);
	    user.setTahasil(tahasil);
	    user.setDistrict(district);
	    user.setState(state);
	    user.setDateofbirth(dob);
	    user.setUsername(username);
	    user.setPassword(password);
		
	     int count=ud.save(user);
	     if( count>0)
	     {
	    	 mv.addObject("msg","insertion successfully done...");
	     }
	     else
	     {
	    	 mv.addObject("msg","insertion is failed...");
	     }
	     mv.setViewName("userregistration");
		  return mv;
	  }


}
