package com.capg.onlineshopping.dto;

public class OrderDto {

	private int cartId;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "OrderDto [cartId=" + cartId + "]";
	}
	
	
}
