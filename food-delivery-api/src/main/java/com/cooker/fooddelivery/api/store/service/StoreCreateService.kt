package com.cooker.fooddelivery.api.store.service

import com.cooker.fooddelivery.api.store.dto.StoreCreateRequest
import com.cooker.fooddelivery.core.store.repository.BusinessHourRepository
import com.cooker.fooddelivery.core.store.repository.DeliveryAreaRepository
import com.cooker.fooddelivery.core.store.repository.RegularHolidayRepository
import com.cooker.fooddelivery.core.store.repository.StoreRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class StoreCreateService(
    val storeRepository: StoreRepository,
    val businessHourRepository: BusinessHourRepository,
    val regularHolidayRepository: RegularHolidayRepository,
    val deliveryAreaRepository: DeliveryAreaRepository
) {

    @Transactional
    fun create(storeCreateRequest: StoreCreateRequest) {
        val store = storeRepository.save(
            storeCreateRequest.store.toStore()
        )

        businessHourRepository.save(
            storeCreateRequest.businessHour.toBusinessHour(store)
        )

        storeCreateRequest.regularHolidays
            .map { it.toRegularHoliday(store) }
            .map { regularHolidayRepository.save(it) }

        storeCreateRequest.deliveryAreas
            .map { it.toDeliveryArea(store) }
            .map { deliveryAreaRepository.save(it) }
    }
}
