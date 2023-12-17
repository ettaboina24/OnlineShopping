package com.capg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.dto.OrderDto;
import com.capg.onlineshopping.service.OrderServiceImpl;
import com.capg.onlineshopping.service.ProductServiceImpl;

@RestController
@RequestMapping("api/v1/user")
public class OrderController {
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private OrderServiceImpl orderNewService;
	
	
	@PostMapping("/order-new")
	public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDto){
		return new ResponseEntity<String>(orderNewService.addOrder(orderDto),HttpStatus.OK);
	}
	
	@GetMapping("/cancel-order/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable("orderId") int orderId){
		return new ResponseEntity<String>(orderNewService.cancelOrder(orderId),HttpStatus.OK);
	}
	
	

}
