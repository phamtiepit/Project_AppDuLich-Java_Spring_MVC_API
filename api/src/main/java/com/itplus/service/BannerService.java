package com.itplus.service;

import java.util.List;

import com.itplus.model.BannerDTO;


public interface BannerService {
	List<BannerDTO> getAllBanner();
	void addBanner(BannerDTO bannerDTO);
	void updateBanner(BannerDTO bannerDTO);
	BannerDTO getBannerById(int id);
	void deleteBanner(int id);
}
