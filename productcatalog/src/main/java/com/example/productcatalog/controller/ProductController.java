package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Retrieves a paginated list of all products based on the page number provided
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam int page) {
        return productService.getAllProducts(page);
    }

    // Creates a new product based on the details provided in the request body
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Retrieves a single product by its ID, if it exists
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Updates an existing product by its ID with new details provided in the request body
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    // Deletes a product by its ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
