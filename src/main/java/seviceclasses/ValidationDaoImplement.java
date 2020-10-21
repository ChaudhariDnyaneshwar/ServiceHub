package seviceclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import daointerfaceses.ValidationDao;
import pojoclasses.Validation;

public class ValidationDaoImplement  implements ValidationDao{
        
	// user for get data source for database connection...   
	
	JdbcTemplate jdbctemplate;
	public ValidationDaoImplement(DataSource ds) {
		super();
		this.jdbctemplate =new JdbcTemplate(ds);
	}

// use for the done user validation for login ....
	
	public int userValidation(Validation v) {
		int a=0;
		String query="select * from user_registration where user_name='"+v.getUsername() +"' and password='"+v.getPassword()+"'";
		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				   Validation v=new Validation();
				   v.setUsername(rs.getString("user_name"));
				   v.setPassword(rs.getString("password"));
			return v;
			}
		};
		
		
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		
		   a=list.size()>0?1:0;
		return a;
	}


	// user for the get service provider validation for login
	public int serviceProviderValidation(Validation v) {
	  int count=0;
		String query="select * from sp_final where user_name='"+v.getUsername() +"' and password='"+v.getPassword()+"'";
		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Validation v=new Validation();
				v.setUsername(rs.getString("user_name"));
				v.setPassword(rs.getString("password"));
				return v;
			}
		};
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		count=list.size()>0?1:0;
		return count;
	}

// user for the admin validation for login...
	
	public int adminValidation(Validation v) {
		int count=0;
		String query="select * from Admin where username='"+v.getUsername() +"' and password='"+v.getPassword()+"'";
		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Validation v=new Validation();
				v.setUsername(rs.getString("username"));
				v.setPassword(rs.getString("password"));
				return v;
			}
		};
		
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		count=list.size()>0?1:0;
		return count;
	}
//genrate otp
	public String getOtp() {
		String otp="";
		
		for(int i=1;i<7;i++)
		 {
			 int a;
			 a=(int) (Math.random()*10);
			 otp=otp+a;
		 }
		return otp;
	}

	//=========================validate user name and email for forget  password generate otp===
	public int getValidUserEmail(Validation v) {

		
		int a=0;
		String query="select * from user_registration where user_name='"+v.getUsername() +"' and email='"+v.getEmail()+"'";
		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				   Validation v=new Validation();
				   v.setUsername(rs.getString("user_name"));
				   v.setPassword(rs.getString("email"));
			return v;
			}
		};
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		   a=list.size()>0?1:0; 
		return a;
	}
//===============this method is user for validate the service provide user name and email for forget password..
	public int getValidSpEmailUname(Validation v) {
		int a=0;
String query="select * from sp_final where user_name='"+v.getUsername() +"' and email='"+v.getEmail()+"'";
		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				   Validation v=new Validation();
				   v.setUsername(rs.getString("user_name"));
				   v.setEmail(rs.getString("email"));
			return v;
			}
		};
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		   a=list.size()>0?1:0; 
		return a;
	}
//===================get validate admin username and email for forget passowrd
	public int getValidAdminEmailUname(Validation v) {
		
String query="select * from admin where username='"+v.getUsername() +"' and email='"+v.getEmail()+"'";
   int a=0;		
		RowMapper<Validation> rowMapper=new RowMapper<Validation>() {

			public Validation mapRow(ResultSet rs, int row) throws SQLException {
				   Validation v=new Validation();
				   v.setUsername(rs.getString("username"));
				   v.setPassword(rs.getString("email"));
			return v;
			}
		};
		List<Validation> list=jdbctemplate.query(query, rowMapper);
		   a=list.size()>0?1:0; 
		return a;
	}

}
