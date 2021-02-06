package com.cooker.fooddelivery.core.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class EntityAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreatedDate
    @Column(nullable = false)
    lateinit var createdAt: Instant
        protected set

    @LastModifiedDate
    @Column(nullable = false)
    lateinit var updatedAt: Instant
        protected set
}