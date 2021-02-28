package com.cooker.fooddelivery.core.user.dto;

import org.springframework.util.Assert;

public class UserLoginDto {

    private static final String EMPTY_USER_ATTRIBUTE_MESSAGE = "user %s must not be empty";

    // TODO : Validation
    private final String email;
    private final String password;

    public UserLoginDto(String email, String password) {
        Assert.hasText(email, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "email"));
        Assert.hasText(password, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "password"));

        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
