package com.cooker.fooddelivery.core.menu

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class MenuCategory(

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val storeId: Long
) : EntityAuditing()