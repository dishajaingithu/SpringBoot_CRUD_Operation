package com.example.productcatalog.controller;

import com.example.productcatalog.model.Category;
import com.example.productcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Retrieves a paginated list of categories based on the page number
    @GetMapping
    public Page<Category> getAllCategories(@RequestParam int page) {
        return categoryService.getAllCategories(page);
    }

    // Creates a new category based on the details provided in the request body
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Retrieves a single category by its ID, if it exists
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Updates an existing category by its ID with new details provided in the request body
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    // Deletes a category by its ID
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
