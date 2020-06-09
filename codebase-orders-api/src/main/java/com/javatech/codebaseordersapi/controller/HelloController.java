package com.javatech.codebaseordersapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello from order service";
    }
}
