package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.ServiceProviderDao;
import daointerfaceses.ValidationDao;
import pojoclasses.ServiceProvider;
import pojoclasses.Validation;

@Controller
public class ServiceProviderController {

	@Autowired
	ServiceProviderDao spd;
	
	@Autowired
	ValidationDao vd;
	
	@RequestMapping(value = "/ServiceProviderRegistration", method = RequestMethod.POST)
	public ModelAndView getvew(HttpServletRequest request, @RequestParam("photo") MultipartFile photo,
			@RequestParam("qualification") MultipartFile qcertificate, @RequestParam("licence") MultipartFile licence,
			@RequestParam("adhard") MultipartFile adharimg) {
		ModelAndView mv = new ModelAndView();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mob_number = request.getParameter("mob");
		String mail = request.getParameter("email");
		String adhar_number = request.getParameter("addarn");
		String designation = request.getParameter("design");
		String gender = request.getParameter("gender");
		String date_of_birth = request.getParameter("date");
		String specialization = request.getParameter("specialization");
		String address = request.getParameter("adrress");
		String city = request.getParameter("city");
		String tahsil = request.getParameter("tahsil");
		String district = request.getParameter("dist");
		String state = request.getParameter("state");
		String qualification = request.getParameter("hqualification");
		String univercity = request.getParameter("univercity");
		String experiance = request.getParameter("experiance");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		
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
			mv.addObject("msg","successfully insertion");
		}
		else
		{
			mv.addObject("msg","failed insertion");
		}
		mv.setViewName("ServiceProviderRegistration");
		return mv;
	}
    //=========================================================================
 @RequestMapping("/ServiceProviderLogin")
 public ModelAndView validServiceProvider(@RequestParam("uname")String uname,@RequestParam("pwd")String pass)
 {
	 ModelAndView mv=new ModelAndView();
	 Validation v=new Validation();
	 v.setUsername(pass);
	 v.setPassword(uname);
	 int a= vd.serviceProviderValidation(v);
	 if(a>0)
	 {
		 mv.setViewName("ServiceProviderHome");
	 }
	 else
	 {
		 mv.addObject("msg","plase enter valid username and password");
		 mv.setViewName("SeviceProviderLogin");
	 }
	 return mv;
 }
	 
 
	

}
