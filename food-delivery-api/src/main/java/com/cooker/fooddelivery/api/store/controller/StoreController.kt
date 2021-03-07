package com.cooker.fooddelivery.api.store.controller

import com.cooker.fooddelivery.api.store.dto.StoreCreateRequest
import com.cooker.fooddelivery.api.store.service.StoreCreateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class StoreController(
    val storeCreateService: StoreCreateService
) {

    @PostMapping("/stores")
    fun create(@RequestBody storeCreateRequest: StoreCreateRequest): ResponseEntity<Void> {
        storeCreateService.create(storeCreateRequest)

        return ResponseEntity.ok().build()
    }
}
