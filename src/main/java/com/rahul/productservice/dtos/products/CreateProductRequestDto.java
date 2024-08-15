package com.rahul.productservice.dtos.products;

import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    //private Long id;
    private String title;
    private  String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct(){
        Product product = new Product();
        //product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        return product;
    }

}
