package com.retailmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailmanagementsystem.entity.Category;
import com.retailmanagementsystem.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired

    private CategoryService categoryService;

 
	@PreAuthorize("hasRole('Admin')")
    @PostMapping("/addNewCategory")

    public Category addNewCategory(@RequestBody Category category) {

        return categoryService.addNewCategory(category);

    }

 

    @GetMapping("/getAllCategories")

    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();

    }

 

    @GetMapping("/getCategoryById/{categoryId}")

    public Category getCategoryById(@PathVariable Integer categoryId) {

        return categoryService.getCategoryById(categoryId);

    }

 
    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/deleteCategory/{categoryId}")

    public void deleteCategory(@PathVariable Integer categoryId) {

        categoryService.deleteCategory(categoryId);

    }

}
