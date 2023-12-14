package com.capg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.User;
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
//	
	
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
	
	
	
//	@PostMapping("/addcategory")
//	public ResponseEntity<Category> createCategory(@RequestBody Category category)throws CategoryAlreadyExistsException 
//			
//	{
//		return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.OK);
//	}
//	
//	@GetMapping("/get-all-categories")
//	public ResponseEntity<List<Category>> getAllCategories() {
//		return new ResponseEntity<List<Category>>(categoryService.fetchCategory(), HttpStatus.OK);
//	}
//	@DeleteMapping("/category/{categoryId}")
//	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int cid) throws IdNotFoundException {
//		return new ResponseEntity<String>(categoryService.deleteCategoryById(cid), HttpStatus.OK);
//	}
//	@PutMapping("/updatecategory/{id}")
//	public ResponseEntity<Category> updateCategory(@PathVariable(name="id")int id,@RequestBody Category category)
//	{
//		return new ResponseEntity<Category>(categoryService.updateCategoryById(id, category),HttpStatus.OK);
//	}
//	@PostMapping("/addProduct")
//	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws IdNotFoundException {
//		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
//	}
//	@GetMapping("/get-all-products")
//	public ResponseEntity<List<Product>> getProducts()
//	{
//		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
//	}
//	@PutMapping("/updateproduct/{id}")
//	public ResponseEntity<Product> upadteProductBasedOnId(@PathVariable(name="id")int id,@RequestBody Product product)
//	{
//		return new ResponseEntity<Product>(productService.updateProductById(id,product.getPrice(),product.getQuantity()),HttpStatus.OK);
//	}
//	@DeleteMapping("/deleteproduct/{id}/{cid}")
//	public ResponseEntity<String> deleteProductById(@PathVariable(name="id") int id,@PathVariable(name="cid")int cid) throws ProdcutIdNotFoundException 
//	{
//		productService.deleteProductById(id, cid);
//		return new ResponseEntity<String>("deleted",HttpStatus.OK);
//	}
	
}
