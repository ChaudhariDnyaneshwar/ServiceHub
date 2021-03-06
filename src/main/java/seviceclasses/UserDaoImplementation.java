package seviceclasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.catalina.connector.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import daointerfaceses.UserDao;
import pojoclasses.Appoinment;
import pojoclasses.User;

public class UserDaoImplementation implements UserDao {

	// get data source for the database connection...
	JdbcTemplate jdbctemplate;

	public UserDaoImplementation(DataSource datasource) {
		super();
		this.jdbctemplate = new JdbcTemplate(datasource);
	}

	
	//====insert user data into database for user registration..
	
	public int save(User u) {

		String query = "insert into user_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int count = jdbctemplate.update(query, null, u.getFname(), u.getLname(), u.getEmail(), u.getMobilenumber(),
				u.getGender(), u.getAddress(), u.getCity(), u.getTahasil(), u.getDistrict(), u.getState(),
				u.getDateofbirth(), u.getUsername(), u.getPassword());

		return count;
	}

	
	//==get the list of all user for admin
	
	public List<User> getUsers() {

		RowMapper<User> rowMapper = new RowMapper<User>() {

			public User mapRow(ResultSet request, int arg1) throws SQLException {
				User us = new User();
				us.setUid(request.getInt("userId"));
				us.setFname(request.getString("fname"));
				us.setLname(request.getString("lname"));
				us.setEmail(request.getString("email"));
				us.setMobilenumber(request.getString("mobile_no"));
				us.setGender(request.getString("gender"));
				us.setAddress(request.getString("address"));
				us.setCity(request.getString("city"));
				us.setTahasil(request.getString("tahsil"));
				us.setDistrict(request.getString("dist"));
				us.setState(request.getString("state"));
				us.setDateofbirth(request.getString("date_of_birth"));

				return us;
			}
		};

		List<User> list = jdbctemplate.query("select * from user_registration", rowMapper);
		return list;
	}

	//=delete the user from database for admin...
	
	public int deletUser(int id) {
		String query="delete from user_registration where userId=?";
	int count=jdbctemplate.update(query,id);
		return count;
	}

//== insert the appoinment ....
	
	public int addAppoinment(Appoinment a) {
		String query="insert into appoinment values(?,?)";
		int count=jdbctemplate.update(query,a.getSpuname(),a.getCuname());
		return count;
	}

//======update user password======================
	public int updatePassword(User u) {
	  String query="UPDATE user_registration SET password='"+u.getPassword()+"'WHERE user_name='"+u.getUsername()+"'"; 
			 int a=jdbctemplate.update(query);
		return a;
		}


	public List<User> getUserProfile(User u) {
		String query="select * from user_registration where user_name=?";
		RowMapper<User> rowMapper=new RowMapper<User>() {

			public User mapRow(ResultSet request, int row) throws SQLException {
				User us = new User();
				us.setUid(request.getInt("userId"));
				us.setFname(request.getString("fname"));
				us.setLname(request.getString("lname"));
				us.setEmail(request.getString("email"));
				us.setMobilenumber(request.getString("mobile_no"));
				us.setGender(request.getString("gender"));
				us.setAddress(request.getString("address"));
				us.setCity(request.getString("city"));
				us.setTahasil(request.getString("tahsil"));
				us.setDistrict(request.getString("dist"));
				us.setState(request.getString("state"));
				us.setDateofbirth(request.getString("date_of_birth"));


				return us;
			}
		};
		List<User> list=jdbctemplate.query(query,new Object[]{u.getUsername()}, rowMapper);
		return list;
	}

//=======================================================================


}
