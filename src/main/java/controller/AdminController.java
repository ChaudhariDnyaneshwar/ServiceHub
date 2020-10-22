package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.AdminDao;
import daointerfaceses.DesignationDao;
import daointerfaceses.EmailGenarateDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import daointerfaceses.ValidationDao;
import pojoclasses.Admin;
import pojoclasses.Designation;
import pojoclasses.EmailGenerate;
import pojoclasses.ServiceProvider;
import pojoclasses.User;
import pojoclasses.Validation;

@Controller
public class AdminController {
    
	@Autowired
    UserDao ud;
	
	@Autowired
	ServiceProviderDao spd;

	@Autowired
	DesignationDao dd;
	
	@Autowired
	EmailGenarateDao egd;
	
	@Autowired
	ValidationDao vd;
	
	@Autowired
	AdminDao admin;
	
	
	//get Admint profile
	@RequestMapping("/getAdminProfile")
	public ModelAndView getAdminProfile(HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		String uname=(String)session.getAttribute("auname");
	     Admin a=new Admin();
	     a.setUsername(uname);
	    List<Admin> list= admin.getAdminProfile(a);
	     mv.addObject("list",list);
	     mv.setViewName("AdminProfile");
		return mv;
	}
	
  //Admin logout or admin username session exite
	@RequestMapping("/adminLogout")
  	public ModelAndView getAdminLogout(HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		session.removeAttribute("auname");
    	session.invalidate();
    	mv.setViewName("AdminLogin");
		return mv;
	}
	//updating admin password
	@RequestMapping("/UpdateAdminPassword")
	public ModelAndView updateAdminPassword(@RequestParam("uname")String uname,@RequestParam("pass")String pass)
	{
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		a.setUsername(uname);
		a.setPassword(pass);
		int count=admin.updateAdminPassword(a);
	   if(count>0)
	   {  
		   mv.addObject("umsg","your password is updated successfuly completed");
		   mv.setViewName("AdminLogin");
	   }
	   else
	   {
		   mv.addObject("msg","plse try again something is wrong");
		   mv.setViewName("UpdateAdminPassword");
	   }
		
		
		return mv;
	}
	
	//get validate otp for admin forget password
	@RequestMapping("/getValidateOtpForfpass")
	public ModelAndView getValidateOtpForfpass(@RequestParam("otp")String otp,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		String adminotp=(String)session.getAttribute("adminotp");
		if(adminotp.equals(otp))
		{
			mv.setViewName("UpdateAdminPassword");
		}
		else
		{
			mv.addObject("otpmsg","pls enter valid otp");
			mv.setViewName("AdminGetOtpForfpass");
		}
		return mv;
	}
	
	
	//validate admin username and email and send otp for forget passowrd
	@RequestMapping("/validAdminEmailUname")
	public ModelAndView getValidEmailUname(@RequestParam("email")String email,@RequestParam("uname")String uname,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		Validation v=new Validation();
		v.setEmail(email);
		v.setUsername(uname);
		int count=vd.getValidAdminEmailUname(v);
		if(count>0)
		{
			String otp=vd.getOtp();
	      	  session.setAttribute("adminotp",otp);
	      	  EmailGenerate eg=new EmailGenerate();
	      	  eg.setReciption(email);
	      	  eg.setSubject("Regarding otp");
	      	  eg.setMessage("your otp for forget password is  :  "+otp);
	             egd.sendEmail(eg);
		}
		else
		{
			mv.addObject("msg","Plese enter valid user name and email id .. ");
		}
		mv.setViewName("AdminGetOtpForfpass");
		return mv;
	}
		
	
	//Admin Registration======================
	@RequestMapping("/AdminRegistration")
	public ModelAndView adminRegistration(@RequestParam("uname")String uname,@RequestParam("pass")String pass,@RequestParam("email")String email)
	{
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		a.setUsername(uname);
		a.setPassword(pass);
		a.setEmail(email);
		int count=admin.insertAdmin(a);
		if(count>0)
		{
			mv.addObject("rmsg","your account is succefully created");
			mv.setViewName("AdminLogin");
		}
		else
		{
			mv.addObject("msg","Sorry somthing is wrong pls try agian");
			mv.setViewName("AdminRegistration");
		}
		return mv;
	}
	
