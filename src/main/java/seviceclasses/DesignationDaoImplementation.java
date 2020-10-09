package seviceclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import daointerfaceses.DesignationDao;
import pojoclasses.Designation;

public class DesignationDaoImplementation implements DesignationDao {

	 JdbcTemplate jdbctemplate;
	 
	
	public DesignationDaoImplementation(DataSource ds) {
		super();
		this.jdbctemplate =new JdbcTemplate(ds);
	}


	public int addDesignation(Designation da) {
		 
		String query="insert into designation values(?,?)";
		
		return jdbctemplate.update(query,null,da.getDesignation());
	}


	public List<Designation> getDesignation() {
		
		RowMapper<Designation> rowMapper=new RowMapper<Designation>() {

			public Designation mapRow(ResultSet reqeust, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				  Designation d=new Designation();
				  d.setDesignation(reqeust.getString("designation"));
				return d;
			}
		};
		List<Designation> list=jdbctemplate.query("select * from designation", rowMapper);
		return list;
	}

}
