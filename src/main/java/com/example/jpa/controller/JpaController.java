package com.example.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {

    @GetMapping("/main")
    public String main() {
        return "hello world";
    }
}