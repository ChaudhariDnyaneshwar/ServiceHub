package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.DesignationDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import daointerfaceses.ValidationDao;
import pojoclasses.Appoinment;
import pojoclasses.Designation;
import pojoclasses.ServiceProvider;
import pojoclasses.User;
import pojoclasses.Validation;
  
  
@Controller

public class UserController {

	@Autowired
	 UserDao ud;
	@Autowired
	DesignationDao dd;
	
	@Autowired
	ServiceProviderDao spd;
	
	@Autowired
	ValidationDao vd;
	
	
	
	//==========do user validation and maintain session..
	
    @RequestMapping("/userValidation")
    public ModelAndView doUserLoginValidation(@RequestParam("uname")String uname,@RequestParam("pwd")String password,HttpSession session) throws IOException
    {
    	ModelAndView mv=new ModelAndView();
    	int a=0;
    	Validation v=new Validation();
    	v.setUsername(uname);
    	v.setPassword(password);
    	a=vd.userValidation(v);
    
       if(a>0)
       {   
    	   session.setAttribute("cuname",uname);
    	  // model.put("cuname",uname);
    	  mv.setViewName("UserHome");
    	    
       }
       else
       {
    	mv.addObject("msg","plse enter valid user name and password");
       	mv.setViewName("UserLogin");   
    	
       }
    	return mv;
    }

    //======do user logout operation...
   
   @RequestMapping("/UserlogOut")
    public ModelAndView getuLogout(HttpSession session)
    {
    	ModelAndView mv=new ModelAndView();
    	session.removeAttribute("cuname");
    	session.invalidate();
    	mv.setViewName("UserLogin");
    	return mv;
    }
    
    
    
//=================get list of services available in our web application for user	
	
    @RequestMapping("/getDesignation")
	public ModelAndView getDesignation() throws IOException
	{
    	ModelAndView mv=new ModelAndView();	
    		List<Designation> dlist=dd.getDesignation();
    		mv.addObject("list",dlist);
    		mv.setViewName("Uservices");	
		return mv;
	}
	
    // get list designation related service provider list ...
    
    @RequestMapping("/DrelatedSP")
    public ModelAndView getDrelatedSp(@RequestParam("des")String designation)
    {
    	ModelAndView mv=new ModelAndView();
        List<ServiceProvider> list=spd.getDrelatedSp(designation);
    	mv.addObject("list",list);
    	mv.setViewName("showDrelatedSp");
    	return mv;
    	
    }
    //=====get list designation related service provider image list..
    
    @RequestMapping("/getDrelatedImg")
    public void getDrelatedImg(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
    {
    	response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
    }
    
    //== get all service provider list for the user...
    
    @RequestMapping("/getAllSpForUser")
    public ModelAndView getAllSpForUser()
    {
    	ModelAndView mv=new ModelAndView();
    	List<ServiceProvider> list=spd.getServiceProvider();
    	mv.addObject("list",list);
    	mv.setViewName("AllSpForUser");
    	return mv;
    }
    
    //===== get all service provider images list...
    
    @RequestMapping("/AllSpForUserImg")
    public void getAllSpImageForUser(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
    {
    	response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
    }

    
    //==do user registration operation...
    
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
	
	     mv.setViewName("userregistration");
		  return mv;
	  }
	
	
//===fix appointment to the user....
    
	@RequestMapping("/getAppointmentAll")
	public ModelAndView  getAppointmentAll(@RequestParam("cuname")String cuname,@RequestParam("spuname")String spuname)
	{
		ModelAndView mv=new ModelAndView();
		Appoinment a=new Appoinment();
		a.setSpuname(spuname);
		a.setCuname(cuname);
		int count=ud.addAppoinment(a);
		
		mv.setViewName("redirect:/getAllSpForUser");
		return mv;
	}
	
	//==== fix appointment designation related service provider 
    
		@RequestMapping("/getAppointmentDrsp")
		public ModelAndView  getAppointment(@RequestParam("cuname")String cuname,@RequestParam("spuname")String spuname)
		{
			ModelAndView mv=new ModelAndView();
			Appoinment a=new Appoinment();
			a.setSpuname(spuname);
			a.setCuname(cuname);
			int count=ud.addAppoinment(a);
			
			mv.setViewName("redirect:/getDesignation");
			return mv;
		}
		
		//===========================================================================================

}
