package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.store.type.DayType
import com.cooker.fooddelivery.core.store.type.WeekType
import javax.persistence.*

@Entity
class RegularHoliday(

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var week: WeekType,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var day: DayType,

    @ManyToOne(optional = false)
    val store: Store
) : EntityAuditing()