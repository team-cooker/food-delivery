package com.cooker.fooddelivery.core.entity

import javax.persistence.Entity

@Entity
class Store(
        var name: String
) : EntityAuditing()