	//validate admin otp for registration====
	@RequestMapping("/validateAdminOtpRegistration")
   public ModelAndView getvalidateOtp(HttpSession session,@RequestParam("otp")String otp)
   {
		ModelAndView mv=new ModelAndView();
		session.setAttribute("auotp",otp);
		String sotp=(String)session.getAttribute("aotp");
		if(sotp.equals(otp))
		{
			mv.setViewName("AdminRegistration");
		}
		else
		{
			mv.addObject("msg","plse enter valid otp");
		    mv.setViewName("OtpValidationAdminRegistration");
		}
		return mv;
   }
	
	//==============get otp for new admin registration=====
	@RequestMapping("/getOtpForAdminRegisration")
	public ModelAndView getOtp(HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		EmailGenerate eg=new EmailGenerate();
		String otp=vd.getOtp();
		session.setAttribute("aotp",otp);
		eg.setReciption("workportalteam@gmail.com");
		eg.setMessage("yoru otp is  : "+otp);
		eg.setSubject("regarding otp");
		egd.sendEmail(eg);
		mv.setViewName("OtpValidationAdminRegistration");
		return mv;
	}
	
	
	
	//==========get service provider list===============================

	@RequestMapping("/getServiceProvider")
	public ModelAndView getServiceProvider()
	{
		ModelAndView mv=new ModelAndView();
	     List<ServiceProvider> list=spd.getServiceProvider();
		  mv.addObject("list",list);
		  mv.setViewName("SeviceProviderView");
	     return mv;
	}
	
	//==============get service provider images=====================================
	
