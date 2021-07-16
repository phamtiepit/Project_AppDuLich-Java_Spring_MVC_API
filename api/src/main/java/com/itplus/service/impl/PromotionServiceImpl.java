package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.PromotionDao;
import com.itplus.entity.Promotion;
import com.itplus.model.PromotionDTO;
import com.itplus.service.PromotionService;


@Service
public class PromotionServiceImpl implements PromotionService{
	@Autowired
	PromotionDao promotionDao;
	@Override
	public List<PromotionDTO> getAllPromotion() {
		List<PromotionDTO> listPromotionDTO = new ArrayList<PromotionDTO>();
		List<Promotion> listPromotion = promotionDao.getAllPromotion();
		for (Promotion promotion : listPromotion) {
			PromotionDTO promotionDTO = new PromotionDTO();
			promotionDTO.setId(promotion.getId());
			promotionDTO.setCategoryid(promotion.getCategoryid());
			promotionDTO.setPromotioncode(promotion.getPromotioncode());
			promotionDTO.setName(promotion.getName());
			promotionDTO.setDiemdi(promotion.getDiemdi());
			promotionDTO.setDiemden(promotion.getDiemden());
			promotionDTO.setTimedi(promotion.getTimedi());
			promotionDTO.setTimeve(promotion.getTimeve());
			promotionDTO.setDescriptions(promotion.getDescriptions());
			promotionDTO.setImages(promotion.getImages());
			promotionDTO.setPrice(promotion.getPrice());
			listPromotionDTO.add(promotionDTO);
		}
		return listPromotionDTO;
	}
	@Override
	public void addPromotion(PromotionDTO promotionDTO) {
		Promotion promotion = new Promotion();
		promotion.setCategoryid(promotionDTO.getCategoryid());
		promotion.setPromotioncode(promotionDTO.getPromotioncode());
		promotion.setName(promotionDTO.getName());
		promotion.setDiemdi(promotionDTO.getDiemdi());
		promotion.setDiemden(promotionDTO.getDiemden());
		promotion.setTimedi(promotionDTO.getTimedi());
		promotion.setTimeve(promotionDTO.getTimeve());
		promotion.setDescriptions(promotionDTO.getDescriptions());
		promotion.setImages(promotionDTO.getImages());
		promotion.setPrice(promotionDTO.getPrice());
		promotionDao.addPromotion(promotion);		
	}
	@Override
	public void updatePromotion(PromotionDTO promotionDTO) {
		Promotion promotion = new Promotion();
		promotion.setCategoryid(promotionDTO.getCategoryid());
		promotion.setPromotioncode(promotionDTO.getPromotioncode());
		promotion.setName(promotionDTO.getName());
		promotion.setDiemdi(promotionDTO.getDiemdi());
		promotion.setDiemden(promotionDTO.getDiemden());
		promotion.setTimedi(promotionDTO.getTimedi());
		promotion.setTimeve(promotionDTO.getTimeve());
		promotion.setDescriptions(promotionDTO.getDescriptions());
		promotion.setImages(promotionDTO.getImages());
		promotion.setPrice(promotionDTO.getPrice());
		promotionDao.updatePromotion(promotion);
		
	}
	@Override
	public PromotionDTO getPromotionById(int id) {
		Promotion promotion = promotionDao.getPromotionById(id);
		PromotionDTO promotionDTO = new PromotionDTO();
		promotionDTO.setId(promotion.getId());
		promotionDTO.setCategoryid(promotion.getCategoryid());
		promotionDTO.setPromotioncode(promotion.getPromotioncode());
		promotionDTO.setName(promotion.getName());
		promotionDTO.setDiemdi(promotion.getDiemdi());
		promotionDTO.setDiemden(promotion.getDiemden());
		promotionDTO.setTimedi(promotion.getTimedi());
		promotionDTO.setTimeve(promotion.getTimeve());
		promotionDTO.setDescriptions(promotion.getDescriptions());
		promotionDTO.setImages(promotion.getImages());
		promotionDTO.setPrice(promotion.getPrice());
		return promotionDTO;
	}
	@Override
	public void deletePromotion(int id) {
		promotionDao.deletePromotion(id);
		
	}
	
	

}
