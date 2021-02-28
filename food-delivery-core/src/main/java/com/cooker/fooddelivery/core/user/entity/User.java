package com.cooker.fooddelivery.core.user.entity;

import com.cooker.fooddelivery.core.common.entity.BaseEntity;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
public class User extends BaseEntity {

    private static final String EMPTY_USER_ATTRIBUTE_MESSAGE = "user %s must not be empty";

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String nickname;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    private String birthDay;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String token;

    public User() {
    }

    private User(Builder builder) {
        Assert.hasText(builder.name, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "name"));
        Assert.hasText(builder.email, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "email"));
        Assert.hasText(builder.nickname, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "nickname"));
        Assert.hasText(builder.password, String.format(EMPTY_USER_ATTRIBUTE_MESSAGE, "password"));

        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.loginType = builder.loginType;
        this.birthDay = builder.birthDay;
        this.role = builder.role;
        this.token = builder.token;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public Role getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

    public static class Builder {
        private String name;
        private String email;
        private String nickname;
        private String password;
        private LoginType loginType;
        private String birthDay;
        private Role role;
        private String token;

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

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
