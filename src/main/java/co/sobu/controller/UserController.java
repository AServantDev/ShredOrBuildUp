package co.sobu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sobu.model.User;
import co.sobu.repository.UserRepository;
import co.sobu.services.UserServices;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired(required=true)
	private UserServices userServ;
	
	@PostMapping("/newUser")
	public User createUser(@Valid @RequestBody User user) {
		
		
		return userServ.userMB(user);
		
		
	}
	
	@PostMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {
		System.out.println(user.getIdUser());
		 userRepo.deleteById(user.getIdUser());
	}
	

}
