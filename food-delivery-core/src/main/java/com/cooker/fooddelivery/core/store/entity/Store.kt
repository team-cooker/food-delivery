package com.cooker.fooddelivery.core.store.entity

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import javax.persistence.Entity

@Entity
class Store(
        var name: String
) : EntityAuditing()