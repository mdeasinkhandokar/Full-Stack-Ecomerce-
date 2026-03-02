package com.ecommerce.Ecomerce.controller;


import com.ecommerce.Ecomerce.config.AppConstants;
import com.ecommerce.Ecomerce.model.Category;
import com.ecommerce.Ecomerce.payload.CategoryDTO;
import com.ecommerce.Ecomerce.payload.CategoryResponse;
import com.ecommerce.Ecomerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required=false) Integer pageNumber,
            @RequestParam(name = "pageSize" ,defaultValue = AppConstants.PAGE_NUMBER,required=false) Integer pageSize) {
        CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber, pageSize);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
        }




    @PostMapping("/api/public/categories")
    public ResponseEntity < CategoryDTO > createCategory(@Valid  @RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategoryDTO =  categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>( savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {

        CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);

        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);


        }


    @PutMapping("/api/public/categories/{categoryId}")
     public ResponseEntity<CategoryDTO>updateCategory(@RequestBody CategoryDTO categoryDTO,
                                                      @PathVariable Long categoryId){
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
      }











    }
