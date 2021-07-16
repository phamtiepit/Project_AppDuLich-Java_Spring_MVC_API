package com.itplus.dao;

import java.util.List;

import com.itplus.entity.Tour;

public interface TourDao {
	List<Tour> getAllTour();
	List<Tour> getAllTourByCategory(int cateid);
	void addTour(Tour tour);
	void updateTour(Tour tour);
	Tour getTourById(int id);
	void deleteTour(int id);
}
