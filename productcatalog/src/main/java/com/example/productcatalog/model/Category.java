// package com.example.productcatalog.model;

// import jakarta.persistence.*;
// import java.util.List;

// @Entity
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private List<Product> products;

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public List<Product> getProducts() {
//         return products;
//     }

//     public void setProducts(List<Product> products) {
//         this.products = products;
//     }
// }


package com.example.productcatalog.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

    // Unique identifier for each category
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the category
    private String name;

    // List of products associated with this category
    // One-to-many relationship where a category can have multiple products
    // Cascade type set to ALL to propagate all operations from Category to its products
    // Fetch type set to LAZY to load products only when accessed
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    // Getter for the category ID
    public Long getId() {
        return id;
    }

    // Setter for the category ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the category name
    public String getName() {
        return name;
    }

    // Setter for the category name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the list of products associated with this category
    public List<Product> getProducts() {
        return products;
    }

    // Setter for the list of products associated with this category
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
