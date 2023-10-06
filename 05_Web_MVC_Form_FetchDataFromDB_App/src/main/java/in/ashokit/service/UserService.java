package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import in.ashokit.binding.User;

public interface UserService {
	public boolean saveUser(User user);
	//public String upsert(User user);
	public User getUserById(Integer id);
	public List<User>getAllUsers();
	public String deleteUserById(Integer id);
	User findUserByEmail(String email);
	
	

}
