package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.OrderTourDao;
import com.itplus.entity.OrderTour;
import com.itplus.model.OrderTourDTO;
import com.itplus.service.OrderTourService;

@Service
public class OrderTourServiceImpl implements OrderTourService{

	
	@Autowired
	OrderTourDao orderTourDao;
	@Override
	public List<OrderTourDTO> getAllOrderTour() {
		List<OrderTourDTO> listOrderTourDTO = new ArrayList<>();
		List<OrderTour> listOrderTour = orderTourDao.getAllOrderTour();
		for(OrderTour order : listOrderTour ) {
			OrderTourDTO orderTourDTO = new OrderTourDTO();
			orderTourDTO.setId(order.getId());
			orderTourDTO.setHoten(order.getHoten());
			orderTourDTO.setPhone(order.getPhone());
			orderTourDTO.setDiachi(order.getDiachi());
			orderTourDTO.setEmail(order.getEmail());
			orderTourDTO.setTourid(order.getTourid());
			orderTourDTO.setStatus(order.getStatus());
			listOrderTourDTO.add(orderTourDTO);
		}
		return listOrderTourDTO;
	}

	@Override
	public void addOrderTour(OrderTourDTO ordertourDTO) {
		OrderTour orderTour = new OrderTour();
		orderTour.setHoten(ordertourDTO.getHoten());
		orderTour.setPhone(ordertourDTO.getPhone());
		orderTour.setDiachi(ordertourDTO.getDiachi());
		orderTour.setEmail(ordertourDTO.getEmail());
		orderTour.setTourid(ordertourDTO.getTourid());
		orderTourDao.addOrderTour(orderTour);
	}

	@Override
	public void updateOrderTour(OrderTourDTO ordertourDTO) {
		OrderTour orderTour = new OrderTour();
		orderTour.setId(ordertourDTO.getId());
		orderTour.setHoten(ordertourDTO.getHoten());
		orderTour.setPhone(ordertourDTO.getPhone());
		orderTour.setDiachi(ordertourDTO.getDiachi());
		orderTour.setEmail(ordertourDTO.getEmail());
		orderTour.setTourid(ordertourDTO.getTourid());
		orderTour.setStatus(ordertourDTO.getStatus());
		orderTourDao.updateOrderTour(orderTour);		
	}

	@Override
	public OrderTourDTO getOrderTourById(int id) {
		OrderTour order = orderTourDao.getOrderTourById(id);
		OrderTourDTO orderTourDTO = new OrderTourDTO();
		orderTourDTO.setId(order.getId());
		orderTourDTO.setHoten(order.getHoten());
		orderTourDTO.setPhone(order.getPhone());
		orderTourDTO.setDiachi(order.getDiachi());
		orderTourDTO.setEmail(order.getEmail());
		orderTourDTO.setTourid(order.getTourid());
		orderTourDTO.setStatus(order.getStatus());
		return orderTourDTO;
	}

	@Override
	public void deleteOrderTour(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Object> addOrder(OrderTourDTO ordertourDTO) {
		OrderTour orderTour = new OrderTour();
		orderTour.setHoten(ordertourDTO.getHoten());
		orderTour.setPhone(ordertourDTO.getPhone());
		orderTour.setDiachi(ordertourDTO.getDiachi());
		orderTour.setEmail(ordertourDTO.getEmail());
		orderTour.setTourid(ordertourDTO.getTourid());
		return orderTourDao.addOrder(orderTour);	               
	}

}
