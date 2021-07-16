package com.itplus.dao;

import java.util.HashMap;
import java.util.List;

import com.itplus.entity.OrderTour;

public interface OrderTourDao {
	List<OrderTour> getAllOrderTour();
	void addOrderTour(OrderTour ordertour);
	void updateOrderTour(OrderTour ordertour);
	OrderTour getOrderTourById(int id);
	void deleteOrderTour(int id);
	HashMap<String, Object> addOrder(OrderTour orderTour);
}
