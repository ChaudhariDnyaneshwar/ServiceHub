package daointerfaceses;

import java.util.List;

import pojoclasses.User;

public interface UserDao {
	 public int save(User u);
	 public List<User> getUsers();
	 public int deletUser(int id);
	 
}
