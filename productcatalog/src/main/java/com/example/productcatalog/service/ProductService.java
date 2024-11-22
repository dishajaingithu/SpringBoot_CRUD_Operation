package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.repository.ProductRepository;
import com.example.productcatalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Retrieves a paginated list of all products.
     * @param page the page number to retrieve.
     * @return a Page object containing products for the specified page.
     */
    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page, 10)); // Pagination set to 10 products per page
    }

    /**
     * Creates a new product in the database.
     * @param product the product entity to save, containing category information.
     * @return the saved Product entity.
     * @throws RuntimeException if the specified category is not found.
     */
    public Product createProduct(Product product) {
        // Retrieve the category associated with the product by its ID
        Optional<Category> categoryOptional = categoryRepository.findById(product.getCategory().getId());

        if (categoryOptional.isPresent()) {
            product.setCategory(categoryOptional.get()); // Assign the category to the product
            return productRepository.save(product); // Save and return the product
        } else {
            throw new RuntimeException("Category not found"); // Throw an exception if category is missing
        }
    }

    /**
     * Retrieves a product by its ID.
     * @param id the ID of the product.
     * @return the Product entity if found.
     * @throws RuntimeException if the product is not found.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")); // Throw if product not found
    }

    /**
     * Updates an existing product's details.
     * @param id the ID of the product to update.
     * @param productDetails the updated details of the product.
     * @return the updated Product entity.
     * @throws RuntimeException if the product is not found.
     */
    public Product updateProduct(Long id, Product productDetails) {
        // Retrieve the product by ID, throwing an exception if not found
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update product fields
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setCategory(productDetails.getCategory());

        return productRepository.save(existingProduct); // Save the updated product
    }

    /**
     * Deletes a product by its ID.
     * @param id the ID of the product to delete.
     * @throws RuntimeException if the product is not found.
     */
    public void deleteProduct(Long id) {
        // Find the product by ID, throwing an exception if not found
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(existingProduct); // Delete the product
    }
}
