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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.AdminDao;
import daointerfaceses.EmailGenarateDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.ValidationDao;
import pojoclasses.EmailGenerate;
import pojoclasses.Feedback;
import pojoclasses.ServiceProvider;
import pojoclasses.User;
import pojoclasses.Validation;

@Controller
public class ServiceProviderController {

	@Autowired
	ServiceProviderDao spd;
	
	@Autowired
	ValidationDao vd;

	@Autowired
	EmailGenarateDao egd;
    
	@Autowired
	 AdminDao admin;
	
	
	//=======get service provider profile=====
	
     @RequestMapping("/getSpProfile")
     public ModelAndView getSpProfile(HttpSession session)
     {
    	 System.out.println("its here");
    	 ModelAndView mv=new ModelAndView();
    	String uname=(String)session.getAttribute("sp_uname");
    	ServiceProvider sp=new ServiceProvider();
    	sp.setUser_name(uname);
    	List<ServiceProvider> list=spd.getSpProfile(sp);
    	mv.addObject("list",list);
    	mv.setViewName("ServiceProviderProfite");
    	return mv;
     }
	//====get image of service provider for profile===
     @RequestMapping("/getImageSpProfile")
     public void getSpImageProfile(HttpServletResponse response,HttpSession session) throws SQLException, IOException
     {
    	 System.out.println("its there");
    	 String uname=(String)session.getAttribute("sp_uname");
    	 ServiceProvider s=new ServiceProvider();
    	 s.setUser_name(uname);
    	 response.setContentType("image/jpeg/jpg"); 
 		Blob image=spd.getSpImageProfile(s);
 		byte[] photo=image.getBytes(1,(int)image.length());
 		InputStream inputstream=new ByteArrayInputStream(photo);
 		IOUtils.copy(inputstream, response.getOutputStream());
     }
     
	//======================  service provider logout /end login session
	  
	   @RequestMapping("/serviceProviderLogout")
	   public ModelAndView spLogout(HttpSession session)
	   {
		   ModelAndView mv=new ModelAndView();
		   session.removeAttribute("sp_uname");
	    	session.invalidate();
		   mv.setViewName("SeviceProviderLogin");
		   return mv;
	   }
	
