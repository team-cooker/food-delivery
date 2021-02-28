package com.cooker.fooddelivery.core.store.dto

import com.cooker.fooddelivery.core.common.type.YnType
import com.cooker.fooddelivery.core.store.entity.BusinessHour
import com.cooker.fooddelivery.core.store.entity.DeliveryArea
import com.cooker.fooddelivery.core.store.entity.RegularHoliday
import com.cooker.fooddelivery.core.store.entity.Store
import com.cooker.fooddelivery.core.store.type.*
import java.time.LocalTime

data class StoreDto(
    var name: String,
    val category: FoodCategoryType,
    val bizRegNo: String,
    var tel: String,
    var address: String,
    var description: String? = null,
    var minOrderAmount: Int,
    var deliveryTip: Int,
    var alcoholicBeverageYn: YnType,
    var meetPayType: MeetPayType,
    var customerReceiveType: CustomerReceiveType
) {
    fun toStore(): Store {
        return Store(
            name = name,
            category = category,
            bizRegNo = bizRegNo,
            tel = tel,
            address = address,
            description = description,
            minOrderAmount = minOrderAmount,
            deliveryTip = deliveryTip,
            alcoholicBeverageYn = alcoholicBeverageYn,
            meetPayType = meetPayType,
            customerReceiveType = customerReceiveType
        )
    }
}

data class BusinessHourDto(

    var weekdayOpenAt: LocalTime,
    var weekdayCloseAt: LocalTime,
    var weekendOpenAt: LocalTime,
    var weekendCloseAt: LocalTime,
    var holidayOpenYn: YnType,
) {
    fun toBusinessHour(store: Store): BusinessHour {
        return BusinessHour(
            weekdayOpenAt = weekdayOpenAt,
            weekdayCloseAt = weekdayCloseAt,
            weekendOpenAt = weekendOpenAt,
            weekendCloseAt = weekendCloseAt,
            holidayOpenYn = holidayOpenYn,
            store = store
        )
    }
}

data class DeliveryAreaDto(
    val type: DeliveryAreaType,
    var radius: String? = null,
    var region: String? = null
) {
    fun toDeliveryArea(store: Store): DeliveryArea {
        return DeliveryArea(
            type = type,
            radius = radius,
            region = region,
            store = store
        )
    }
}

data class RegularHolidayDto(
    var week: WeekType,
    var day: DayType
) {
    fun toRegularHoliday(store: Store): RegularHoliday {
        return RegularHoliday(
            week = week,
            day = day,
            store = store
        )
    }
}