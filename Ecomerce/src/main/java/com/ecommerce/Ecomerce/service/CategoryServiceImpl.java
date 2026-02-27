package com.ecommerce.Ecomerce.service;

import com.ecommerce.Ecomerce.exceptions.APIException;
import com.ecommerce.Ecomerce.exceptions.ResourceNotFoundException;
import com.ecommerce.Ecomerce.model.Category;
import com.ecommerce.Ecomerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements  CategoryService {

//    private List<Category> categories= new ArrayList<>();
//    private Long nextId=1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++);
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null)
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
//        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));


       categoryRepository.delete(category);
        return "Category with categoryId: " +categoryId + " deleted successful";
    }



    @Override
    public Category updateCategory(Category category, Long categoryId) {


        Category savedCategory= categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));

        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory;





    }
}
