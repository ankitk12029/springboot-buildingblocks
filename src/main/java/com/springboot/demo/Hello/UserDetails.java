package com.springboot.demo.Hello;

public class UserDetails {
	
	private String fristName;
	private String lastName;
	private String city;
	
	//Feilds Contructor
	public UserDetails(String fristName, String lastName, String city) {
		this.fristName = fristName;
		this.lastName = lastName;
		this.city = city;
	}
	
	//Getters & Setters
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//toString
	@Override
	public String toString() {
		return "UserDetails [fristName=" + fristName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	
	

}
