package com.retailmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retailmanagementsystem.entity.Category;

@Repository

public interface CategoryDao extends CrudRepository<Category, Integer> {

    // Custom query methods can be added here if needed

}
