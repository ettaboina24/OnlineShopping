package com.capg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.exceptions.BrandNotFoundException;
import com.capg.onlineshopping.exceptions.CategoryIdNotFoundException;
import com.capg.onlineshopping.exceptions.InsufficientProductQuantityException;
import com.capg.onlineshopping.exceptions.ProdcutIdNotFoundException;
import com.capg.onlineshopping.repository.CategoryRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.utility.AppConstant;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	
	@Autowired
	private CategoryRepository categoryRepository;
    
	@Override
	public Product addProduct(Product product) throws CategoryIdNotFoundException{	
		 Category category = product.getCategory();

		    if (category != null) 
		    {
		        int categoryId = category.getId();
		        if (categoryRepository.existsById(categoryId)) 
		        {
		            category = categoryRepository.findById(categoryId).get();
		            product.setCategory(category);
		            return productRepository.save(product);
		        }    
		    }
		    throw new CategoryIdNotFoundException(AppConstant.CATEGORY_ID_NOT_FOUND_INFO);
	}
    
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		System.out.println(products);
		System.out.println(products.size());
		return products;
	}
    
	@Override
	public Product updateProductById(int id, int price,int quantity) throws ProdcutIdNotFoundException {
		Product productnew = null;
		if(productRepository.existsById(id))
		{
			productnew=productRepository.findById(id).get();
//			productnew.setBrand(product.getBrand());
//			productnew.setDescription(product.getDescription());
//			productnew.setName(product.getName());
			productnew.setPrice(price);
			productnew.setQuantity(quantity);
			return productRepository.save(productnew);
		}
		else {
			throw new ProdcutIdNotFoundException(AppConstant.PRODUCT_ID_NOT_FOUND_INFO);
		}
		
	}
	
	@Override
	public List<Product> priceLessThan(int price)
	{
		return productRepository.findByPriceLessThan(price);
	}
	
	@Override
	public List<Product> priceGreaterThan(int price)
	{ 
		return productRepository.findByGreaterThan(price);
	}
	
	@Override
	public List<Product> searchByBrand(String name) throws BrandNotFoundException
	{
		List<Product> products= productRepository.findByBrand(name);
		if(products.isEmpty())
		{
			throw new BrandNotFoundException("BRAND_NOT_FOUND");
			
		}
		return products;
	}
	
	@Override
	public List<Product> priceRangeBetween(int minPrice,int maxPrice)
	{
		return productRepository.findProductsByPriceRange(minPrice, maxPrice);
	}
	
	@Override
	public String deleteProductById(int pid,int cid)throws ProdcutIdNotFoundException {
		String msg="";
		if(productRepository.existsById(pid))
		{
//			productRepository.deleteById(pid);
			Category category=categoryRepository.findById(cid).get();
			productRepository.deleteByProductIdAndCategory(pid, category);
			msg="Product Deleted Successfully"+pid;
			
		}
		else
		{
			throw new ProdcutIdNotFoundException("INVALID_PRODUCT_ID");
		}
		return msg;
		
	}
}
