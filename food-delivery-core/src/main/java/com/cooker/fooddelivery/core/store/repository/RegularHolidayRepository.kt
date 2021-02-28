package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.entity.RegularHoliday
import org.springframework.data.jpa.repository.JpaRepository

interface RegularHolidayRepository : JpaRepository<RegularHoliday, Long>