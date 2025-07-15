package com.hipatiya.staj.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.hipatiya.staj.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired //constructor injection
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.greet();
    }
}