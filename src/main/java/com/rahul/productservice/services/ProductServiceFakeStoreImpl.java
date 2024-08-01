package com.rahul.productservice.services;


import com.rahul.productservice.dtos.fakestore.FakeStoreCreateProductRequestDto;
import com.rahul.productservice.dtos.fakestore.FakeStoreGetProductResponseDto;
import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")

public class ProductServiceFakeStoreImpl implements ProductService{

    private RestTemplate restTemplate;
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategory().getName());
        request.setDescription(product.getDescription());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());

        FakeStoreGetProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreGetProductResponseDto.class

        );




        return response.toProduct();
    }

    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class

        );

        List<FakeStoreGetProductResponseDto> responseDtoList =
                Stream.of(response).toList();


        List<Product> products = new ArrayList<>();

        for(FakeStoreGetProductResponseDto responseDto : responseDtoList){
            products.add(responseDto.toProduct());


        }
        return products;
//        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreGetProductResponseDto[].class
//
//        );
//        List<Product> product2 = new ArrayList<>();
//
//        for(FakeStoreGetProductResponseDto product : response){
//            Product product1 = new Product();
//            product1.setId(product.getId());
//            product1.setTitle(product.getTitle());
//            product1.setDescription(product.getDescription());
//            product1.setImageUrl(product.getImage());
//            product1.setPrice(product.getPrice());
//            product1.setCategoryName(product.getCategory());
//
//            product2.add(product1);
//
//        }
//        return product2;

    }

    public Product getProductById(Long id) {
        FakeStoreGetProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreGetProductResponseDto.class
        );
        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setImageUrl(response.getImage());
        product1.setPrice(response.getPrice());

        Category category = new Category();
        category.setName(response.getCategory());




        product1.setCategory(category);
        return product1;


    }


    public void deleteProductById(Long id) {
        restTemplate.delete(
                "https://fakestoreapi.com/products/"+id
        );
    }

    @Override
    public Product partialUpdateProduct(Long productId , Product product) {

        restTemplate.patchForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreCreateProductRequestDto.fromProductDto(product),
                FakeStoreGetProductResponseDto.class


        );
        return null;
    }



    //    @Override
//    public void createProduct(String title, String description, double price, String category, String imageUrl) {
//
//    }

}
