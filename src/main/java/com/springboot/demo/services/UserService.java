package com.springboot.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entities.User;
import com.springboot.demo.repositories.UserRepository;

//Service
@Service
public class UserService {

	// Autoiwre the UserRepository
	@Autowired
	private UserRepository userRepository;

	// getAllUsers Method
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	// Create user method

	public User createUser(User user) {
		return userRepository.save(user);
	}

	// getUserById

	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);

		return user;
	}

	// upadateUserById

	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	// deleteUserById
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	//getUserByUsername
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
