package com.itplus.entity;

import com.itplus.model.UserDTO;

public class User {
	private int id;
	private String username;
	private String password;
	private int phone;
	private String address;
	private String email;
	
	
	public User() {
	
	}


	public User(int id, String username, String password, int phone, String address, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	public UserDTO toUserDTO(){
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(this.getUsername());
		userDTO.setId(this.getId());
		userDTO.setPassword(this.getPassword());
		userDTO.setAddress(this.getAddress());
		userDTO.setEmail(this.getEmail());
		userDTO.setPhone(this.getPhone());
		return userDTO;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
