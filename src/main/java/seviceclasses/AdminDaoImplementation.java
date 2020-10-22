package seviceclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

//get data for admin profile
	public List<Admin> getAdminProfile(Admin a) {
		
		String query="select * from admin where username=?";
		RowMapper<Admin> rowMapper=new RowMapper<Admin>() {

			public Admin mapRow(ResultSet request, int row) throws SQLException {
				 Admin a=new Admin();
				 a.setUsername(request.getString("username"));
				 a.setPassword(request.getString("password"));
				 a.setEmail(request.getString("email"));
						 
				return a;
			}
		};
		
		List<Admin> list=jdbctemplate.query(query,new Object[]{a.getUsername()}, rowMapper);
		return list;
	}
	

}
