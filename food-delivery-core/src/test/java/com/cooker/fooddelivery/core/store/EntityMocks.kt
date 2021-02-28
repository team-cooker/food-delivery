package com.cooker.fooddelivery.core.store

import com.cooker.fooddelivery.core.common.type.YnType
import com.cooker.fooddelivery.core.store.entity.BusinessHour
import com.cooker.fooddelivery.core.store.entity.DeliveryArea
import com.cooker.fooddelivery.core.store.entity.RegularHoliday
import com.cooker.fooddelivery.core.store.entity.Store
import com.cooker.fooddelivery.core.store.type.*
import java.time.LocalTime

object EntityMocks {

    fun storeMock(): Store {
        return Store(
            name = "starbucks",
            category = FoodCategoryType.CAFE_DESSERT,
            bizRegNo = "1234567891",
            tel = "01012345678",
            address = "진접 맥도날드 옆",
            minOrderAmount = 10000,
            deliveryTip = 2000,
            alcoholicBeverageYn = YnType.N,
            meetPayType = MeetPayType.CASH_AND_CARD,
            customerReceiveType = CustomerReceiveType.TAKE_OUT
        )
    }

    fun regularHolidayMock(store: Store): RegularHoliday {
        return RegularHoliday(
            week = WeekType.FIFTH_WEEK,
            day = DayType.MONDAY,
            store = store
        )
    }

    fun deliveryAreaMock(store: Store): DeliveryArea {
        return DeliveryArea(
            type = DeliveryAreaType.RADIUS,
            radius = "122.20",
            store = store
        )
    }

    fun businessHourMock(store: Store): BusinessHour {
        return BusinessHour(
            weekdayOpenAt = LocalTime.parse("10:30:30"),
            weekdayCloseAt = LocalTime.parse("20:50:00"),
            weekendOpenAt = LocalTime.parse("12:00:00"),
            weekendCloseAt = LocalTime.MAX,
            holidayOpenYn = YnType.N,
            store = store
        )
    }
}