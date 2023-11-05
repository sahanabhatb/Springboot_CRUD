package SpringBoot.CRUD.Operation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBoot.CRUD.Operation.model.User;
import SpringBoot.CRUD.Operation.repository.UserRepository;

@Service
public class UserService {


	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser() {
		List<User> foundUser = userRepository.findAll();
		if (!foundUser.isEmpty()) {
			return foundUser;
		} else {
			return null;
		}
		}

	public Optional<User> createUser(User user) {
		userRepository.save(user);
		Optional<User> savedProduct = userRepository.findById(user.getId());
		return savedProduct;
	}

	public Map<String, Object> deleteCustomer(Integer id) {	
		User  deleteduser = userRepository.getById(id);
		userRepository.delete(deleteduser);
		Optional<User> deleteduserr = userRepository.findById(id);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", 1);
		map.put("data", deleteduserr);
		System.out.println(map);
		return map;
	}

	public User editcust(User user, Integer id) {
		User userToBeEdited = userRepository.getById(id);
		if (userToBeEdited!=null) {
			// Customer found, return it
			userToBeEdited.setName(user.getName());
			userToBeEdited.setEmailid(user.getEmailid());
			userRepository.save(userToBeEdited);
			User editeddCustomer=new User();
			editeddCustomer.setId(userToBeEdited.getId());
			editeddCustomer.setEmailid(userToBeEdited.getEmailid());
			editeddCustomer.setName(userToBeEdited.getName());
			return editeddCustomer;
		
		} else {
			// Customer not found, 
			return null;
		}		
	}
	
	
	}
	
