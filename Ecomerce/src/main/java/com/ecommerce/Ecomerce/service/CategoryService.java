package com.ecommerce.Ecomerce.service;

import com.ecommerce.Ecomerce.model.Category;
import com.ecommerce.Ecomerce.payload.CategoryDTO;
import com.ecommerce.Ecomerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    String deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO  categoryDTO, Long categoryId);
}
