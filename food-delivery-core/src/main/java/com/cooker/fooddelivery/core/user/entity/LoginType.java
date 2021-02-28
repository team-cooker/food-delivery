package com.cooker.fooddelivery.core.user.entity;

public enum LoginType {
    EMAIL("EMAIL");

    private final String platform;

    LoginType(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
