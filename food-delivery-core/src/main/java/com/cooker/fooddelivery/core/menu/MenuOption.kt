package com.cooker.fooddelivery.core.menu

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class MenuOption(

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Long,

    @ManyToOne(optional = false)
    val menuOptionCategory: MenuOptionCategory

) : EntityAuditing()