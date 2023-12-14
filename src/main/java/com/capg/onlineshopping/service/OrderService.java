package com.capg.onlineshopping.service;

import java.util.List;

import com.capg.onlineshopping.dto.OrderDto;
import com.capg.onlineshopping.entity.Order;

public interface OrderService {
	
	public String addOrder(OrderDto orderDto);
	public String cancelOrder(int orderId);
     public List<Order> getAllOrders();

}
