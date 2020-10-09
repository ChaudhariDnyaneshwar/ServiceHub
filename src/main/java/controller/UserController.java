package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.DesignationDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import pojoclasses.Designation;
import pojoclasses.ServiceProvider;
import pojoclasses.User;
  
  
@Controller
public class UserController {

	@Autowired
	 UserDao ud;
	@Autowired
	DesignationDao dd;
	
	@Autowired
	ServiceProviderDao spd;
	//====================================================================================================
	
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
//================================================================================================
    @RequestMapping("/getDesignation")
	public ModelAndView getDesignation()
	{
		ModelAndView mv=new ModelAndView();
		List<Designation> dlist=dd.getDesignation();
		mv.addObject("list",dlist);
		mv.setViewName("Uservices");
		return mv;
	}
	//============================================================================================
    @RequestMapping("/DrelatedSP")
    public ModelAndView getDrelatedSp(@RequestParam("des")String designation)
    {
    	ModelAndView mv=new ModelAndView();
        List<ServiceProvider> list=spd.getDrelatedSp(designation);
    	mv.addObject("list",list);
    	mv.setViewName("showDrelatedSp");
    	return mv;
    	
    }
    //====================================================================================
    
    @RequestMapping("/getDrelatedImg")
    public void getDrelatedImg(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
    {
    	response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
    }
    
    //==================================================================================
    
    @RequestMapping("/getAllSpForUser")
    public ModelAndView getAllSpForUser()
    {
    	ModelAndView mv=new ModelAndView();
    	List<ServiceProvider> list=spd.getServiceProvider();
    	mv.addObject("list",list);
    	mv.setViewName("AllSpForUser");
    	return mv;
    }
    
    //===============================================================================
    @RequestMapping("/AllSpForUserImg")
    public void getAllSpImageForUser(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
    {
    	response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
    }
}