	//=========================update password===============================
	@RequestMapping("/UpdateSpPassword")
	public ModelAndView updateSpPassword(@RequestParam("uname")String uname,@RequestParam("pass")String password)
	{
		ModelAndView mv=new ModelAndView();
		ServiceProvider sp=new ServiceProvider();
		sp.setUser_name(uname);
		sp.setPssword(password);
		int count=spd.updateSpPassword(sp);
		if(count>0)
		{
			mv.addObject("msg","your password is updated successfully..");
		}
		else
		{
			mv.addObject("msg","Sorry,your password updation is faield.");
		}
		return mv;
	}
	
	
	//validate the otp of service provider for update password when sp forget password
	@RequestMapping("/validSpOtp")
	public ModelAndView validateSpOtp(@RequestParam("otp")String otp,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		session.setAttribute("spuotp", otp);
		String spotp=(String)session.getAttribute("spotp");
		if(spotp.equals(otp))
		  {
			  mv.setViewName("UpdateSpPassword");
		  }
		  else
		  {
		  mv.addObject("otpmsg","plase enter valid otp");
		  mv.setViewName("SpGetOtpForFpass");
		  }
		return mv;
	}
	
	
	// validate service provider email id and username and send otp mail 
	@RequestMapping("/validSpForfpass")
	public ModelAndView getValidateSpEmailUname(@RequestParam("uname")String uname,@RequestParam("email")String email,HttpSession session)
	{
		
		ModelAndView mv=new ModelAndView();
		Validation v=new Validation();
		v.setUsername(uname);
		v.setEmail(email);
		int count=vd.getValidSpEmailUname(v);
		
		if(count>0)
		{
			String otp=vd.getOtp();
      	  session.setAttribute("spotp",otp);
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
		mv.setViewName("SpGetOtpForFpass");
		return mv;
	}
	
	//====================service provider login validation and maintain session
	
	 @RequestMapping("/ServiceProviderLogin")
	 public ModelAndView validServiceProvider(@RequestParam("uname")String uname,@RequestParam("pwd")String pass,HttpSession session)
	 {
		 ModelAndView mv=new ModelAndView();
		 Validation v=new Validation();
		 v.setUsername(uname);
		 v.setPassword(pass);
		 int a= vd.serviceProviderValidation(v);
		 if(a>0)
		 {
			 session.setAttribute("sp_uname",uname);
			 mv.setViewName("ServiceProviderHome");
		 }
		 else
		 {
			 mv.addObject("msg","plase enter valid username and password");
			 mv.setViewName("SeviceProviderLogin");
		 }
		 return mv;
	 }
		 

	//============get client appointment list
	 
	 @RequestMapping("/getClient")
	 public ModelAndView getClient(@RequestParam("sp_uname")String uname)
	 {
		 ModelAndView mv=new ModelAndView();
		 System.out.println(uname);
		   List<User> list=spd.getClient(uname);
		   System.out.println();
		   mv.addObject("list",list);
		 mv.setViewName("ClientForSp");
		 return mv;
	 }
	 
	 //======send service provider request for registration...
	
	
	@RequestMapping(value = "/ServiceProviderRegistration", method = RequestMethod.POST)
	public ModelAndView getvew(HttpServletRequest request, @RequestParam("photo") MultipartFile photo,
			@RequestParam("qualification") MultipartFile qcertificate, @RequestParam("licence") MultipartFile licence,
			@RequestParam("adhard") MultipartFile adharimg) {
		ModelAndView mv = new ModelAndView();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mob_number = request.getParameter("mob");
		String mail = request.getParameter("email");
		String adhar_number = request.getParameter("adhar");
		String designation = request.getParameter("design");
		String gender = request.getParameter("gender");
		String date_of_birth = request.getParameter("date");
		String specialization = request.getParameter("specialization");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String tahsil = request.getParameter("taluka");
		String district = request.getParameter("dist");
		String state = request.getParameter("state");
		String qualification = request.getParameter("hqualification");
		String univercity = request.getParameter("univercity");
		String experiance = request.getParameter("experiance");
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
	
		
		ServiceProvider sp=new ServiceProvider();
		sp.setFname(fname);
		sp.setLname(lname);
		sp.setMob_number(mob_number);
		sp.setEmail(mail);
		sp.setAddar_number(adhar_number);
		sp.setGender(gender);
		sp.setDateofbirth(date_of_birth);
		sp.setSpecialization(specialization);
        sp.setOffice_address(address);		
		sp.setCity(city);
		sp.setTahsil(tahsil);
		sp.setDistrict(district);
		sp.setState(state);
		sp.setHigh_qualification(qualification);
		sp.setUniversity_name(univercity);
		sp.setExperiance(experiance);
		sp.setQualification_certificate(qcertificate);
		sp.setLicence_certificate(licence);
		sp.setPhoto(photo);
		sp.setAddar_image(adharimg);
		sp.setUser_name(username);
		sp.setPssword(password);
		sp.setDesignation(designation);
		int a=spd.save(sp);
		if(a>0)
		{
			mv.addObject("rmsg","your registration reqeust is sucessfully done..");
			EmailGenerate eg=new EmailGenerate();
			eg.setMessage("your registration request process is done. you will get within 2 days response from Service Hub. your user name is : "+username+"  and password is  : "+password);
			eg.setSubject("Related to service provider registration request..");
			eg.setReciption(mail);
			egd.sendEmail(eg);
			
		}
		else
		{
		mv.addObject("rmsg","your reqeust is field..");
		}
		mv.setViewName("SeviceProviderLogin");
		return mv;
	}
    
	
	//=========================================================================
 
	

}
