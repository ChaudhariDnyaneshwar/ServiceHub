package configuration;

import org.apache.tomcat.util.buf.UDecoder;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import daointerfaceses.DesignationDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import seviceclasses.DesignationDaoImplementation;
import seviceclasses.ServiceProviderDaoImplementation;
import seviceclasses.UserDaoImplementation;


@Configuration
@EnableWebMvc
@ComponentScan({"configuration","controller","daointerfaceses","serviceclasses","pojoclasses"})
public class WebAppConfiguration extends WebMvcConfigurerAdapter
{
	
	//========================================================================================
	@Bean
	public InternalResourceViewResolver getView()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	//==========================================================================================
	
	@Bean
	 public DriverManagerDataSource getDataSource()
	 {
		 DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/workportal");
		 ds.setUsername("root");
		 ds.setPassword("Mauli@1997");
		 System.out.println("databse done..");
		 return ds;
	 }
	
//===========================================================================================
	
	@Bean
	public MultipartResolver multipartResolver() {
		System.out.println("this is also done");
		return new CommonsMultipartResolver();
	
	}

//=============================================================================================
	
	@Bean
	public UserDao getUserDao()
	{
		UserDao ud=new UserDaoImplementation(getDataSource());
		return ud;
	}
	
//==============================================================================================	
	@Bean
	public ServiceProviderDao getServiceProviderDao()
	{
		ServiceProviderDao spd=new ServiceProviderDaoImplementation(getDataSource());
		return spd;
	}
//=================================================================================
    @Bean
	public DesignationDao getDesignationdao()
	{
		DesignationDao da=new DesignationDaoImplementation(getDataSource());
		return da;
	}
	
	//==========================================================================
	// adding static resources in project
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		super.addResourceHandlers(registry);
		}
//===================================================================================

}
