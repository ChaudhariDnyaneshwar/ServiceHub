package service;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Daoimplementatioin implements Dao{

	JdbcTemplate jdbctmeplate;
	
	


	public Daoimplementatioin(DataSource ds) {
		super();
		this.jdbctmeplate =new JdbcTemplate(ds);
	}




	public int save(pojo p) {
		// TODO Auto-generated method stub
	int a=0;
		try {
			byte[] image=p.getPhoto().getBytes();
		
			String query="insert into image values(?,?,?)";
			
		  a=	jdbctmeplate.update(query,new Object[]{p.getRoll(),p.getName(),image});
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

}
