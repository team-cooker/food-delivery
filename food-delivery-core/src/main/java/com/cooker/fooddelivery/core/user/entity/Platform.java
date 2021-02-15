package com.cooker.fooddelivery.core.user.entity;

public enum Platform {
    EMAIL("EMAIL");

    private final String platform;

    Platform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
