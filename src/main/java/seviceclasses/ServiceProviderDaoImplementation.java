package seviceclasses;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
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


	public int save(ServiceProvider p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
