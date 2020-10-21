package daointerfaceses;

import pojoclasses.Admin;

public interface AdminDao {

	public int insertAdmin(Admin a);
	
	public int updateAdminPassword(Admin a);
}
