package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.binding.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
