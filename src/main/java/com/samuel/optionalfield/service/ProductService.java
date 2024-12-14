package com.samuel.optionalfield.service;

import com.samuel.optionalfield.entity.Category;
import com.samuel.optionalfield.entity.Product;
import com.samuel.optionalfield.payload.CategoryRequest;
import com.samuel.optionalfield.payload.ProductRequest;

import java.util.List;

public interface ProductService {


    String insertCat(CategoryRequest categoryRequest);
    String insertProduct(ProductRequest productRequest);

    List<Product> getProducts();
    List<Category> getCategory();


}
