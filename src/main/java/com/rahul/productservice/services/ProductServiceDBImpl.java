package com.rahul.productservice.services;

import com.rahul.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Product partialUpdateProduct(Long productId , Product product) {
        return null;
    }


//    @Override
//    public void createProduct(String title, String description, double price, String category, String imageUrl) {
//
//    }


}
