package com.example.productcatalog.model;

import jakarta.persistence.*;

@Entity
public class Product {

    // Unique identifier for each product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the product
    private String name;

    // Price of the product
    private Double price;

    // Many-to-one relationship with Category, where many products belong to one category
    // `@JoinColumn` specifies the foreign key column in the database that references Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Links to category_id column in database
    private Category category;

    // Getter for the product ID
    public Long getId() {
        return id;
    }

    // Setter for the product ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the product name
    public String getName() {
        return name;
    }

    // Setter for the product name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the product price
    public Double getPrice() {
        return price;
    }

    // Setter for the product price
    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter for the associated category
    public Category getCategory() {
        return category;
    }

    // Setter for the associated category
    public void setCategory(Category category) {
        this.category = category;
    }
}
