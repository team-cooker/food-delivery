package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.common.type.YnType
import java.time.LocalDateTime
import java.time.LocalTime
import javax.persistence.*

@Entity
class BusinessHour(

    @Column(nullable = false)
    var weekdayOpenAt: LocalTime,

    @Column(nullable = false)
    var weekdayCloseAt: LocalTime,

    @Column(nullable = false)
    var weekendOpenAt: LocalTime,

    @Column(nullable = false)
    var weekendCloseAt: LocalTime,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var holidayOpenYn: YnType,

    @OneToOne(optional = false)
    val store: Store,
) : EntityAuditing()