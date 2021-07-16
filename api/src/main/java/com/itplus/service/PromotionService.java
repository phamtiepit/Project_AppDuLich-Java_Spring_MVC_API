package com.itplus.service;

import java.util.List;

import com.itplus.model.PromotionDTO;

public interface PromotionService {
	List<PromotionDTO> getAllPromotion();
	void addPromotion(PromotionDTO promotionDTO);
	void updatePromotion(PromotionDTO promotionDTO);
	PromotionDTO getPromotionById(int id);
	void deletePromotion(int id);
}
