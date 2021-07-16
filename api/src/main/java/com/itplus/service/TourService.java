package com.itplus.service;

import java.util.List;

import com.itplus.model.TourDTO;

public interface TourService {
	List<TourDTO> getAllTour();
	List<TourDTO> getAllTourByCategory(int idcate);
	void addTour(TourDTO tourDTO);
	void updateTour(TourDTO tourDTO);
	TourDTO getTourById(int id);
	void deleteTour(int id);
}
