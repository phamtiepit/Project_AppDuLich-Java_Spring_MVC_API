package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.TipDao;
import com.itplus.entity.Tip;
import com.itplus.model.TipDTO;
import com.itplus.service.TipService;


@Service
public class TipServiceImpl implements TipService{

	@Autowired
	TipDao tipDao;
	@Override
	public List<TipDTO> getAllTip() {
		List<TipDTO> listTipDTO = new ArrayList<TipDTO>();
		List<Tip> listTip = tipDao.getAllTip();
		for (Tip tip : listTip) {
			TipDTO tipDTO = new TipDTO();
			tipDTO.setId(tip.getId());
			tipDTO.setTitle(tip.getTitle());
			tipDTO.setContent(tip.getContent());
			listTipDTO.add(tipDTO);
		}		
		return listTipDTO;
	}

	@Override
	public void addTip(TipDTO tipDTO) {
		Tip tip = new Tip();
		tip.setId(tipDTO.getId());
		tip.setTitle(tipDTO.getTitle());
		tip.setContent(tipDTO.getContent());
		tipDao.addTip(tip);
	}

	@Override
	public void updateTip(TipDTO tipDTO) {
		Tip tip = new Tip();
		tip.setId(tipDTO.getId());
		tip.setTitle(tipDTO.getTitle());
		tip.setContent(tipDTO.getContent());
		tipDao.updateTip(tip);	
	}

	@Override
	public void deleteTip(int id) {
		tipDao.deleteTip(id);
	}

	@Override
	public TipDTO getTipById(int id) {
		Tip tip = tipDao.getTipById(id);
		TipDTO tipDTO = new TipDTO();
		tipDTO.setId(tip.getId());
		tipDTO.setTitle(tip.getTitle());
		tipDTO.setContent(tip.getContent());
		return tipDTO;
	}

}
