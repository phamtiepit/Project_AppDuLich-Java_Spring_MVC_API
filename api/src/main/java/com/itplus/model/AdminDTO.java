package com.itplus.model;

public class AdminDTO {
	private int id;
	private String username;
	private String password;
	private String fullname;
	
	
	public AdminDTO() {
		
	}


	public AdminDTO(int id, String username, String password, String images, String fullname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
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
	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ "]";
	}
	
	
}
