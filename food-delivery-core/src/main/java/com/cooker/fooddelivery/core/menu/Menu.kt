package com.cooker.fooddelivery.core.menu

import com.cooker.fooddelivery.core.common.entity.EntityAuditing
import com.cooker.fooddelivery.core.common.type.YnType
import javax.persistence.*

@Entity
class Menu(

    @ManyToOne(optional = false)
    val menuCategory: MenuCategory,

    @Column(nullable = false)
    val name: String,

    val description: String,

    @Column(nullable = false)
    val price: Long,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val soldOutYn: YnType,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val popularityYn: YnType,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val mainMenuYn: YnType

) : EntityAuditing()