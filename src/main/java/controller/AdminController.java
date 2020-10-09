package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import daointerfaceses.DesignationDao;
import daointerfaceses.EmailGenarateDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import pojoclasses.Designation;
import pojoclasses.EmailGenerate;
import pojoclasses.ServiceProvider;
import pojoclasses.User;

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
	//================================================================

	@RequestMapping("/getServiceProvider")
	public ModelAndView getServiceProvider()
	{
		ModelAndView mv=new ModelAndView();
	     List<ServiceProvider> list=spd.getServiceProvider();
		  mv.addObject("list",list);
		  mv.setViewName("SeviceProviderView");
	     return mv;
	}
	
	@RequestMapping("/getSPimgae")
	public void getSpImage(@RequestParam("id")int id,HttpServletResponse response ) throws SQLException, IOException
	{
		response.setContentType("image/jpeg/jpg"); 
		Blob image=spd.getSpImage(id);
		byte[] photo=image.getBytes(1,(int)image.length());
		InputStream inputstream=new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());

	}
	//==============================================================================
	@RequestMapping("/getSpAdharImage")
	public void getSpAdharImage(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	{
		response.setContentType("image/jpeg/jpg");
		Blob spadhar=spd.getSpAdharImage(id);
		byte[] bytes=spadhar.getBytes(1,(int)spadhar.length());
		InputStream inputstream=new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());
	}
	//==============================================================================
	
	   @RequestMapping("/getSplicence")
	   public void getSpLicence(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	   {
		   response.setContentType("image/jpeg/jpg");
		   Blob licence=spd.getSpLicence(id);
		   byte[] bytes=licence.getBytes(1,(int)licence.length());
		   InputStream inputstream=new ByteArrayInputStream(bytes);
			IOUtils.copy(inputstream, response.getOutputStream());
	   }
	   
	//=============================================================================
	
	   @RequestMapping("/getSpQualificationImg")
	   public void getSpQualificationImag(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	   {
		   response.setContentType("image/jpeg/jpg");
	          Blob qimage=spd.getSpQualificationImg(id);	
	          byte[] bytes=qimage.getBytes(1,(int)qimage.length());
	          InputStream inputstream=new ByteArrayInputStream(bytes);
				IOUtils.copy(inputstream, response.getOutputStream());
	   } 
	   
	//=============================================================
	
	@RequestMapping("/spregistration_request")
	public ModelAndView getSPreqeust() {
		ModelAndView mv = new ModelAndView();
		List<ServiceProvider> list = spd.getList();
		mv.addObject("list", list);
		mv.setViewName("ServiceProviderRqeustViwe");
		return mv;
	}

	//=======================================================================
	
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


	//===========================================================================
	@RequestMapping("/getSplicence_req")
	public void getSpLicenceRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob licence = spd.getspReqeustlicence(id);
		response.setContentType("image/jpeg/jpg");
		byte[] bytes = licence.getBytes(1, (int) licence.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());

	}

	//===============================================================================
	@RequestMapping("/getSpAdharImage_req")
	public void getSpAdharimageRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob adharimg = spd.getspRequestAddarImage(id);
		response.setContentType("image/jpeg/jpg");
		byte[] bytes = adharimg.getBytes(1, (int) adharimg.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());

	}
	

	//==========================================================================================

	 @RequestMapping("/getSpQualification_req")
	 public void getSpcQualificationRequest(@RequestParam("id")int id,HttpServletResponse response) throws SQLException, IOException
	 {
		 Blob qualification=spd.getspRequestQcertificate(id);
		 
		 response.setContentType("image/jpeg/jpg");
		 byte[] bytes=qualification.getBytes(1,(int)qualification.length());
		 InputStream inputstream=new ByteArrayInputStream(bytes);
		 IOUtils.copy(inputstream, response.getOutputStream());
	 }
	 
	 //==========================================================================================
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
	 
	 //=============================================================================================
	 @RequestMapping("/getAllusers")
	  public ModelAndView getAlluser()
	  {
		  ModelAndView mv=new ModelAndView();
	           List<User> list=ud.getUsers();
		        mv.addObject("list",list);
		        mv.setViewName("Alluser");
	           
	           return mv;
		  
	  }
	 
	 //=================================================================================================
	 @RequestMapping("/deleteUser")
	 public ModelAndView deleteUser(@RequestParam("id")int id)
	 {
		 ModelAndView mv=new ModelAndView();
		 ud.deletUser(id);
		 mv.setViewName("redirect:/getAllusers");
		 return mv;
	 }
	 
	 //================================================================================================

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
    //==========================================================================================
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
    
    //=======================================================
    @RequestMapping("/Seviceprovider")
    public ModelAndView getDesignation()
    {
    	ModelAndView mv=new ModelAndView();
    	List<Designation> designation=dd.getDesignation();
    	mv.addObject("des",designation );
    	mv.setViewName("ServiceProviderRegistration");
    	return mv;
    }
    
    //============================================================================
    @RequestMapping("/deleteSp")
    public ModelAndView deleteSp(@RequestParam("id")int id)
    {
    	ModelAndView mv=new ModelAndView();
    	spd.deleteSrviceProvider(id);
    	mv.setViewName("redirect:/getServiceProvider");
    	return mv;
    }
    
    //========================================================================
     
}
