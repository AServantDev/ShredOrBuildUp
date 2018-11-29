package co.sobu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@DeleteMapping("/deleteUserById/{id}")
	public void deleteUser(@PathVariable (value = "id") Long id) {
		 userRepo.deleteById(id);
	}
	
	@GetMapping("/allUser")
	public List<User> getAll(){
		return (List<User>) userRepo.findAll();
	}
	
//	@RequestMapping("/updateUser/{id}")
//	public User updateUser(@PathVariable (value = "id") Long id) {
//		
//		User user = userRepo.findUserByIdUser(id);
//		return userServ.userMB(user);
//		
//	}
	@PutMapping("/updateUser/{userId}")
	ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long userId)  {
		 	
		 User userToUpdate = userRepo.findUserByIdUser(userId);
		 if(userToUpdate == null)
			 return ResponseEntity.notFound().build();
		 
		 if (user.getLastname() != null) userToUpdate.setLastname(user.getLastname());
		 
		 if (user.getName() != null) userToUpdate.setName(user.getName());
		 
		 if (user.getAge() != 0) userToUpdate.setAge(user.getAge());
		 
		 if (user.getWeight() != 0) userToUpdate.setWeight(user.getWeight());
		 
		 if (user.getHeigth() != 0) userToUpdate.setHeigth(user.getHeigth());
		 
		 if (user.getGender() != null) userToUpdate.setGender(user.getGender());
		 
		 if (user.getCoefSportif() != 0) userToUpdate.setCoefSportif(user.getCoefSportif());
		 
		 if (user.getEmail() != null) userToUpdate.setEmail(user.getEmail());
		 
		 if (user.getPassword() != null) userToUpdate.setPassword(user.getPassword());

		 
		  user = userServ.userMB(user);
		   
		   return ResponseEntity.ok(userToUpdate);
		
	}
	
	
	@GetMapping("/getOneUser/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable (value = "id") Long id){
		User userToGet = userRepo.findUserByIdUser(id);
		if(userToGet == null)
			 return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(userToGet);
	}
	
	
	@PostMapping("/getUserEmailPass")
	public ResponseEntity<User> getUserEmailPass(HttpSession session, @RequestBody User user){
		
		System.out.println(user.getEmail());
		User userToGet = userRepo.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(userToGet == null) {
			System.out.println("Can't get the user or the user does not exist");
			 return ResponseEntity.notFound().build();}
			
		session.setAttribute("name", userToGet.getName());
		
		return ResponseEntity.ok().body(userToGet);
		
	}
	
	@GetMapping("/connect")
	public void connectUser(HttpSession session, User user) {
		
		
		
		session.setAttribute("user", user);
		
		
	}
	

}
