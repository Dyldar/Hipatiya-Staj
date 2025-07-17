package com.hipatiya.staj.model;

import jakarta.persistence.*;
import jdk.jfr.Relational;
//import org.springframework.data.annotation.Id; OMG UGLYYYYYYYYY

@Entity
@Table(name="product", schema="e_commerce")
public class Product {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "price")
    private Integer price;

    public Product(){}

    public Product (String name, Integer price){
        this.name=name;
        this.price=price;
    }


    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
