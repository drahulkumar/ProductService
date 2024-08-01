package com.rahul.productservice.dtos.products;

import com.rahul.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;

    public static GetProductResponseDto from(Product product) {
        GetProductResponseDto responseDto = new GetProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        return responseDto;

    }



}
