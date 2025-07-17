package com.hipatiya.staj.model;

//this acts as an interface projection, only the name and price are seen and not the id
public interface ProductView {
    String getName();
    Integer getPrice();
}
