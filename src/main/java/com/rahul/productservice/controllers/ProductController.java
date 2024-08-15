package com.rahul.productservice.controllers;


import com.rahul.productservice.dtos.ErrorResponseDto;
import com.rahul.productservice.dtos.products.*;
import com.rahul.productservice.models.Product;
import com.rahul.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.rahul.productservice.Exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //private String productServiceType;
    private ProductService productService;


    public ProductController(@Qualifier("dbProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
       // return "this product is priced at : " + createProductRequestDto.getPrice();
        Product product = productService.createProduct(
                createProductRequestDto.toProduct()
        );
        return CreateProductResponseDto.fromProduct(
                product
        );

    }

    @GetMapping("")
    public GetAllProductResponseDto getAllProducts(){


        List<Product> products = productService.getAllProducts();
        GetAllProductResponseDto response = new GetAllProductResponseDto();

        List<GetProductDto> getProductResponseDtos = new ArrayList<>();
        for (Product product : products) {
            getProductResponseDtos.add(GetProductDto.from(product));

        }

        response.setProducts(getProductResponseDtos);
        return response;


//        List<CreateProductResponseDto> productList = new ArrayList<>();
//        List<Product> products = productService.getAllProducts();
//        for (Product product : products) {
//            CreateProductResponseDto responseDto = CreateProductResponseDto.fromProduct(product);
//            productList.add(responseDto);
//        }
//        return  productList;
    }

    @GetMapping("/{id}")
    public CreateProductResponseDto getSingleProduct(@PathVariable("id") Long id){
        CreateProductResponseDto responseDto;
        Product product = productService.getProductById(id);
        responseDto = CreateProductResponseDto.fromProduct(product);
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);

    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody CreateProductDto productDto
    ) throws ProductNotFoundException {
        Product product = productService.partialUpdateProduct(
                productId,
                productDto.toProduct()
        );

        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));

        return response;
    }


    @RequestMapping(name = "Naman" , value="")
    public String tdisdtsdds(){
        return "Magic";
    }

}
