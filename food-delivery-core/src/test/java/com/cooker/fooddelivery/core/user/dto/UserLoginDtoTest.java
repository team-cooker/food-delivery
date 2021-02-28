package com.cooker.fooddelivery.core.user.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserLoginDtoTest {

    @Test
    void create_user_login_dto() {
        UserLoginDto userLoginDto = new UserLoginDto("hang19663@gmail.com", "temp");
        assertThat(userLoginDto).isNotNull();
        assertThat(userLoginDto.getEmail()).isEqualTo("hang19663@gmail.com");
        assertThat(userLoginDto.getPassword()).isEqualTo("temp");
    }

}
