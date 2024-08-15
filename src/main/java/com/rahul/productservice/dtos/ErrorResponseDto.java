package com.rahul.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    public String status;
    public String message;

}
