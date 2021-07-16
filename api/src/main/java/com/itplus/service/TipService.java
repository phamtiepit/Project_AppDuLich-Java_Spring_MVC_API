package com.itplus.service;

import java.util.List;

import com.itplus.model.TipDTO;

public interface TipService {
	List<TipDTO> getAllTip();
	void addTip(TipDTO tipDTO);
	TipDTO getTipById(int id);
	void updateTip(TipDTO tipDTO);
	void deleteTip(int id);
}
