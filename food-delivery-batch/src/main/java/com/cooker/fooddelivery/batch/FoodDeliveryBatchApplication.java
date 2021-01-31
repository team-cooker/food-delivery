package com.cooker.fooddelivery.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FoodDeliveryBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryBatchApplication.class, args);
    }
}
