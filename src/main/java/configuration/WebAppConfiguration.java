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

import daointerfaceses.AdminDao;
import daointerfaceses.DesignationDao;
import daointerfaceses.EmailGenarateDao;
import daointerfaceses.ServiceProviderDao;
import daointerfaceses.UserDao;
import daointerfaceses.ValidationDao;
import pojoclasses.Admin;
import seviceclasses.AdminDaoImplementation;
import seviceclasses.DesignationDaoImplementation;
import seviceclasses.EmailGenarateDaoImplementation;
import seviceclasses.ServiceProviderDaoImplementation;
import seviceclasses.UserDaoImplementation;
import seviceclasses.ValidationDaoImplement;


@Configuration
@EnableWebMvc
@ComponentScan({"configuration","controller","daointerfaceses","serviceclasses","pojoclasses"})
public class WebAppConfiguration extends WebMvcConfigurerAdapter
{
	
	//========= Internal Resource view resolver bean for views===================
	@Bean
	public InternalResourceViewResolver getView()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	//======= get data souce bean for database connection   ==================
	
	@Bean
	 public DriverManagerDataSource getDataSource()
	 {
		 DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/service_hub");
		 ds.setUsername("root");
		 ds.setPassword("Mauli@1997");
		 
		 return ds;
	 }
	
//============Multipart resolver bean for using multipart files or photo==========================
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	
	}

//=============get autowired user dao interface=======================
	
	@Bean
	public UserDao getUserDao()
	{
		UserDao ud=new UserDaoImplementation(getDataSource());
		return ud;
	}
	
//=========== get autowired service provider dao=============================	
	@Bean
	public ServiceProviderDao getServiceProviderDao()
	{
		ServiceProviderDao spd=new ServiceProviderDaoImplementation(getDataSource());
		return spd;
	}
//============get autowired designation dao      =============================
    @Bean
	public DesignationDao getDesignationdao()
	{
		DesignationDao da=new DesignationDaoImplementation(getDataSource());
		return da;
	}
	
	//==========configure this bean for  adding static resoureces in project=============
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		super.addResourceHandlers(registry);
		}
//==============autowired emailgenaratie dao class for send mail=====================
	@Bean
	public EmailGenarateDao sendEmail()
	{
	  return new EmailGenarateDaoImplementation();
	}
//===========get autowired for all login validations       =====================
@Bean
 public ValidationDao getVaidation()
 {
	 ValidationDao vd=new ValidationDaoImplement(getDataSource());
	 return vd;
 }
//==========get Autowired for admin dao

 @Bean
  public AdminDao getAdminDao()
  {
	  AdminDao ad=new AdminDaoImplementation(getDataSource());
	  return ad;
  }


}
