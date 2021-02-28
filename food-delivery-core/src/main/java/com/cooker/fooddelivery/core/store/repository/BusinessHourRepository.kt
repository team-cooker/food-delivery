package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.entity.BusinessHour
import org.springframework.data.jpa.repository.JpaRepository

interface BusinessHourRepository : JpaRepository<BusinessHour, Long>