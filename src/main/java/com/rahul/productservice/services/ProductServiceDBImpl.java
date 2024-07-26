package com.rahul.productservice.services;

import com.rahul.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }


//    @Override
//    public void createProduct(String title, String description, double price, String category, String imageUrl) {
//
//    }


}
