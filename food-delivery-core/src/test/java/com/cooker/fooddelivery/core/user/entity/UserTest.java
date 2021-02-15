package com.cooker.fooddelivery.core.user.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserTest {

    @Test
    void user_create() {
        final User user = User.builder()
                .name("hangyeol")
                .email("dlagksruf19@naver.com")
                .nickname("tommy")
                .password("1234")
                .platform(Platform.EMAIL)
                .birthDay("19950109")
                .role(Role.USER)
                .build();

        assertAll(() -> {
            assertThat(user).isNotNull();
            assertThat(user.getName()).isEqualTo("hangyeol");
            assertThat(user.getEmail()).isEqualTo("dlagksruf19@naver.com");
            assertThat(user.getNickname()).isEqualTo("tommy");
            assertThat(user.getPassword()).isEqualTo("1234");
        });
    }

    @Test
    void user_create_failure() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> User.builder().build());
    }

    @Test
    void user_name_empty_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> User.builder()
                        .email("dlagksruf19@naver.com")
                        .nickname("tommy")
                        .password("1234")
                        .platform(Platform.EMAIL)
                        .birthDay("19950109")
                        .role(Role.USER)
                        .build()
                ).withMessage("user name must not be empty");
    }

    @Test
    void user_email_empty_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> User.builder()
                        .name("hangyeol")
                        .nickname("tommy")
                        .password("1234")
                        .platform(Platform.EMAIL)
                        .birthDay("19950109")
                        .role(Role.USER)
                        .build()
                ).withMessage("user email must not be empty");
    }

    @Test
    void user_nickname_empty_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> User.builder()
                        .name("hangyeol")
                        .email("dlagksruf19@naver.com")
                        .password("1234")
                        .platform(Platform.EMAIL)
                        .birthDay("19950109")
                        .role(Role.USER)
                        .build()
                ).withMessage("user nickname must not be empty");
    }

    @Test
    void user_password_empty_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> User.builder()
                        .name("hangyeol")
                        .email("dlagksruf19@naver.com")
                        .nickname("tommy")
                        .platform(Platform.EMAIL)
                        .birthDay("19950109")
                        .role(Role.USER)
                        .build()
                ).withMessage("user password must not be empty");
    }

}
