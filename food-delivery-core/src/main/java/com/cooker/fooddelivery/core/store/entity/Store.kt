package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.common.type.YnType
import com.cooker.fooddelivery.core.store.type.CustomerReceiveType
import com.cooker.fooddelivery.core.store.type.FoodCategoryType
import com.cooker.fooddelivery.core.store.type.MeetPayType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Store(
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val category: FoodCategoryType,

    @Column(nullable = false)
    val bizRegNo: String,

    @Column(nullable = false)
    var tel: String,

    @Column(nullable = false)
    var address: String,

    var description: String? = null,

    @Column(nullable = false)
    var minOrderAmount: Int,

    @Column(nullable = false)
    var deliveryTip: Int,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var alcoholicBeverageYn: YnType,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var meetPayType: MeetPayType,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var customerReceiveType: CustomerReceiveType
) : EntityAuditing()