package com.cooker.fooddelivery.api.store.controller

import com.cooker.fooddelivery.api.store.dto.StoreCreateRequest
import com.cooker.fooddelivery.core.store.entity.Store
import com.cooker.fooddelivery.core.store.repository.StoreRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StoreController(
    val storeRepository: StoreRepository
) {

    @PostMapping("/stores")
    fun create(@RequestBody storeCreateRequest: StoreCreateRequest) {
        val store = storeRepository.save(Store(name = storeCreateRequest.name))
    }
}
