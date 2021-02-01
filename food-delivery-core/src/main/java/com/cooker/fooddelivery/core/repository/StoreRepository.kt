package com.cooker.fooddelivery.core.repository

import com.cooker.fooddelivery.core.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long>