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
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.exceptions.ProdcutIdNotFoundException;
import com.capg.onlineshopping.service.CategoryService;
import com.capg.onlineshopping.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws IdNotFoundException {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}
	@GetMapping("/get-all-products")
	public ResponseEntity<List<Product>> getProducts()
	{
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> upadteProductBasedOnId(@PathVariable(name="id")int id,@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.updateProductById(id,product.getPrice(),product.getQuantity()),HttpStatus.OK);
	}
//	@DeleteMapping("/deleteproduct/{id}/{cid}")
//	public ResponseEntity<String> deleteProductById(@PathVariable(name="id") int id,@PathVariable(name="cid")int cid) throws ProdcutIdNotFoundException 
//	{
//		productService.deleteProductById(id, cid);
//		return new ResponseEntity<String>("deleted",HttpStatus.OK);
//	}
//	
	
	@DeleteMapping("/deleteproduct/{id}/{cid}")
	public ResponseEntity<String> deleteProductById(@PathVariable(name="id") int id,@PathVariable(name="cid")int cid) throws ProdcutIdNotFoundException 
	{
		productService.deleteProductById(id, cid);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	

}
