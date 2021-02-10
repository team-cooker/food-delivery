package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long>