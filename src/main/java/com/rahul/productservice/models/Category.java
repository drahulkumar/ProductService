package com.rahul.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
//    private String name;
//    private String description;
//
//    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER)
//    private List<Product> featuredProducts;
//
//    @OneToMany(mappedBy = "category")
//    private List<Product> allProducts;
//
//    @OneToOne
//    private  Subcategory subcategories;



    @Column(nullable = false, unique = true, name = "category_name")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> featuredProducts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.SELECT)
    private List<Product> allProducts;

    @OneToOne(cascade = {})
    private Subcategory subcategories;

    private int countOfProducts;
}
