package com.example.productcatalog.repository;

import com.example.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository to provide CRUD operations and more
 * for Product objects with Long as the ID type.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides all basic CRUD operations, so no additional code is needed here
}
