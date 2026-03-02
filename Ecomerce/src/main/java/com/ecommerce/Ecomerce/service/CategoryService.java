package com.ecommerce.Ecomerce.service;

import com.ecommerce.Ecomerce.model.Category;
import com.ecommerce.Ecomerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
