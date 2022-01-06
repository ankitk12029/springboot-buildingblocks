package com.springboot.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity (chnage the name using name parameter 
//by default it takes the name of class)
@Entity
@Table(name = "user" )   //can also use schema parameter can search about it
public class User {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "USER_NAME" , length=50 , nullable=false ,unique=true)
	private String userName;
	
	@Column(name = "FIRST_NAME" , length=50 , nullable=false)
	private String fristName;
	
	@Column(name = "LAST_NAME" , length=50 , nullable=false)
	private String lastName;
	
	@Column(name = "EMAIL_ADDRESS" , length=50 , nullable=false)
	private String email;
	
	@Column(name = "ROLE" , length=50 , nullable=false)
	private String role;
	
	@Column(name = "SSN" , length=50 , nullable=false ,unique=true)
	private String ssn;

	//No Argument Constructor
	public User() {	
	}
	
	//Feilds Constructor
	public User(Long id, String userName, String fristName, String lastName, String email, String role, String ssn) {
		this.id = id;
		this.userName = userName;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	
	//GEtters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	
	//ToString  - Optinal for bean logging
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fristName=" + fristName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	

	
	
	
	
	
}
