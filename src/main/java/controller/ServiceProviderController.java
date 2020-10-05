package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceProviderController {

	@RequestMapping(value="/ServiceProviderRegistration",method=RequestMethod.POST)
	public ModelAndView getvew(@RequestParam("fname")String fname,@RequestParam("photo")MultipartFile photo)
	{
		ModelAndView mv=new ModelAndView();
		System.out.println(fname);
		System.out.println(photo);
		mv.setViewName("ServiceProviderRegistration");
		return mv;
	}
	
}
