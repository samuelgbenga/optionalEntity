package com.samuel.optionalfield.payload;


import lombok.Data;

@Data
public class ProductRequest {

    private Long categoryId;
    private String name;
    private String brand;
}
