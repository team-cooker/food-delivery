package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.EntityMocks
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class BusinessHourRepositoryTest(
    val storeRepository: StoreRepository,
    val businessHourRepository: BusinessHourRepository
) {

    @Test
    fun save() {
        val store = storeRepository.save(EntityMocks.storeMock())

        val businessHour = businessHourRepository.save(
            EntityMocks.businessHourMock(store)
        )

        assertThat(businessHour.id).isNotNull()
        assertThat(businessHour.store.id).isEqualTo(store.id)
    }
}