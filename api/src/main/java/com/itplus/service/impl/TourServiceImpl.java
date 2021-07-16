package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.TourDao;
import com.itplus.entity.Tour;
import com.itplus.model.TourDTO;
import com.itplus.service.TourService;


@Service
public class TourServiceImpl implements TourService{

	@Autowired
	TourDao tourDao;
	
	@Override
	public List<TourDTO> getAllTour() {
		// TODO Auto-generated method stub
		
		List<TourDTO> listtourDTO = new ArrayList<TourDTO>();
		List<Tour> listTour = tourDao.getAllTour();
		for (Tour tour : listTour) {
			TourDTO tourDTO = new TourDTO();
			tourDTO.setId(tour.getId());
			tourDTO.setCategoryid(tour.getCategoryid());
			tourDTO.setPromotionid(tour.getPromotionid());
			tourDTO.setName(tour.getName());
			tourDTO.setDiemdi(tour.getDiemdi());
			tourDTO.setDiemden(tour.getDiemden());
			tourDTO.setTimedi(tour.getTimedi());
			tourDTO.setTimeve(tour.getTimeve());
			tourDTO.setDescriptions(tour.getDescriptions());
			tourDTO.setImages(tour.getImages());
			tourDTO.setPrice(tour.getPrice());
			listtourDTO.add(tourDTO);
		}
		
		return listtourDTO;
	}

	@Override
	public void addTour(TourDTO tourDTO) {
		Tour tour = new Tour();
		tour.setCategoryid(tourDTO.getCategoryid());
		tour.setPromotionid(tourDTO.getPromotionid());
		tour.setName(tourDTO.getName());
		tour.setDiemdi(tourDTO.getDiemdi());
		tour.setDiemden(tourDTO.getDiemden());
		tour.setTimedi(tourDTO.getTimedi());
		tour.setTimeve(tourDTO.getTimeve());
		tour.setDescriptions(tourDTO.getDescriptions());
		tour.setImages(tourDTO.getImages());
		tour.setPrice(tourDTO.getPrice());
		tourDao.addTour(tour);
		
	}

	@Override
	public void updateTour(TourDTO tourDTO) {
		Tour tour = new Tour();
		tour.setId(tourDTO.getId());
		tour.setCategoryid(tourDTO.getCategoryid());
		tour.setPromotionid(tourDTO.getPromotionid());
		tour.setName(tourDTO.getName());
		tour.setDiemdi(tourDTO.getDiemdi());
		tour.setDiemden(tourDTO.getDiemden());
		tour.setTimedi(tourDTO.getTimedi());
		tour.setTimeve(tourDTO.getTimeve());
		tour.setDescriptions(tourDTO.getDescriptions());
		tour.setImages(tourDTO.getImages());
		tour.setPrice(tourDTO.getPrice());
		tourDao.updateTour(tour);
		
	}

	@Override
	public TourDTO getTourById(int id) {
		Tour tour = tourDao.getTourById(id);
		TourDTO tourDTO = new TourDTO();
		tourDTO.setId(tour.getId());
		tourDTO.setCategoryid(tour.getCategoryid());
		tourDTO.setPromotionid(tour.getPromotionid());
		tourDTO.setName(tour.getName());
		tourDTO.setDiemdi(tour.getDiemdi());
		tourDTO.setDiemden(tour.getDiemden());
		tourDTO.setTimedi(tour.getTimedi());
		tourDTO.setTimeve(tour.getTimeve());
		tourDTO.setDescriptions(tour.getDescriptions());
		tourDTO.setImages(tour.getImages());
		tourDTO.setPrice(tour.getPrice());
		return tourDTO;
	}

	@Override
	public void deleteTour(int id) {
		tourDao.deleteTour(id);		
	}

	@Override
	public List<TourDTO> getAllTourByCategory(int cateid) {
		List<TourDTO> listtourDTO = new ArrayList<TourDTO>();
		List<Tour> listTour = tourDao.getAllTourByCategory(cateid);
		for (Tour tour : listTour) {
			TourDTO tourDTO = new TourDTO();
			tourDTO.setId(tour.getId());
			tourDTO.setCategoryid(tour.getCategoryid());
			tourDTO.setPromotionid(tour.getPromotionid());
			tourDTO.setName(tour.getName());
			tourDTO.setDiemdi(tour.getDiemdi());
			tourDTO.setDiemden(tour.getDiemden());
			tourDTO.setTimedi(tour.getTimedi());
			tourDTO.setTimeve(tour.getTimeve());
			tourDTO.setDescriptions(tour.getDescriptions());
			tourDTO.setImages(tour.getImages());
			tourDTO.setPrice(tour.getPrice());
			listtourDTO.add(tourDTO);
		}
		return listtourDTO;
	}

}
