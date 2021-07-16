package com.itplus.model;

public class OrderTourDTO {
	private int id;
    private String hoten;
    private String phone;
    private String diachi;
    private String email;
    private int tourid;
    private int status;
	
    public OrderTourDTO() {
		super();
	}

	public OrderTourDTO(int id, String hoten, String phone, String diachi, String email, int tourid, int status) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.phone = phone;
		this.diachi = diachi;
		this.email = email;
		this.tourid = tourid;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTourid() {
		return tourid;
	}

	public void setTourid(int tourid) {
		this.tourid = tourid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
    
}
