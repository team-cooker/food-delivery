package com.cooker.fooddelivery.core.user.entity;

import com.cooker.fooddelivery.core.common.entity.BaseEntity;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class User extends BaseEntity {

    private static final String EMPTY_USER_NAME_MESSAGE = "user name must not be empty";
    private static final String EMPTY_USER_EMAIL_MESSAGE = "user email must not be empty";
    private static final String EMPTY_USER_NICKNAME_MESSAGE = "user nickname must not be empty";
    private static final String EMPTY_USER_PASSWORD_MESSAGE = "user password must not be empty";

    @NotEmpty
    @Column(nullable = false, length = 20)
    private String name;

    @NotEmpty
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false, length = 15)
    private String nickname;

    @NotEmpty
    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    private String birthDay;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    private User(Builder builder) {
        Assert.hasText(builder.name, EMPTY_USER_NAME_MESSAGE);
        Assert.hasText(builder.email, EMPTY_USER_EMAIL_MESSAGE);
        Assert.hasText(builder.nickname, EMPTY_USER_NICKNAME_MESSAGE);
        Assert.hasText(builder.password, EMPTY_USER_PASSWORD_MESSAGE);

        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.platform = builder.platform;
        this.birthDay = builder.birthDay;
        this.role = builder.role;
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

    public Platform getPlatform() {
        return platform;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public Role getRole() {
        return role;
    }

    protected static class Builder {
        private String name;
        private String email;
        private String nickname;
        private String password;
        private Platform platform;
        private String birthDay;
        private Role role;

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

        public Builder platform(Platform platform) {
            this.platform = platform;
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

        public User build() {
            return new User(this);
        }

    }
}
