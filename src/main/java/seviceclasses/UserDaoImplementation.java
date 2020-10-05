package seviceclasses;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import daointerfaceses.UserDao;
import pojoclasses.User;

public class UserDaoImplementation implements UserDao {

	JdbcTemplate jdbctemplate;

	public UserDaoImplementation(DataSource datasource) {
		super();
		this.jdbctemplate = new JdbcTemplate(datasource);
	}

	public int save(User u) {

		String query = "insert into user_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int count = jdbctemplate.update(query, null, u.getFname(), u.getLname(), u.getEmail(), u.getMobilenumber(),
				u.getGender(), u.getAddress(), u.getCity(), u.getTahasil(), u.getDistrict(), u.getState(),
				u.getDateofbirth(), u.getUsername(), u.getPassword());

		return count;
	}

}
