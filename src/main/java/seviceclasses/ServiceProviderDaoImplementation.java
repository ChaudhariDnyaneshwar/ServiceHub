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

@Service
public class ServiceProviderDaoImplementation implements ServiceProviderDao {

	JdbcTemplate jdbctemp;
	
	
	public ServiceProviderDaoImplementation(DataSource ds) {
		super();
		this.jdbctemp =new JdbcTemplate(ds);
	}

//==============================================================================================
	public int save(ServiceProvider p) {
		
		int a=0;
		try {
			
	        //byte[] qualificatio1n_certificate=p.getHigh_qualification().getBytes();
	        byte[] qualification_certificate= p.getQualification_certificate().getBytes();
	        byte[] licence=p.getLicence_certificate().getBytes();
	        byte[] photo=p.getPhoto().getBytes();
	        byte[] adhar_image=p.getAddar_image().getBytes();
	
			String query="insert into service_provider values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			  
			a=jdbctemp.update(query,new Object[]{null,p.getFname(),p.getLname(),p.getMob_number(),p.getEmail(),p.getAddar_number(),p.getGender(),p.getDateofbirth(),
				p.getSpecialization(),p.getOffice_address(),p.getCity(),p.getTahsil(),p.getDistrict(),p.getState(),p.getHigh_qualification(),p.getUniversity_name(),
				 p.getExperiance(),licence,photo,adhar_image,p.getUser_name(),p.getPssword(),qualification_certificate,p.getDesignation()});
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			return a;
	}

	//========================================================================================
	public List<ServiceProvider> getServiceProvider() {
	  
		RowMapper<ServiceProvider> rowMapper=new RowMapper<ServiceProvider>() {

			public ServiceProvider mapRow(ResultSet request, int arg1) throws SQLException {
				
				ServiceProvider sp=new ServiceProvider();

				
				sp.setSp_id(request.getInt("spId"));
				sp.setFname(request.getString("fname"));
				sp.setLname(request.getString("lname"));
				sp.setMob_number(request.getString("mob_number"));
				sp.setEmail(request.getString("emai"));
				sp.setAddar_number(request.getString("addr_number"));
				sp.setGender(request.getString("gender"));
				sp.setDateofbirth(request.getString("date_of_birth"));
				sp.setSpecialization(request.getString("specialization"));
				sp.setOffice_address(request.getString("address"));
				sp.setCity(request.getString("city"));
				sp.setTahsil(request.getString("tahsil"));
				sp.setDistrict(request.getString("tahsil"));
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

	//==============================================================================================
	
	public Blob getSpImage(int id) {
		
		
String query="select photo from sp_final where spId=?";
		
		Blob photo=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		return photo;
	}
   
	//================================================================================================
	public Blob getSpAdharImage(int id) {
		
		 String query="select addar_imgae from sp_final where spId=?";
			
			Blob adhar=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return adhar;
	}

  //==================================================================================================
	public Blob getSpLicence(int id) {
	    
         String query="select licence from sp_final where spId=?";
		
		Blob licence=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		
		return licence;
	}
//==================================================================================================
	public Blob getSpQualificationImg(int id) {
		String query="select qualifica_certificates from sp_final where spId=?";
		Blob qualification=jdbctemp.queryForObject(query, new Object[]{id},Blob.class);
		return qualification;
	}

	//====================================================================================================

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
				sp.setAddar_number(request.getString("addr_number"));
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
List<ServiceProvider>	list=	jdbctemp.query("select * from service_provider",rowMapper);  
		return list;
	}


	//==================================================================================================
	public Blob getspRequestImage(int id) {
		// TODO Auto-generated method stub
		String query="select photo from service_provider where spId=?";
		
		Blob photo=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);
		return photo;
	}

	//==================================================================================================

	public Blob getspReqeustlicence(int id) {
		// TODO Auto-generated method stub
         String query="select licence from service_provider where spId=?";
		
		Blob licence=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return licence;
	}

	//==============================================================================================

	public Blob getspRequestAddarImage(int id) {
		// TODO Auto-generated method stub
 String query="select addar_imgae from service_provider where spId=?";
		
		Blob adhar=jdbctemp.queryForObject(query, new Object[]{id}, Blob.class);

		return adhar;
	}

 //=====================================================================================================
	public Blob getspRequestQcertificate(int id) {
		String query="select qualifica_certificates from service_provider where spId=?";
		Blob qualification=jdbctemp.queryForObject(query, new Object[]{id},Blob.class);
		return qualification;
	}

//=====================================================================================================
	public int rejectServiceProvider(int id) {
		// TODO Auto-generated method stub
		String query="delete from service_provider where spId=?";
		return jdbctemp.update(query,id);
	}

	//===============================================================
	public int acceptSpRequest(int id) {

		String query="insert sp_final select * from service_provider where spId=?";
		int count=jdbctemp.update(query,id);
		String dquery="delete from service_provider where spId=?";
		jdbctemp.update(dquery,id);
		return count;
	}

	
	//================================================================
  
	public int deleteSrviceProvider(int id) {
		String query="delete from sp_final where spId=?";
		return jdbctemp.update(query,id);
	}
	
	//===============================================================

	public List<ServiceProvider> getDrelatedSp(String designation) {
		 String qu="select * from sp_final where designation=?";
		 
		 RowMapper<ServiceProvider> rowMapper=new RowMapper<ServiceProvider>() {

			public ServiceProvider mapRow(ResultSet request, int arg1) throws SQLException {
		  		     ServiceProvider sp=new ServiceProvider();
				     sp.setSp_id(request.getInt("spId"));
						sp.setFname(request.getString("fname"));
						sp.setLname(request.getString("lname"));
						sp.setMob_number(request.getString("mob_number"));
						sp.setEmail(request.getString("emai"));
						sp.setSpecialization(request.getString("specialization"));
						sp.setOffice_address(request.getString("address"));
						sp.setDistrict(request.getString("district"));
						sp.setHigh_qualification(request.getString("qualification"));
						sp.setExperiance(request.getString("experiance"));
						sp.setDesignation(request.getString("designation"));
						return sp;
			}
		};
		
		List<ServiceProvider> list=jdbctemp.query(qu,new Object[]{designation},rowMapper);
		
		 //jdbctemp.query(query,designation, rowMapper);
		return list;
	}




	

	//===============================================================================================
}
