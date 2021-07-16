package com.itplus.entity;

public class Promotion {
	private int id;
	private int categoryid;
	private String promotioncode;
	private String name;
	private String diemdi;
	private String diemden;
	private String timedi;
	private String timeve;
	private String descriptions;
	private String images;
	private float price;
	public Promotion() {
		
	}
	public Promotion(int id, int categoryid, String promotioncode, String name, String diemdi, String diemden,
			String timedi, String timeve, String descriptions, String images, float price) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.promotioncode = promotioncode;
		this.name = name;
		this.diemdi = diemdi;
		this.diemden = diemden;
		this.timedi = timedi;
		this.timeve = timeve;
		this.descriptions = descriptions;
		this.images = images;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getPromotioncode() {
		return promotioncode;
	}
	public void setPromotioncode(String promotioncode) {
		this.promotioncode = promotioncode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiemdi() {
		return diemdi;
	}
	public void setDiemdi(String diemdi) {
		this.diemdi = diemdi;
	}
	public String getDiemden() {
		return diemden;
	}
	public void setDiemden(String diemden) {
		this.diemden = diemden;
	}
	public String getTimedi() {
		return timedi;
	}
	public void setTimedi(String timedi) {
		this.timedi = timedi;
	}
	public String getTimeve() {
		return timeve;
	}
	public void setTimeve(String timeve) {
		this.timeve = timeve;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
}
