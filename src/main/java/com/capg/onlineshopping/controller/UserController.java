package com.capg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.dto.OrderDto;
import com.capg.onlineshopping.entity.Cart;

import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.entity.User;
import com.capg.onlineshopping.exceptions.InsufficientProductQuantityException;
import com.capg.onlineshopping.exceptions.InvalidEmailException;
import com.capg.onlineshopping.exceptions.InvalidPasswordException;
import com.capg.onlineshopping.exceptions.UserAlreadyExistSException;
import com.capg.onlineshopping.service.CartServiceImpl;
import com.capg.onlineshopping.service.OrderServiceImpl;

import com.capg.onlineshopping.service.ProductServiceImpl;
import com.capg.onlineshopping.service.UserServiceImpl;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	OrderServiceImpl orderNewService;
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> addUser(@RequestBody User user)throws UserAlreadyExistSException,InvalidPasswordException,InvalidEmailException
	{
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User loginRequest)throws InvalidEmailException, InvalidPasswordException {
		    System.out.println(loginRequest.getEmail());
		
		return new ResponseEntity<String>(userService.userLogin(loginRequest.getEmail(), loginRequest.getPassword()),HttpStatus.OK);
	}
//	@PostMapping("/login")
//	public ResponseEntity<User> checkUserLoginDetails(@RequestBody User user) throws EmailIdDoesNotExit, PasswordDoesNotExits 
//	{
//		return new ResponseEntity<User>(userService.checkUserLogin(user),HttpStatus.OK);
//	}
	
//	@GetMapping("/get-all-users")
//	public ResponseEntity<List<User>> getAllUsers()
//	{
//		return new ResponseEntity<>(userService.fetchUsers(),HttpStatus.OK);
//	}
	@GetMapping("/get-all-products")
	public ResponseEntity<List<Product>> getProducts()
	{
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/product/priceLessThan/{price}")
	public ResponseEntity<List<Product>> findByPriceLessThan(@PathVariable(name="price") int price)
	{
		return new ResponseEntity<List<Product>>(productService.priceLessThan(price),HttpStatus.OK);
	}
	
	
	@GetMapping("/product/priceGreaterThan/{price}")
	public ResponseEntity<List<Product>> findByPriceGreaterThan(@PathVariable(name="price") int price)
	{
		return new ResponseEntity<List<Product>>(productService.priceGreaterThan(price),HttpStatus.OK);
	}
	
	@GetMapping("/product/priceBetween/{minPrice}/{maxPrice}")
	public ResponseEntity<List<Product>> searchProductBetween(@PathVariable(name="minPrice") int minPrice,@PathVariable(name="maxPrice") int maxPrice)
	{
		return new ResponseEntity<List<Product>>(productService.priceRangeBetween(minPrice, maxPrice),HttpStatus.OK);
	}
	
	
	@GetMapping("/by-brand/{brandName}")
	public ResponseEntity<List<Product>> searchByBrand(@PathVariable(name="brandName") String name)
	{
		return new ResponseEntity<List<Product>>(productService.searchByBrand(name),HttpStatus.OK);
	}
	
	
	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUserDetail(id,user),HttpStatus.OK);
	}
	
	@PutMapping("/updateaddress2/{id}")
	public ResponseEntity<User> updateUserAddress(@PathVariable int id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUserDetailAddress(id,user.getAddress()),HttpStatus.OK);
	}
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUserById(@PathVariable int id)
	 {
		 return new ResponseEntity<String>(userService.deleteUserById(id),HttpStatus.OK);
	       
	    }
//	 @PostMapping("/addcart")
//		public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
//		{
//			return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
//		}
//	    @PostMapping("/placingorder")
//		public ResponseEntity<Order> palcesOrder(@RequestBody Order orders) throws InsufficientProductQuantityException
//		{
//			return new ResponseEntity<Order>(orderService.placeOrder(orders),HttpStatus.OK);
//		}	
	 
	 
//	    @RequestMapping(value = "/remove-product/{cartId}/{productId}", method = RequestMethod.DELETE)
//	    public ResponseEntity<Cart> removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {
//	        Cart updatedCart = cartService.removeProductFromCart(cartId, productId);
//	        if (updatedCart != null) {
//	            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
//	    @PostMapping("/cancelorder/{orderId}")
//	    public ResponseEntity<Order> cancelOrder(@PathVariable("orderId") int orderId )
//	    {
//	    	return new ResponseEntity<>(orderService.cancelOrder(orderId),HttpStatus.OK);
//	    }

//		@PostMapping("/order-new")
//		public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDto){
//			return new ResponseEntity<String>(orderNewService.addOrder(orderDto),HttpStatus.OK);
//		}
//		
//		@GetMapping("/cancel-order/{orderId}")
//		public ResponseEntity<String> cancelOrder(@PathVariable("orderId") int orderId){
//			return new ResponseEntity<String>(orderNewService.cancelOrder(orderId),HttpStatus.OK);
//		}

}
