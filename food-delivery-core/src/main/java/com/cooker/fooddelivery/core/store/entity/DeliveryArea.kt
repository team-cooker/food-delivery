package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.store.type.DeliveryAreaType
import javax.persistence.*

@Entity
class DeliveryArea(

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: DeliveryAreaType,

    var radius: String? = null,
    var region: String? = null,

    @ManyToOne(optional = false)
    val store: Store,
) : EntityAuditing()