package com.springboot.demo.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.entities.User;

//Repository
@Repository
public interface UserRepository extends JpaRepository<User ,Long> {

	
	
	User findByUserName(String userName);




}
