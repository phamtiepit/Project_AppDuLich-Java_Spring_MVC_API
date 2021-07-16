package com.itplus.model;

public class TourDTO {
	private int id;
	private int categoryid;
	private int promotionid;
	private String name;
	private String diemdi;
	private String diemden;
	private String timedi;
	private String timeve;
	private String descriptions;
	private String images;
	private float price;
	
	public TourDTO() {
		
	}

	public TourDTO(int id, int categoryid, int promotionid, String name, String diemdi, String diemden, String timedi,
			String timeve, String descriptions, String images, float price) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.promotionid = promotionid;
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

	public int getPromotionid() {
		return promotionid;
	}

	public void setPromotionid(int promotionid) {
		this.promotionid = promotionid;
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

	@Override
	public String toString() {
		return "TourDTO [id=" + id + ", categoryid=" + categoryid + ", promotionid=" + promotionid + ", name=" + name
				+ ", diemdi=" + diemdi + ", diemden=" + diemden + ", timedi=" + timedi + ", timeve=" + timeve
				+ ", descriptions=" + descriptions + ", images=" + images + ", price=" + price + "]";
	}
	
	
}
