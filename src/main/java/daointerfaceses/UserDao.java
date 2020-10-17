package daointerfaceses;

import java.util.List;

import pojoclasses.Appoinment;
import pojoclasses.User;

public interface UserDao {
	
	//====insert user data into database for user registration..
	 public int save(User u);
	 
	//==get the list of all user for admin
	 public List<User> getUsers();
	 
	//=delete the user from database for admin...
	 public int deletUser(int id);
	 
	//== insert the appoinment ....
	 public int addAppoinment(Appoinment a);
}
