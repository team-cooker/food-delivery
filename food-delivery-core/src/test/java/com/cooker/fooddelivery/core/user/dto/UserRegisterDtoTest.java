package com.cooker.fooddelivery.core.user.dto;

import com.cooker.fooddelivery.core.user.entity.LoginType;
import com.cooker.fooddelivery.core.user.entity.Role;
import com.cooker.fooddelivery.core.user.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UserRegisterDtoTest {

    @Test
    void create_user_register_dto() {
        UserRegisterDto userRegisterDto = UserRegisterDto.builder()
                .name("임한결")
                .email("hang19663@gmail.com")
                .nickname("tommy")
                .password("temp")
                .birthDay("1995-01-09")
                .build();

        assertThat(userRegisterDto).isNotNull();
        assertThat(userRegisterDto.getName()).isEqualTo("임한결");
        assertThat(userRegisterDto.getEmail()).isEqualTo("hang19663@gmail.com");
        assertThat(userRegisterDto.getNickname()).isEqualTo("tommy");
    }

    @Test
    void user_register_dto_create_failure() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> UserRegisterDto.builder().build());
    }

    @Test
    void invalid_name_user_register_dto() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                UserRegisterDto.builder()
                        .email("hang19663@gmail.com")
                        .nickname("tommy")
                        .password("temp")
                        .birthDay("1995-01-09")
                        .build()).withMessage("user name must not be empty");
    }

    @Test
    void invalid_email_user_register_dto() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                UserRegisterDto.builder()
                        .name("임한결")
                        .nickname("tommy")
                        .password("temp")
                        .birthDay("1995-01-09")
                        .build()).withMessage("user email must not be empty");
    }

    @Test
    void invalid_nickname_user_register_dto() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                UserRegisterDto.builder()
                        .name("임한결")
                        .email("hang19663@gmail.com")
                        .password("temp")
                        .birthDay("1995-01-09")
                        .build()).withMessage("user nickname must not be empty");
    }

    @Test
    void invalid_password_user_register_dto() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                UserRegisterDto.builder()
                        .name("임한결")
                        .email("hang19663@gmail.com")
                        .nickname("tommy")
                        .birthDay("1995-01-09")
                        .build()).withMessage("user password must not be empty");
    }

    @Test
    void user_register_dto_to_entity() {
        User user = UserRegisterDto.builder()
                .name("임한결")
                .email("hang19663@gmail.com")
                .nickname("tommy")
                .password("temp")
                .birthDay("1995-01-09")
                .build()
                .toEntity();

        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("임한결");
        assertThat(user.getRole()).isEqualTo(Role.USER);
        assertThat(user.getLoginType()).isEqualTo(LoginType.EMAIL);
    }
}
