package com.cooker.fooddelivery.core.user.dto;

import com.cooker.fooddelivery.core.user.entity.LoginType;
import com.cooker.fooddelivery.core.user.entity.Role;
import com.cooker.fooddelivery.core.user.entity.User;

public class UserRegisterDto {

    private final String name;
    private final String email;
    private final String nickname;
    private final String password;
    private final LoginType loginType;
    private final String birthDay;

    public UserRegisterDto(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.loginType = builder.loginType;
        this.birthDay = builder.birthDay;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public LoginType getPlatform() {
        return loginType;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .nickname(nickname)
                .password(password)
                .loginType(LoginType.EMAIL)
                .birthDay(birthDay)
                .role(Role.USER)
                .build();
    }

    public static class Builder {
        private String name;
        private String email;
        private String nickname;
        private String password;
        private LoginType loginType;
        private String birthDay;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder loginType(LoginType loginType) {
            this.loginType = loginType;
            return this;
        }

        public Builder birthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public UserRegisterDto build() {
            return new UserRegisterDto(this);
        }

    }
}
