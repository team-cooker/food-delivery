package com.cooker.fooddelivery.core.user.entity;

public enum Role {
    USER("ROLE_USER", "사용자"),
    CEO("ROLE_CEO", "사장"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String grade;

    Role(String key, String grade) {
        this.key = key;
        this.grade = grade;
    }

    public String getKey() {
        return key;
    }

    public String getGrade() {
        return grade;
    }
}
