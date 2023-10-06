package in.ashokit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.User;
import in.ashokit.repo.UserRepository;
import in.ashokit.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepo;

	@Override
	public boolean saveUser(User user) {
		user=userrepo.save(user);
		return user.getId()>0;
	}
	@Override
	public User getUserById(Integer id) {
		Optional<User>findbyid= userrepo.findById(id);
		User user=null;
		if(findbyid.isPresent())
		{
			user=findbyid.get();
		}
		else{
			throw new RuntimeException("User is not found"+id);
		}
		return user;
		}

	@Override
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	@Override
	public String deleteUserById(Integer id) {
		if(userrepo.existsById(id))
		{
			userrepo.deleteById(id);
			return "User deleated successfully";
		}else
		{
			return "Id not present ";
		}
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userrepo.findByEmail(email);
		}	
}