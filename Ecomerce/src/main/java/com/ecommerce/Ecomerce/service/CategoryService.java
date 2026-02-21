package com.ecommerce.Ecomerce.service;

import com.ecommerce.Ecomerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);
}
