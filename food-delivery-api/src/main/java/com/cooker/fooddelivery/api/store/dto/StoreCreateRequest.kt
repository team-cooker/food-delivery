package com.cooker.fooddelivery.api.store.dto

import com.cooker.fooddelivery.core.store.dto.BusinessHourDto
import com.cooker.fooddelivery.core.store.dto.DeliveryAreaDto
import com.cooker.fooddelivery.core.store.dto.RegularHolidayDto
import com.cooker.fooddelivery.core.store.dto.StoreDto

data class StoreCreateRequest(

    val store: StoreDto,
    val businessHour: BusinessHourDto,
    val deliveryAreas: List<DeliveryAreaDto>,
    val regularHolidays: List<RegularHolidayDto>
)