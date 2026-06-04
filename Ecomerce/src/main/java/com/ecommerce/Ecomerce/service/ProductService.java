package com.ecommerce.Ecomerce.service;

import com.ecommerce.Ecomerce.model.Product;
import com.ecommerce.Ecomerce.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
