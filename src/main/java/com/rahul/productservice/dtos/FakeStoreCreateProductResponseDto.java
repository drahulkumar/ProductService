package com.rahul.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
