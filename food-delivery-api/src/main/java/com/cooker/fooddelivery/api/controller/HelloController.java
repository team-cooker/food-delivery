package com.cooker.fooddelivery.api.controller;

import com.cooker.fooddelivery.api.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name) {
        return new User(name);
    }
}
