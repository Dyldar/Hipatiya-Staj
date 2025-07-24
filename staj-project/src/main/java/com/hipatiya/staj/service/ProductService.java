package com.hipatiya.staj.service;

import com.hipatiya.staj.model.Product;
import com.hipatiya.staj.model.ProductView;
import com.hipatiya.staj.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    //instantiate repo
    private final ProductRepository productRepository;

    //constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //get ALL product
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //get by ID
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    //get by NAME
    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() ->new NoSuchElementException("No such product found: " + name));
    }

    //CREATE
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    //UPDATE
    public Optional<Product> updateProduct(Long id, Product updateDProduct){
        return productRepository.findById(id).map(product -> {
            product.setName(updateDProduct.getName());
            product.setPrice(updateDProduct.getPrice());
            return productRepository.save(product);
        });
    }

    //DELETE
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    //get ALL no ID
    public List<ProductView> getAllHideId(){
        return productRepository.findProductViews();
    }

    //get by PRICE greater than
    public List<Product> getExpensiveProducts(double price){
        return productRepository.findByPriceGreaterThan(price);
    }
}
