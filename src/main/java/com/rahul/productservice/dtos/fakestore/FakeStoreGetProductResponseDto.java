package com.rahul.productservice.dtos.fakestore;

import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


    public Product toProduct(){
        Product product1 = new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setImageUrl(this.getImage());
        product1.setPrice(this.getPrice());
        Category category1 = new Category();
        category1.setName(category);

        product1.setCategory(category1);

        return product1;

    }

}
