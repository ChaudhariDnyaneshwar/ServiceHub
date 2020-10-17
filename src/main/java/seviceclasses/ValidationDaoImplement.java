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

}
