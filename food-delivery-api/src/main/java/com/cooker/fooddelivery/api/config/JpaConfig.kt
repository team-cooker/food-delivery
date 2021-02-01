package com.cooker.fooddelivery.api.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

const val basePackage = "com.cooker.fooddelivery.core"

@Configuration
@EntityScan(basePackages = [basePackage])
@EnableJpaRepositories(basePackages = [basePackage])
class JpaConfig