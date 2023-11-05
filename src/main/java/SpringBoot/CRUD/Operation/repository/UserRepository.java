package SpringBoot.CRUD.Operation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.CRUD.Operation.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getById(Integer id);
	public Optional<User> findById(Integer id);
	

}
 
