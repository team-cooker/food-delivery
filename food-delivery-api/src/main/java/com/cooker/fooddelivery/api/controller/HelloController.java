package com.cooker.fooddelivery.api.controller;

import com.cooker.fooddelivery.core.dto.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public Hello hello() {
        return new Hello("hi");
    }
}
