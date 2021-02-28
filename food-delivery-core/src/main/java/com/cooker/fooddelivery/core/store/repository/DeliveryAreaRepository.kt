package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.entity.DeliveryArea
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryAreaRepository : JpaRepository<DeliveryArea, Long>