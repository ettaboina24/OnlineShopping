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
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.exceptions.CategoryAlreadyExistsException;
import com.capg.onlineshopping.exceptions.IdNotFoundException;
import com.capg.onlineshopping.service.CategoryServiceImpl;
import com.capg.onlineshopping.service.ProductServiceImpl;

@RestController
@RequestMapping("api/v1/admin")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ProductServiceImpl productService;
	
	@PostMapping("/add-category")
	public ResponseEntity<Category> createCategory(@RequestBody Category category)throws CategoryAlreadyExistsException 
	{
		return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/get-all-categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		return new ResponseEntity<List<Category>>(categoryService.fetchCategory(), HttpStatus.OK);
	}
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int cid) throws IdNotFoundException {
		return new ResponseEntity<String>(categoryService.deleteCategoryById(cid), HttpStatus.OK);
	}
	@PutMapping("/update-category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(name="id")int id,@RequestBody Category category)
	{
		return new ResponseEntity<Category>(categoryService.updateCategoryById(id, category),HttpStatus.OK);
	}

}
