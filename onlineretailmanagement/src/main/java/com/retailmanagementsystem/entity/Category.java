package com.retailmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer categoryId;

    private String categoryName;

    private String categoryDescription;

 

    // Constructors, getters, setters, and other methods as needed

 

    public Integer getCategoryId() {

        return categoryId;

    }

 

    public void setCategoryId(Integer categoryId) {

        this.categoryId = categoryId;

    }

 

    public String getCategoryName() {

        return categoryName;

    }

 

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;

    }

 

    public String getCategoryDescription() {

        return categoryDescription;

    }

 

    public void setCategoryDescription(String categoryDescription) {

        this.categoryDescription = categoryDescription;

    }



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Category(Integer categoryId, String categoryName, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

}
