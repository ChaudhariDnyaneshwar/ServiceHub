package configurationApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.Dao;
import service.pojo;

@Controller
public class controller {

	@Autowired
	Dao da; 
	
	@RequestMapping(value="/demo",method=RequestMethod.POST)
	public ModelAndView get(@RequestParam("roll")String roll,@RequestParam("name")String name,@RequestParam("photo")MultipartFile image)
	{
		ModelAndView mv=new ModelAndView();
		System.out.println(roll);
		System.out.println(name);
	  System.out.println("its done....");
	  
	  pojo po=new pojo();
	  po.setRoll(roll);
	  po.setName(name);
	  po.setPhoto(image);
	int a=  da.save(po);
	if(a>0)
	{
		mv.addObject("msg","successfully done...");
		
	}
	else
	{
		mv.addObject("msg","failed plase try again");
	}
	mv.setViewName("first");
		return mv;
		
	}
	
	@RequestMapping("ddd")
	public ModelAndView dks()
	{
		ModelAndView mv=new ModelAndView();
		System.out.println("this is done");
		mv.setViewName("userregistration");
		return mv;
	}
}
