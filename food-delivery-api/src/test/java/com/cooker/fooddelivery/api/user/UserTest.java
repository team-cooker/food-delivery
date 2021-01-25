package com.cooker.fooddelivery.api.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void create() {
        User user = new User("cooker");
        assertThat(user.getName()).isEqualTo("cooker");
    }
}
