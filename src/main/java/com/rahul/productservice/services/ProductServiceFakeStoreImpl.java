package com.rahul.productservice.services;


import com.rahul.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.rahul.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.rahul.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")

public class ProductServiceFakeStoreImpl implements ProductService{

    private RestTemplate restTemplate;
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setDescription(product.getDescription());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());

        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class

        );

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setImageUrl(response.getImage());
        product1.setPrice(response.getPrice());
        product1.setCategoryName(response.getCategory());


        return product1;
    }

//    @Override
//    public void createProduct(String title, String description, double price, String category, String imageUrl) {
//
//    }

}
