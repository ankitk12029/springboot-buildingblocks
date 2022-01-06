package com.springboot.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entities.User;
import com.springboot.demo.services.UserService;

//Controller
@RestController
public class UserController {

	//Autowired the Userservice
	@Autowired
	private UserService userService;
	
	//getAll users method 
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//Create User Method
	//@RequestBody Annotation
	//@PostMapping Anotation 
	@PostMapping("/users")
	public User createUser (@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	//getUserById
	@GetMapping ("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return  userService.getUserById(id);
	}
	
	//updateUserById 
	@PutMapping("/users/{id}")
	public User updateUserById (@PathVariable("id") Long id,@RequestBody User user ) {
		return userService.updateUserById(id, user);
	}
	
	//deleteUserById
	@DeleteMapping ("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	//getUserByUsername
	@GetMapping("/users/byUserName/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByUserName(userName);
	}
	
	
}
