package com.itplus.service;

import java.util.HashMap;
import java.util.List;


import com.itplus.model.OrderTourDTO;

public interface OrderTourService {
	List<OrderTourDTO> getAllOrderTour();
	void addOrderTour(OrderTourDTO ordertourDTO);
	void updateOrderTour(OrderTourDTO ordertourDTO);
	OrderTourDTO getOrderTourById(int id);
	void deleteOrderTour(int id);
	HashMap<String, Object> addOrder(OrderTourDTO ordertourDTO);
}
