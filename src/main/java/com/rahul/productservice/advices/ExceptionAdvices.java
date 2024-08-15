package com.rahul.productservice.advices;

import com.rahul.productservice.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvices {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatus("ERROR");
        errorResponseDto.setMessage(e.getMessage());
        return errorResponseDto;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "Something went wrong";

    }

}
