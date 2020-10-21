package seviceclasses;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import daointerfaceses.AdminDao;
import pojoclasses.Admin;

public class AdminDaoImplementation implements AdminDao {

	//get data souce for the database connection 
	  
	JdbcTemplate jdbctemplate;
	
	
	public AdminDaoImplementation(DataSource ds) {
		super();
		this.jdbctemplate = new JdbcTemplate(ds);
	}


	public int insertAdmin(Admin a) {
		String query="insert into admin values(?,?,?,?)";
		int count=jdbctemplate.update(query,null,a.getUsername(),a.getPassword(),a.getEmail());
		return count;
	}

//update admin password when he forget...
	
	public int updateAdminPassword(Admin a) {
		  String query="UPDATE admin SET password='"+a.getPassword()+"'WHERE username='"+a.getUsername()+"'"; 
			 int count=jdbctemplate.update(query);

		// TODO Auto-generated method stub
		return count;
	}
	

}
