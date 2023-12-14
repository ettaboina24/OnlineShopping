package com.capg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.entity.Cart;
import com.capg.onlineshopping.service.CartServiceImpl;
import com.capg.onlineshopping.service.OrderServiceImpl;
import com.capg.onlineshopping.service.ProductServiceImpl;
import com.capg.onlineshopping.service.UserServiceImpl;

@RestController
@RequestMapping("api/v1/user")

public class CartController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	OrderServiceImpl orderNewService;
	
	 @PostMapping("/addcart")
		public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
		{
			return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
		}
//	    @PostMapping("/placingorder")
//		public ResponseEntity<Order> palcesOrder(@RequestBody Order orders) throws InsufficientProductQuantityException
//		{
//			return new ResponseEntity<Order>(orderService.placeOrder(orders),HttpStatus.OK);
//		}	
	 
	 
	    @RequestMapping(value = "/remove-product/{cartId}/{productId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Cart> removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {
	        Cart updatedCart = cartService.removeProductFromCart(cartId, productId);
	        if (updatedCart != null) {
	            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
