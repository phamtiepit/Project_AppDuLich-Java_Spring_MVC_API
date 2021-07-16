package com.itplus.dao;

import java.util.List;

import com.itplus.entity.Promotion;

public interface PromotionDao {
	List<Promotion> getAllPromotion();
	void addPromotion(Promotion promotion);
	void updatePromotion(Promotion promotion);
	Promotion getPromotionById(int id);
	void deletePromotion(int id);
}
