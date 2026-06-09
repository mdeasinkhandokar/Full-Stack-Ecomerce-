package com.ecommerce.Ecomerce.repositories;

import com.ecommerce.Ecomerce.model.Category;
import com.ecommerce.Ecomerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryOrderByPriceAsc(Category category);
}
