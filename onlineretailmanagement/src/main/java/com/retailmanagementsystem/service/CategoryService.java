package com.retailmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailmanagementsystem.dao.CategoryDao;
import com.retailmanagementsystem.entity.Category;
@Service
public class CategoryService {
	 @Autowired

	    private CategoryDao categoryDao;

	 

	    public Category addNewCategory(Category category) {

	        return categoryDao.save(category);

	    }

	 

	    public List<Category> getAllCategories() {

	        return (List<Category>) categoryDao.findAll();

	    }

	 

	    public Category getCategoryById(Integer categoryId) {

	        return categoryDao.findById(categoryId).orElse(null);

	    }

	 

	    public void deleteCategory(Integer categoryId) {

	        categoryDao.deleteById(categoryId);

	    }

}
