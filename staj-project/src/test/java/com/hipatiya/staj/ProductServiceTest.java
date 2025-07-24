package com.hipatiya.staj;

import com.hipatiya.staj.model.Product;
import com.hipatiya.staj.repository.ProductRepository;
import com.hipatiya.staj.service.ProductService;
import org.junit.jupiter.api.BeforeEach; // For JUnit 5
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private ProductRepository productRepositoryMock;
    private ProductService productService;

    @BeforeEach
    public void setup(){
        productRepositoryMock = mock(ProductRepository.class);
        productService = new ProductService(productRepositoryMock);
    }
////////////////////////////////////////////////////////////////////////////////
    //get all products
    @Test
    public void getAllProductsTrue(){
        List<Product> productsList = List.of(new Product("nameall", 12.0));
        when(productRepositoryMock.findAll()).thenReturn(productsList);

        List<Product> result = productService.getAllProducts();
        assertTrue(result.size()==1 && result.get(0).getName().equals("nameall"));
    }
    @Test
    public void getAllProductsFalse(){
        List<Product> productsList = List.of(new Product("nameall", 12.0));
        when(productRepositoryMock.findAll()).thenReturn(productsList);

        List<Product> result = productService.getAllProducts();
        assertFalse(result.size()==1 && result.get(0).getName().equals("noall"));
    }
////////////////////////////////////////////////////////////////////////////////
    // get product by id
    @Test
    public void getProductByIdTrue(){
        Product mockProductWithId = new Product("nameid", 5.0);
        mockProductWithId.setId(1L);
        when(productRepositoryMock.findById(1L)).thenReturn(Optional.of(mockProductWithId));

        Optional<Product> result = productService.getProductById(1L);
        assertTrue(result.isPresent()); // check Optional is not empty
        assertEquals(1L, result.get().getId()); //checks id is same
    }
    // product not present
    @Test
    public void getProductByIDNotPresent(){
        when(productRepositoryMock.findById(1L)).thenReturn(Optional.empty());

        Optional<Product> result = productService.getProductById(1L);
        assertFalse(result.isPresent()); // check Optional is empty
    }
    //id false
    @Test
    public void getProductByIDFalse(){
        Product mockProductWithId = new Product("nameid", 5.0);
        mockProductWithId.setId(1L);
        when(productRepositoryMock.findById(1L)).thenReturn(Optional.of(mockProductWithId));

        Optional<Product> result = productService.getProductById(1L);
        assertTrue(result.isPresent()); // check Optional is not empty
        assertNotEquals(2L, result.get().getId()); //checks id is NOT THE same
    }
////////////////////////////////////////////////////////////////////////////////
    //get product by name
    @Test
    public void getProductByNameTrue(){
        Product mockProductWithName = new Product("namename", 5.0);

        when(productRepositoryMock.findByName("namename")).thenReturn(Optional.of(mockProductWithName));

        Optional<Product> result = Optional.ofNullable(productService.getProductByName("namename"));
        assertEquals(true, result.isPresent()); // check Optional is not empty
        assertEquals("namename", result.get().getName()); //checks id is same
    }

}
