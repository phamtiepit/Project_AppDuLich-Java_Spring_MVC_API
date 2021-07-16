package com.viettravelapplication.Model;

import java.io.Serializable;

public class Tour implements Serializable {
    private int id;
    private int categoryid;
    private int promotionid;
    private String nametour;
    private String diemdi;
    private String diemden;
    private String timedi;
    private String timeve;
    private String descriptions;
    private String images;
    private double price;

    public Tour(int categoryid, int promotionid, String nametour, String diemdi, String diemden, String timedi, String timeve, String descriptions, String images, float price) {
        this.categoryid = categoryid;
        this.promotionid = promotionid;
        this.nametour = nametour;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.timedi = timedi;
        this.timeve = timeve;
        this.descriptions = descriptions;
        this.images = images;
        this.price = price;
    }

    public Tour(int id, int categoryid, int promotionid, String nametour, String diemdi, String diemden, String timedi, String timeve, String descriptions, String images, float price) {
        this.id = id;
        this.categoryid = categoryid;
        this.promotionid = promotionid;
        this.nametour = nametour;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.timedi = timedi;
        this.timeve = timeve;
        this.descriptions = descriptions;
        this.images = images;
        this.price = price;
    }

    public Tour(int id, String nametour, String diemdi, String diemden, String timedi, String timeve) {
        this.id = id;
        this.nametour = nametour;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.timedi = timedi;
        this.timeve = timeve;
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

    public String getNametour() {
        return nametour;
    }

    public void setNametour(String nametour) {
        this.nametour = nametour;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", categoryid=" + categoryid +
                ", promotionid=" + promotionid +
                ", nametour='" + nametour + '\'' +
                ", diemdi='" + diemdi + '\'' +
                ", diemden='" + diemden + '\'' +
                ", timedi='" + timedi + '\'' +
                ", timeve='" + timeve + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", images='" + images + '\'' +
                ", price=" + price +
                '}';
    }
}