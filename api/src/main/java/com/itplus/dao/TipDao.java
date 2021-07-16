package com.itplus.dao;

import java.util.List;

import com.itplus.entity.Tip;

public interface TipDao {
	List<Tip> getAllTip();
	void addTip(Tip banner);
	Tip getTipById(int id);
	void updateTip(Tip banner);
	void deleteTip(int id);
}
