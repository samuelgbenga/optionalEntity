package com.samuel.optionalfield.service;

import com.samuel.optionalfield.entity.Category;
import com.samuel.optionalfield.entity.Product;
import com.samuel.optionalfield.payload.CategoryRequest;
import com.samuel.optionalfield.payload.ProductRequest;
import com.samuel.optionalfield.repository.CategoryRepository;
import com.samuel.optionalfield.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public String insertCat(CategoryRequest categoryRequest) {

       Category newCategory =  modelMapper.map(categoryRequest, Category.class);

       categoryRepository.save(newCategory);

        return "Category inserted successfully";
    }

    @Override
    public String insertProduct(ProductRequest productRequest) {

        try {

            Category existCat = categoryRepository.findById(productRequest.getCategoryId()).get();

            Product newProduct = Product.builder()
                    .name(productRequest.getName())
                    .brand(productRequest.getBrand())
                    .category(existCat)
                    .build();

            productRepository.save(newProduct);

        }catch (Exception e){

            throw new RuntimeException("Category does not exist");

        }

        return "product inserted";
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }
}
