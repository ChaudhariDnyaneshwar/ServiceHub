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

import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import pojoclasses.ServiceProvider;
import pojoclasses.User;

@Controller
public class AdminController {
    
	@Autowired
    UserDao ud;
	
	@Autowired
	ServiceProviderDao spd;

	//================================================================
	
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
	public void getSpLicence(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob licence = spd.getspReqeustlicence(id);
		response.setContentType("image/jpeg/jpg");
		byte[] bytes = licence.getBytes(1, (int) licence.length());
		InputStream inputstream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputstream, response.getOutputStream());

	}

	//===============================================================================
	@RequestMapping("/getSpAdharImage_req")
	public void getSpAdharimage(@RequestParam("id") int id, HttpServletResponse response)
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
	 public ModelAndView rejectServiceProvider(@RequestParam("id")int id)
	 {
		 ModelAndView mv=new ModelAndView();
		 spd.rejectServiceProvider(id);
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
}
