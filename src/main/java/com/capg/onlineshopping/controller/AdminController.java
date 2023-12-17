package com.capg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.dto.AdminDto;
import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.service.OrderService;
import com.capg.onlineshopping.service.OrderServiceImpl;
import com.capg.onlineshopping.service.UserServiceImpl;

//package com.capg.onlineshopping.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.capg.onlineshopping.entity.Category;
//import com.capg.onlineshopping.entity.OrderNew;
//import com.capg.onlineshopping.entity.Product;
//import com.capg.onlineshopping.exceptions.CategoryAlreadyExistsException;
//import com.capg.onlineshopping.exceptions.IdNotFoundException;
//import com.capg.onlineshopping.exceptions.ProdcutIdNotFoundException;
//import com.capg.onlineshopping.service.CategoryService;
//import com.capg.onlineshopping.service.OrderNewService;
//import com.capg.onlineshopping.service.ProductService;
//
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private ProductService productService;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private OrderServiceImpl ordeServiceImpl;
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<>(userServiceImpl.fetchUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-orders")
	public ResponseEntity<List<Order>> findALLCompletedOrders()
	{
		return new  ResponseEntity<List<Order>>(ordeServiceImpl.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/admin-dashBoard/{userId}")
	public ResponseEntity<AdminDto> adminDashboard(@PathVariable("userId") int userId) throws IdNotFoundException
	{
		return new ResponseEntity<AdminDto>(userServiceImpl.getAdminDashboard(userId),HttpStatus.OK);
	}
	

	
}
