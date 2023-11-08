package com.retailmanagementsystem.controller;

import com.retailmanagementsystem.dao.ProductDao;
import com.retailmanagementsystem.entity.Category;
import com.retailmanagementsystem.entity.ImageModel;
import com.retailmanagementsystem.entity.Product;
import com.retailmanagementsystem.exception.ResourceNotFoundException;
import com.retailmanagementsystem.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDao productDao;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file) {
                                 
        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);
            
            return productService.addNewProduct(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file: multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }

        return imageModels;
    }

    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "") String searchKey) {
        List<Product> result = productService.getAllProducts(pageNumber, searchKey);
        System.out.println("Result size is "+ result.size());
        return result;
    }

    @GetMapping({"/getProductDetailsById/{productId}"})
    public Product getProductDetailsById(@PathVariable("productId") Integer productId)  {
       return productService.getProductDetailsById(productId);
   }
//    @GetMapping({"/getProductDetailsById/{productId}"})
//
//    public ResponseEntity<Product> getEmployeeById(@PathVariable(value = "productId") Integer productId )
//
//            throws ResourceNotFoundException {
//
//        Product product = productDao.findById(productId)
//
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
//
//        return ResponseEntity.ok().body(product);
//
//    }
    

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping({"/deleteProductDetails/{productId}"})
    public void deleteProductDetails(@PathVariable("productId") Integer productId) {
        productService.deleteProductDetails(productId);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckout" ) boolean isSingleProductCheckout,
                                           @PathVariable(name = "productId")  Integer productId) {
        return productService.getProductDetails(isSingleProductCheckout, productId);
    }
}
