package com.hipatiya.staj.repository;

import com.hipatiya.staj.model.Product;
import com.hipatiya.staj.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);

    List<Product> findByPriceGreaterThan(double price);

    @Query("SELECT p.name AS name, p.price AS price FROM Product p")
    List<ProductView> findProductViews();
}
