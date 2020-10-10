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
import pojoclasses.User;

public class UserDaoImplementation implements UserDao {

	JdbcTemplate jdbctemplate;

	public UserDaoImplementation(DataSource datasource) {
		super();
		this.jdbctemplate = new JdbcTemplate(datasource);
	}

	
	//==============================================================
	public int save(User u) {

		String query = "insert into user_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int count = jdbctemplate.update(query, null, u.getFname(), u.getLname(), u.getEmail(), u.getMobilenumber(),
				u.getGender(), u.getAddress(), u.getCity(), u.getTahasil(), u.getDistrict(), u.getState(),
				u.getDateofbirth(), u.getUsername(), u.getPassword());

		return count;
	}

	
	//=====================================
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

	//=================================
	public int deletUser(int id) {
		String query="delete from user_registration where userId=?";
	int count=jdbctemplate.update(query,id);
		return count;
	}

//=======================================================================


}
