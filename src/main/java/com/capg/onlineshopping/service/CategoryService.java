package com.capg.onlineshopping.service;

import java.util.List;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.exceptions.CategoryAlreadyExistsException;
import com.capg.onlineshopping.exceptions.IdNotFoundException;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category createCategory(Category category) throws CategoryAlreadyExistsException;
	public List<Category> fetchCategory();
	public String deleteCategoryById(int cid);
	public Category updateCategoryById(int cid,Category category) throws IdNotFoundException;


}
