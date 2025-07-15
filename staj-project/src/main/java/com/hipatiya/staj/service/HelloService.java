package com.hipatiya.staj.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String greet() {
        return "Merhaba Hipatiya!";
    }
}