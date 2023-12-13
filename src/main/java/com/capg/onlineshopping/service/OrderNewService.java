package com.capg.onlineshopping.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.dto.OrderDto;
import com.capg.onlineshopping.entity.Cart;
import com.capg.onlineshopping.entity.OrderNew;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.repository.CartRepository;
import com.capg.onlineshopping.repository.OrderNewRepository;
import com.capg.onlineshopping.repository.ProductRepository;

@Service
public class OrderNewService {

	@Autowired
	OrderNewRepository orderNewRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	public String addOrder(OrderDto orderDto) {
//		System.out.println(orderNew);
		Cart cart=cartRepository.findById(orderDto.getCartId()).get();
		for(Product product:cart.getProducts()) {
			OrderNew order= new OrderNew();
			order.setCustomerName(cart.getCustomer().getUserName());
			order.setProductId(product.getProductId());
			order.setProductName(product.getName());
			order.setQuantity(1);
			product.setQuantity(product.getQuantity()-1);
			order.setAmount(Integer.toString(1 * Integer.parseInt(product.getPrice())));
			order.setOrderDateTime(LocalDateTime.now());
			order.setOrderStatus("Completed");
			orderNewRepository.save(order);
		}
		return "Order Placed Successfully";
	}
	
	public String cancelOrder(int orderId) {
		OrderNew orderNew = orderNewRepository.findById(orderId).get();
		orderNew.setOrderStatus("Cancelled");
		orderNewRepository.save(orderNew);
		Product product = productRepository.findById(orderNew.getProductId()).get();
		product.setQuantity(product.getQuantity()+1);
		productRepository.save(product);
		return "Order Cancelled Successfully";
	}
}
