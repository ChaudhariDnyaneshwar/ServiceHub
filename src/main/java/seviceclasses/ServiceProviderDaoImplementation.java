package seviceclasses;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import daointerfaceses.ServiceProviderDao;
import pojoclasses.ServiceProvider;
import pojoclasses.User;

@Service
public class ServiceProviderDaoImplementation implements ServiceProviderDao {

	// getting data source for database...
	
	JdbcTemplate jdbctemp;
	public ServiceProviderDaoImplementation(DataSource ds) {
		super();
		this.jdbctemp =new JdbcTemplate(ds);
	}

//=======insert the service provider registration request into the database..
	public int save(ServiceProvider p) {
		
		int a=0;
		try {
			
	        //byte[] qualificatio1n_certificate=p.getHigh_qualification().getBytes();
	        byte[] qualification_certificate= p.getQualification_certificate().getBytes();
	        byte[] licence=p.getLicence_certificate().getBytes();
	        byte[] photo=p.getPhoto().getBytes();
	        byte[] adhar_image=p.getAddar_image().getBytes();
	
			String query="insert into sp_request values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			  
			   
			a=jdbctemp.update(query,new Object[]{null,p.getUser_name(),p.getPssword(),p.getFname(),p.getLname(),p.getMob_number(),p.getEmail(),p.getAddar_number(),p.getGender(),p.getDateofbirth(),p.getSpecialization(),p.getOffice_address(),p.getCity(),p.getTahsil(),p.getDistrict(),p.getState(),p.getHigh_qualification(),p.getUniversity_name(),p.getExperiance(),p.getDesignation(),photo,adhar_image,licence,qualification_certificate});
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
			return a;
	}

	//=====get list of the service provider from data base.
	public List<ServiceProvider> getServiceProvider() {
	  
		RowMapper<ServiceProvider> rowMapper=new RowMapper<ServiceProvider>() {

			public ServiceProvider mapRow(ResultSet request, int arg1) throws SQLException {
				
				ServiceProvider sp=new ServiceProvider();

				
				sp.setSp_id(request.getInt("spId"));
				sp.setFname(request.getString("fname"));
				sp.setLname(request.getString("lname"));
				sp.setMob_number(request.getString("mob_number"));
				sp.setEmail(request.getString("email"));
				sp.setAddar_number(request.getString("adhar_number"));
				sp.setGender(request.getString("gender"));
				sp.setDateofbirth(request.getString("date_of_birth"));
				sp.setSpecialization(request.getString("specialization"));
				sp.setOffice_address(request.getString("address"));
				sp.setCity(request.getString("city"));
				sp.setTahsil(request.getString("tahsil"));
				sp.setDistrict(request.getString("district"));
				sp.setState(request.getString("state"));
				sp.setHigh_qualification(request.getString("qualification"));
				sp.setExperiance(request.getString("experiance"));
				sp.setDesignation(request.getString("designation"));
				sp.setUser_name(request.getString("user_name"));
				return sp;
			}
		};
		List<ServiceProvider> list=jdbctemp.query("select * from sp_final", rowMapper);
		return list;
     	}

	//====get service provider image list from database..
	
	public Blob getSpImage(int id) {
		
		
String query="select photo from sp_final where spId=?";
		
		Blob photo=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		return photo;
	}
   
	//=====get service provider adhar card image from database..
	
	public Blob getSpAdharImage(int id) {
		
		 String query="select adhar_img from sp_final where spId=?";
			
			Blob adhar=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return adhar;
	}

  //===get service provider licence photo from database..
	public Blob getSpLicence(int id) {
	    
         String query="select licence from sp_final where spId=?";
		
		Blob licence=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		
		return licence;
	}
//=====get service provider qualification images from database....
	public Blob getSpQualificationImg(int id) {
		String query="select qualification_img from sp_final where spId=?";
		Blob qualification=jdbctemp.queryForObject(query, new Object[]{id},Blob.class);
		return qualification;
	}

	//=====get the list of service provider registration  request list

	public List<ServiceProvider> getList() 
	{
		RowMapper<ServiceProvider> rowMapper=new RowMapper<ServiceProvider>()
		{

			public ServiceProvider mapRow(ResultSet request, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				ServiceProvider sp=new ServiceProvider();
				sp.setSp_id(request.getInt("spId"));
				sp.setFname(request.getString("fname"));
				sp.setLname(request.getString("lname"));
				sp.setMob_number(request.getString("mob_number"));
				sp.setEmail(request.getString("email"));
				sp.setAddar_number(request.getString("adhar_number"));
				sp.setGender(request.getString("gender"));
				sp.setDateofbirth(request.getString("date_of_birth"));
				sp.setSpecialization(request.getString("specialization"));
				sp.setOffice_address(request.getString("address"));
				sp.setCity(request.getString("city"));
				sp.setTahsil(request.getString("tahsil"));
				sp.setDistrict(request.getString("district"));
				sp.setState(request.getString("state"));
				sp.setHigh_qualification(request.getString("qualification"));
				sp.setExperiance(request.getString("experiance"));
				sp.setDesignation(request.getString("designation"));
				
				return sp;
			}
		};
List<ServiceProvider>	list=	jdbctemp.query("select * from sp_request",rowMapper);  
		return list;
	}


	//==get service provider registration request image from database..
	public Blob getspRequestImage(int id) {
		String query="select photo from sp_request where spId=?";
		
		Blob photo=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		return photo;
	}

	//==get service provider registartion request licence image from database...

	public Blob getspReqeustlicence(int id) {
		// TODO Auto-generated method stub
         String query="select licence from sp_request where spId=?";
		
		Blob licence=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return licence;
	}

	//==============get service provider registration request adhar card image from database..

	public Blob getspRequestAddarImage(int id) {
		// TODO Auto-generated method stub
 String query="select adhar_img from sp_request where spId=?";
		
		Blob adhar=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return adhar;
	}

 //======get service provider registration request qualification certificate.....
	
	public Blob getspRequestQcertificate(int id) {
		String query="select qualification_img from sp_request where spId=?";
		Blob qualification=jdbctemp.queryForObject(query, new Object[]{id},Blob.class);
		return qualification;
	}

//===Reject service provider registration request from admin...
	
	public int rejectServiceProvider(int id) {
		// TODO Auto-generated method stub
		String query="delete from sp_request where spId=?";
		return jdbctemp.update(query,id);
	}

	//===Accept Service provider registration request  from admin... 
	public int acceptSpRequest(int id) {

		String query="insert sp_final select * from sp_request where spId=?";
		int count=jdbctemp.update(query,id);
		String dquery="delete from sp_request where spId=?";
		jdbctemp.update(dquery,id);
		return count;
	}

	
	//=== delete service provider from database to through admin
  
	public int deleteSrviceProvider(int id) {
		String query="delete from sp_final where spId=?";
		return jdbctemp.update(query,id);
	}
	
	//==get designation related service provider for user...

	public List<ServiceProvider> getDrelatedSp(String designation) {
		 String qu="select * from sp_final where designation=?";
		 
		 RowMapper<ServiceProvider> rowMapper=new RowMapper<ServiceProvider>() {

			public ServiceProvider mapRow(ResultSet request, int arg1) throws SQLException {
		  		     ServiceProvider sp=new ServiceProvider();
				     sp.setSp_id(request.getInt("spId"));
						sp.setFname(request.getString("fname"));
						sp.setLname(request.getString("lname"));
						sp.setMob_number(request.getString("mob_number"));
						sp.setEmail(request.getString("email"));
						sp.setSpecialization(request.getString("specialization"));
						sp.setOffice_address(request.getString("address"));
						sp.setDistrict(request.getString("district"));
						sp.setHigh_qualification(request.getString("qualification"));
						sp.setExperiance(request.getString("experiance"));
						sp.setDesignation(request.getString("designation"));
						sp.setUser_name(request.getString("user_name"));
						return sp;
			}
		};
		
		List<ServiceProvider> list=jdbctemp.query(qu,new Object[]{designation},rowMapper);
		return list;
	}

	
	//===get client appointment list for service provider ..
	
	public List<User> getClient(String spuname) {

		String query="select * from user_registration where user_name in (select cuname from appoinment where spuname='"+spuname+"')";

		
		RowMapper<User> rowMapper=new RowMapper<User>() {

			public User mapRow(ResultSet request, int row) throws SQLException {
				 User u=new User();
				 u.setFname(request.getString("fname"));
				 u.setLname(request.getString("lname"));
				 u.setMobilenumber(request.getString("mobile_no"));
				 u.setEmail(request.getString("email"));
				 u.setAddress(request.getString("address"));
				return u;
			}
		};	
		List<User>	list=jdbctemp.query(query,rowMapper);
		return list;
	}
//=======================update service provider password when service provider forget password..
	public int updateSpPassword(ServiceProvider s) {
		// TODO Auto-generated method stub
		String query="UPDATE sp_final SET password='"+s.getPssword()+"'WHERE user_name='"+s.getUser_name()+"'"; 
		 int a=jdbctemp.update(query);
		return a;
	}

	//===============================================================================================
}
