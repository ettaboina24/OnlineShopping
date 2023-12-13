package com.capg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.exceptions.CategoryIdNotFoundException;
import com.capg.onlineshopping.exceptions.InsufficientProductQuantityException;
import com.capg.onlineshopping.exceptions.ProdcutIdNotFoundException;
import com.capg.onlineshopping.repository.CategoryRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.utility.AppConstant;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public Product addProduct(Product product) throws CategoryIdNotFoundException{
		Category category=null;
		int category_id=product.getCategory().getId();
		if(categoryRepository.existsById(category_id))
		{
			category = categoryRepository.findById(category_id).get();
			product.setCategory(category);
			return productRepository.save(product);
			
		}
		throw new CategoryIdNotFoundException(AppConstant.CATEGORY_ID_NOT_FOUND_INFO);
		
	}

	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public Product updateProductById(int id, String price,int quantity) {
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
	
	public List<Product> priceLessThan(int price)
	{
		return productRepository.findByPriceLessThan(price);
	}
	
	public List<Product> priceGreaterThan(int price)
	{
		return productRepository.findByGreaterThan(price);
	}
	
	public List<Product> searchByBrand(String name)
	{
		return productRepository.findByBrand(name);
	}
	
	public List<Product> priceRangeBetween(int minPrice,int maxPrice)
	{
		return productRepository.findProductsByPriceRange(minPrice, maxPrice);
	}
	
	
	public String deleteProductById(int pid,int cid) {
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
	
	
//	public void updateProductQuantity(int productId, int orderedQuantity) throws InsufficientProductQuantityException {
//        Product product = productRepository.findById(productId).orElse(null);
//
//        if (product != null) {
//            int remainingQuantity = product.getQuantity() - orderedQuantity;
//
//            if (remainingQuantity >= 0) {
//                product.setQuantity(remainingQuantity);
//                productRepository.save(product);
//            } else {
//                // Handle insufficient quantity scenario according to your application's needs
//                throw new InsufficientProductQuantityException("Insufficient quantity for product with ID: " + productId);
//            }
//        }
//    }

}
