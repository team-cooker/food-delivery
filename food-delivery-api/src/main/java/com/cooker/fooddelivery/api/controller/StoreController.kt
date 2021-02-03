package com.cooker.fooddelivery.api.controller

import com.cooker.fooddelivery.api.dto.StoreCreateRequest
import com.cooker.fooddelivery.core.entity.Store
import com.cooker.fooddelivery.core.repository.StoreRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StoreController(
       private val storeRepository: StoreRepository
) {

    @PostMapping("/stores")
    fun create(@RequestBody storeCreateRequest: StoreCreateRequest) {
        val store = storeRepository.save(Store(name = storeCreateRequest.name!!))
    }
}
