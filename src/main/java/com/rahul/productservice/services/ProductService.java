package com.rahul.productservice.services;

import com.rahul.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);

    Product partialUpdateProduct(Long productId, Product product);
}



/*String title ,
String description,
double price,
String category,
String imageUrl*/