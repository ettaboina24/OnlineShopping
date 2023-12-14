package com.capg.onlineshopping.service;

import java.util.List;

import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.exceptions.CategoryIdNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product product) throws CategoryIdNotFoundException;
	public List<Product> getAllProducts();
	public Product updateProductById(int id, int price,int quantity);
	public List<Product> priceLessThan(int price);
	public List<Product> priceGreaterThan(int price);
	public List<Product> searchByBrand(String name);
	public List<Product> priceRangeBetween(int minPrice,int maxPrice);
	public String deleteProductById(int pid,int cid);

}
