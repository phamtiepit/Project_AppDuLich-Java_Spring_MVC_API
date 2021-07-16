package com.itplus.model;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private int phone;
	private String address;
	private String email;
	public UserDTO() {
		
	}
	public UserDTO(int id, String username, String password, int phone, String address, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.email = email;
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
