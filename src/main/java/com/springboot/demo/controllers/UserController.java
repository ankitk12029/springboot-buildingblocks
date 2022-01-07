package com.springboot.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.demo.entities.User;
import com.springboot.demo.exceptions.UserExistsException;
import com.springboot.demo.exceptions.UserNotFoundException;
import com.springboot.demo.services.UserService;

//Controller
@RestController
public class UserController {

	// Autowired the Userservice
	@Autowired
	private UserService userService;

	// getAll users method
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Create User Method
	// @RequestBody Annotation
	// @PostMapping Anotation
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

		} catch (UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());

		}

	}

	// getUserById
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());

		}

	}

	// updateUserById
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {

		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());

		}

	}

	// deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	// getUserByUsername
	@GetMapping("/users/byUserName/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByUserName(userName);
	}

}
