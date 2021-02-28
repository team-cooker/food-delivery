package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.EntityMocks
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class RegularHolidayRepositoryTest(
    val storeRepository: StoreRepository,
    val regularHolidayRepository: RegularHolidayRepository
) {

    @Test
    fun save() {
        val store = storeRepository.save(EntityMocks.storeMock())

        val regularHoliday = regularHolidayRepository.save(
            EntityMocks.regularHolidayMock(store)
        )

        assertThat(regularHoliday.id).isNotNull()
        assertThat(regularHoliday.store.id).isEqualTo(store.id)
    }
}