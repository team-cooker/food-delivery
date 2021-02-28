package com.cooker.fooddelivery.core.store.repository

import com.cooker.fooddelivery.core.store.EntityMocks
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor

@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class StoreRepositoryTest(
    val storeRepository: StoreRepository
) {

    @Test
    fun save() {
        val store = storeRepository.save(
            EntityMocks.storeMock()
        )

        assertThat(store.id).isNotNull()
    }
}