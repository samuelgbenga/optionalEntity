package com.samuel.optionalfield.controller;


import com.samuel.optionalfield.payload.BookRequest;
import com.samuel.optionalfield.payload.CategoryRequest;
import com.samuel.optionalfield.payload.ProductRequest;
import com.samuel.optionalfield.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(productService.getCategory());
    }


    @PostMapping("/insert-product")
    public ResponseEntity<?> insertProduct(@RequestBody ProductRequest request){

        String result = productService.insertProduct(request);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/insert-category")
    public ResponseEntity<?> insertProduct(@RequestBody CategoryRequest request){

        String result = productService.insertCat(request);

        return ResponseEntity.ok(result);
    }
}
