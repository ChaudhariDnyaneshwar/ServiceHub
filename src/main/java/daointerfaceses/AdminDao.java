package daointerfaceses;

import java.util.List;

import pojoclasses.Admin;

public interface AdminDao {

	public int insertAdmin(Admin a);
	
	public int updateAdminPassword(Admin a);
	
	public List<Admin> getAdminProfile(Admin a);
}