	@RequestMapping("/getSPimgae")
	public void getSpImage(@RequestParam("id")int id,HttpServletResponse response ) throws SQLException, IOException
	{
		response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());

	}
	
	//============get service provider Adhar card image ==================================
	@RequestMapping("/getSpAdharImage")
	public void getSpAdharImage(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	{
		response.setContentType("image/jpeg/jpg");
		Blob spadhar=spd.getSpAdharImage(id);
		byte[] bytes=spadhar.getBytes(1,(int)spadhar.length());
		InputStream inputstream=new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());
	}
	//=========get service provider licence image===============================================
	
	   @RequestMapping("/getSplicence")
	   public void getSpLicence(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	   {
		   response.setContentType("image/jpeg/jpg");
		   Blob licence=spd.getSpLicence(id);
		   byte[] bytes=licence.getBytes(1,(int)licence.length());
		   InputStream inputstream=new ByteArrayInputStream(bytes);
			IOUtils.copy(inputstream, response.getOutputStream());
	   }
	   
	//=============get service provider qualification image======================================
	
	   @RequestMapping("/getSpQualificationImg")
	   public void getSpQualificationImag(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	   {
		   response.setContentType("image/jpeg/jpg");
	          Blob qimage=spd.getSpQualificationImg(id);	
	          byte[] bytes=qimage.getBytes(1,(int)qimage.length());
	          InputStream inputstream=new ByteArrayInputStream(bytes);
				IOUtils.copy(inputstream, response.getOutputStream());
	   } 
	   
	//==========get service provider  list of registration request=================================================
	
	@RequestMapping("/spregistration_request")
	public ModelAndView getSPreqeust() {
		ModelAndView mv = new ModelAndView();
		List<ServiceProvider> list = spd.getList();
		mv.addObject("list", list);
		mv.setViewName("ServiceProviderRqeustViwe");
		return mv;
	}

	//=======get service provider  image of registration request=============================
	
	@RequestMapping("/getSPImage_req")
	public void getSPimageRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws IOException, SQLException {
	
		response.setContentType("image/jpeg/jpg");
		Blob image = spd.getspRequestImage(id);

		byte[] bytes;

		bytes = image.getBytes(1, (int) image.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());
		
	}


	//===============get service provider licence image for registration reqeust
	@RequestMapping("/getSplicence_req")
	public void getSpLicenceRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob licence = spd.getspReqeustlicence(id);
		response.setContentType("image/jpeg/jpg");
		byte[] bytes = licence.getBytes(1, (int) licence.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());

	}

	//==========get service provider adhar image for registration reqeust========
	@RequestMapping("/getSpAdharImage_req")
	public void getSpAdharimageRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob adharimg = spd.getspRequestAddarImage(id);
		response.setContentType("image/jpeg/jpg");
		byte[] bytes = adharimg.getBytes(1, (int) adharimg.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());

	}
	

	//==========get service provider qualification images of registration request================

	 @RequestMapping("/getSpQualification_req")
	 public void getSpcQualificationRequest(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	 {
		 Blob qualification=spd.getspRequestQcertificate(id);
		 
		 response.setContentType("image/jpeg/jpg");
		 byte[] bytes=qualification.getBytes(1,(int)qualification.length());
		 InputStream inputstream=new ByteArrayInputStream(bytes);
		 IOUtils.copy(inputstream, response.getOutputStream());
	 }
	 
	 //========reject service provider registration request====================================
	 @RequestMapping("/RejectServiceProvider")
	 public ModelAndView rejectServiceProvider(@RequestParam("id")int id,@RequestParam("mail")String rmail)
	 {
		 ModelAndView mv=new ModelAndView();
		 int count=spd.rejectServiceProvider(id);
		 if(count>0)
		 {
			 EmailGenerate eg=new EmailGenerate();
			 eg.setReciption(rmail);
			 eg.setSubject("regarding service hub verification");
			 eg.setMessage("Sorry in your document verification process we got some fault.plse apply agin with valid douments..");
		     egd.sendEmail(eg);
		 }
		 
		 mv.setViewName("redirect:/spregistration_request");
		 return mv;
	 }
	 
	 //===========get all user list      =================
	 @RequestMapping("/getAllusers")
	  public ModelAndView getAlluser()
	  {
		  ModelAndView mv=new ModelAndView();
	           List<User> list=ud.getUsers();
		        mv.addObject("list",list);
		        mv.setViewName("Alluser");
	           
	           return mv;
		  
	  }
	 
	 //======delete the user ======
	 @RequestMapping("/deleteUser")
	 public ModelAndView deleteUser(@RequestParam("id")int id)
	 {
		 ModelAndView mv=new ModelAndView();
		 ud.deletUser(id);
		 mv.setViewName("redirect:/getAllusers");
		 return mv;
	 }
	 
	 //=========Accept service provider registration request====

    @RequestMapping("/acceptSpRequesta")
    public ModelAndView acceptSpRequest(@RequestParam("id")int id,@RequestParam("mail")String rmail)
    {
    	ModelAndView mv=new ModelAndView();
    	int count=spd.acceptSpRequest(id);
    	if(count>0)
    	{
    		EmailGenerate eg=new EmailGenerate();
    		eg.setReciption(rmail);
    		eg.setSubject("related to service hub registration");
    		eg.setMessage("your verification is succeffully complited.Well come to the service Hub family...");
    	  egd.sendEmail(eg);
    	}
    	mv.setViewName("redirect:/spregistration_request");
    	return mv;
    }
    //==========add designation for the user=====
    @RequestMapping("/addDesignation")
    public ModelAndView addSpDesignation(@RequestParam("designation")String designation)
    {
    	ModelAndView mv=new ModelAndView();
       Designation d=new Designation();
       d.setDesignation(designation);
    int count= dd.addDesignation(d);
      if(count>0)
      {
    	  mv.addObject("msg","successfully insert");
      }
      else
      {
    	  mv.addObject("msg","insertion failed");
      }
      mv.setViewName("AddDesignation");
    	return mv;
    }
    
    //========after adding designation show the registration page for service provider
    @RequestMapping("/Seviceprovider")
    public ModelAndView getDesignation()
    {
    	ModelAndView mv=new ModelAndView();
    	List<Designation> designation=dd.getDesignation();
    	mv.addObject("des",designation );
    	mv.setViewName("ServiceProviderRegistration");
    	return mv;
    }
    
    //======delete service provider in admin section
    @RequestMapping("/deleteSp")
    public ModelAndView deleteSp(@RequestParam("id")int id)
    {
    	ModelAndView mv=new ModelAndView();
    	spd.deleteSrviceProvider(id);
    	mv.setViewName("redirect:/getServiceProvider");
    	return mv;
    }
    
    //=======Admin login validation 
     @RequestMapping("/adminLoginValidation")
     public ModelAndView getAdminValidation(HttpSession session,@RequestParam("uname")String uname,@RequestParam("pwd")String password)
     {
    	 ModelAndView mv=new ModelAndView();
    	 Validation v=new Validation();
    	 v.setUsername(uname);
    	 v.setPassword(password);
    	 int count=vd.adminValidation(v);
    	 if(count>0)
    	 {
    		 session.setAttribute("auname",uname);
    		 mv.setViewName("AdminHome");
    	 }
    	 else
    	 {
    		 mv.addObject("msg","Enter valid user name and password");
    		 mv.setViewName("AdminLogin");
    	 }
    	 return mv;		 
     }
                                     
    
}
