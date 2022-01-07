package com.springboot.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.demo.entities.User;
import com.springboot.demo.exceptions.UserExistsException;
import com.springboot.demo.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistsException {
		
		//if user exist using userName
		User existingUser = userRepository.findByUserName(user.getUserName());
		
		//if not exists throw UserExistsException
		if (existingUser !=null) {
			throw new UserExistsException("User already exixts in repository");
		}
		
		return userRepository.save(user);
	}
	
	

	// getUserById
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found in Repository");
		}
		return user;
	}


	// upadateUserById
	public User updateUserById(Long id, User user) throws UserNotFoundException  {
		Optional<User> optionalUser = userRepository.findById(id);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in Repository,provide the correct user Id.");
		}
		user.setId(id);
		return userRepository.save(user);
	}

	// deleteUserById
	public void deleteUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);

		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in Repository,provide the correct user Id.");
		}
		
		userRepository.deleteById(id);
		
	}

	// getUserByUsername
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
