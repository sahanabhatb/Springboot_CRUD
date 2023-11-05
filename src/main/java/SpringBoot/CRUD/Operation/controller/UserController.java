package SpringBoot.CRUD.Operation.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import SpringBoot.CRUD.Operation.model.User;
import SpringBoot.CRUD.Operation.repository.UserRepository;
import SpringBoot.CRUD.Operation.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@GetMapping("/allusers")
	public ResponseEntity<Object> getalluser()
	{
		try {
			List<User> foundCustomer= userService.getAllUser();	 
			if(foundCustomer!=null)
			return ResponseEntity.ok().body(foundCustomer);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Object> create(@RequestBody User user) {
		
		try {
			Optional<User> createUser= userService.createUser(user);
			return ResponseEntity.ok().body(createUser);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PutMapping("/editcust/{id}") 
	public ResponseEntity<Object>  editcust(@RequestBody User user,@PathVariable("id") Integer id) {
		
		try {
			User edituser= userService.editcust(user,id);
			return ResponseEntity.ok().body(edituser);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Map<String, Object>> deletecurt(@PathVariable("id") Integer id) {
		
		try {
			Map<String, Object> deleteUser= userService.deleteCustomer(id); 
			System.out.println(deleteUser);
			return new ResponseEntity<>(deleteUser, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}