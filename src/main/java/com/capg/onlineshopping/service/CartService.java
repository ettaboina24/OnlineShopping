package com.capg.onlineshopping.service;


import com.capg.onlineshopping.entity.Cart;


public interface CartService {
	
	public Cart addCart(Cart cart);
	public Cart removeProductFromCart(int cartId, int productId);
	
    	

}
