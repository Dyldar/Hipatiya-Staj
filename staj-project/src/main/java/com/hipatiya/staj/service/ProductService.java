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

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() ->new NoSuchElementException("No such product found: " + name));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product updateDProduct){
        // look into this more detailedly, and use it to see
        return productRepository.findById(id).map(product -> {
            product.setName(updateDProduct.getName());
            product.setPrice(updateDProduct.getPrice());
            return productRepository.save(product);
        });
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<ProductView> getAllHideId(){
        return productRepository.findProductViews();
    }

    public List<Product> getExpensiveProducts(Integer price){
        return productRepository.findByPriceGreaterThan(price);
    }
}
