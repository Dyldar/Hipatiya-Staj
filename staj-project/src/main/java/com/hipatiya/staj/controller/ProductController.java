package com.hipatiya.staj.controller;

import com.hipatiya.staj.model.Product;
import com.hipatiya.staj.model.ProductView;
import com.hipatiya.staj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @GetMapping("/clean-list")
    public List<ProductView> getAllHideId(){
        return service.getAllHideId();
    }

    @GetMapping("/search")/// ////
    public Product searchByName(@RequestParam String name){
        return service.getProductByName(name);
    }

    @GetMapping("/pricey")/// ////
    public List<Product> searchExpensive(@RequestParam Integer price){
        return service.getExpensiveProducts(price);
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id){
        return (Optional<Product>) service.getProductById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return service.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updatedProduct){
        return service.updateProduct(id, updatedProduct)
                .orElseThrow(() -> new RuntimeException("Product not Found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteProduct(id);
    }
}
