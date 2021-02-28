package com.cooker.fooddelivery.core.user.dto;

import com.cooker.fooddelivery.core.user.entity.LoginType;
import com.cooker.fooddelivery.core.user.entity.Role;
import com.cooker.fooddelivery.core.user.entity.User;
import org.springframework.util.Assert;

public class UserRegisterDto {

    private static final String EMPTY_USER_ATTRIBUTE_MESSAGE = "user %s must not be empty";
    // TODO : Validation
    private final String name;
    private final String email;
    private final String nickname;
    private final String password;
    private final String birthDay;

    private UserRegisterDto(Builder builder) {
        Assert.hasText(builder.name, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "name"));
        Assert.hasText(builder.email, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "email"));
        Assert.hasText(builder.nickname, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "nickname"));
        Assert.hasText(builder.password, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "password"));

        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.password = builder.password;
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

        public Builder birthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public UserRegisterDto build() {
            return new UserRegisterDto(this);
        }

    }
}
