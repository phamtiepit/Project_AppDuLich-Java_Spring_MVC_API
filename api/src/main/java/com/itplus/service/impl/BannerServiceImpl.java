package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.BannerDao;
import com.itplus.entity.Banner;
import com.itplus.model.BannerDTO;
import com.itplus.service.BannerService;


@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	BannerDao bannerDao;
	@Override
	public List<BannerDTO> getAllBanner() {
		// TODO Auto-generated method stub
		List<BannerDTO> listBannerDTO = new ArrayList<BannerDTO>();
		List<Banner> listBanner = bannerDao.getAllBanner();
		for (Banner banner : listBanner) {
			BannerDTO bannerDTO = new BannerDTO();
			bannerDTO.setId(banner.getId());
			bannerDTO.setName(banner.getName());
			bannerDTO.setDescriptions(banner.getDescriptions());
			bannerDTO.setUrl(banner.getUrl());
			bannerDTO.setImages(banner.getImages());
			listBannerDTO.add(bannerDTO);
		}		
		return listBannerDTO;
	}
	@Override
	public void addBanner(BannerDTO bannerDTO) {
		Banner banner = new Banner();
		banner.setName(bannerDTO.getName());
		banner.setDescriptions(bannerDTO.getDescriptions());
		banner.setUrl(bannerDTO.getUrl());
		banner.setImages(bannerDTO.getImages());
		bannerDao.addBanner(banner);
		
	}
	@Override
	public void updateBanner(BannerDTO bannerDTO) {
		Banner banner = new Banner();
		banner.setId(bannerDTO.getId());
		banner.setName(bannerDTO.getName());
		banner.setDescriptions(bannerDTO.getDescriptions());
		banner.setUrl(bannerDTO.getUrl());
		banner.setImages(bannerDTO.getImages());
		bannerDao.updateBanner(banner);
		
	}
	@Override
	public BannerDTO getBannerById(int id) {
		Banner banner = bannerDao.getBannerById(id);
		BannerDTO bannerDTO = new BannerDTO();
		bannerDTO.setId(banner.getId());
		bannerDTO.setName(banner.getName());
		bannerDTO.setDescriptions(banner.getDescriptions());
		bannerDTO.setUrl(banner.getUrl());
		bannerDTO.setImages(banner.getImages());
		return bannerDTO;
	}
	@Override
	public void deleteBanner(int id) {
		bannerDao.deleteBanner(id);
		
	}
	
}
