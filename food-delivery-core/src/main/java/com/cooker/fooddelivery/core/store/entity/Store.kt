package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.store.type.CustomerReceiveType
import com.cooker.fooddelivery.core.store.type.FoodCategoryType
import com.cooker.fooddelivery.core.store.type.MeetPayType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Store(
    var name: String,

    @Enumerated(EnumType.STRING)
    val category: FoodCategoryType,
    val bizRegNo: String,
    var tel: String,
    var address: String,
    var description: String,
    var minOrderAmount: Int,
    var deliveryTip: Int,
    var alcoholicBeverageYn: Int,

    @Enumerated(EnumType.STRING)
    var meetPayType: MeetPayType,

    @Enumerated(EnumType.STRING)
    var customerReceiveType: CustomerReceiveType
) : EntityAuditing()