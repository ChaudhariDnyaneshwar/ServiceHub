package daointerfaceses;

import java.util.List;

import pojoclasses.Admin;
import pojoclasses.Feedback;

public interface AdminDao {

	public int insertAdmin(Admin a);
	
	public int updateAdminPassword(Admin a);
	
	public List<Admin> getAdminProfile(Admin a);
	
	public int insetFeedback(Feedback f);
	
	public List<Feedback> getFeedback();
	
	public int deletFeedback(Feedback f);
}
