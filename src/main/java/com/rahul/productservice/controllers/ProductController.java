package com.rahul.productservice.controllers;


import com.rahul.productservice.dtos.CreateProductRequestDto;
import com.rahul.productservice.dtos.CreateProductResponseDto;
import com.rahul.productservice.models.Product;
import com.rahul.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //private String productServiceType;
    private ProductService productService;


    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
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
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id){
        return "Here is your product: " + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }

    @RequestMapping(name = "Naman" , value="")
    public String tdisdtsdds(){
        return "Magic";
    }

}
