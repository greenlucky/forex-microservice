package com.devopslam.forexservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("")
    public String index() {
        return "Hello, I'm the Forex Service";
    }
}
