package com.cooker.fooddelivery.core.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloTest {

    @Test
    void create() {
        Hello hello = new Hello("cooker");
        assertThat(hello.getName()).isEqualTo("cooker");
    }
}
