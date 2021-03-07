package com.cooker.fooddelivery.api.store.controller

import com.cooker.fooddelivery.api.store.dto.*
import com.cooker.fooddelivery.api.store.service.StoreCreateService
import com.cooker.fooddelivery.core.common.type.YnType
import com.cooker.fooddelivery.core.store.type.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.willDoNothing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalTime

@WebMvcTest
@AutoConfigureRestDocs
internal class StoreControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockBean
    lateinit var storeCreateService: StoreCreateService

    @Test
    fun create() {
        val storeCreateRequest = storeCreateRequestMock()

        willDoNothing()
            .given(storeCreateService)
            .create(storeCreateRequest)

        mockMvc.perform(
            post("/api/v1/stores")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(storeCreateRequest))
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "store",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    requestFields(
                        fieldWithPath("store.name")
                            .description("가게 이름"),
                        fieldWithPath("store.category")
                            .description("가게 카테고리"),
                        fieldWithPath("store.bizRegNo")
                            .description("사업자 번호"),
                        fieldWithPath("store.tel")
                            .description("가게 전화번호"),
                        fieldWithPath("store.address")
                            .description("가게 주소"),
                        fieldWithPath("store.description")
                            .description("가게 설명")
                            .optional(),
                        fieldWithPath("store.minOrderAmount")
                            .description("최소 주문금액"),
                        fieldWithPath("store.deliveryTip")
                            .description("배달 요금"),
                        fieldWithPath("store.alcoholicBeverageYn")
                            .description("주류 판매여부"),
                        fieldWithPath("store.meetPayType")
                            .description("만나서 결제 타입"),
                        fieldWithPath("store.customerReceiveType")
                            .description("소비자 수령 타입"),
                        fieldWithPath("businessHour.weekdayOpenAt")
                            .description("평일 여는 시간"),
                        fieldWithPath("businessHour.weekdayCloseAt")
                            .description("평일 닫는 시간 "),
                        fieldWithPath("businessHour.weekendOpenAt")
                            .description("주말 여는 시간"),
                        fieldWithPath("businessHour.weekendCloseAt")
                            .description("주말 닫는 시간"),
                        fieldWithPath("businessHour.holidayOpenYn")
                            .description("공휴일 휴무 여부"),
                        fieldWithPath("deliveryAreas.[].type")
                            .description("배달 지역 타입"),
                        fieldWithPath("deliveryAreas.[].radius")
                            .description("배달 반경")
                            .optional(),
                        fieldWithPath("deliveryAreas.[].region")
                            .description("배달 지역")
                            .optional(),
                        fieldWithPath("regularHolidays.[].week")
                            .description("정기 휴무일 주"),
                        fieldWithPath("regularHolidays.[].day")
                            .description("정기 휴무일 일")
                    )
                )
            )
    }

    private fun storeCreateRequestMock(): StoreCreateRequest =
        StoreCreateRequest(
            store = StoreDto(
                name = "starbucks",
                category = FoodCategoryType.CAFE_DESSERT,
                bizRegNo = "1234567891",
                tel = "01012345678",
                address = "진접 맥도날드 옆",
                minOrderAmount = 10000,
                deliveryTip = 2000,
                alcoholicBeverageYn = YnType.N,
                meetPayType = MeetPayType.CASH_AND_CARD,
                customerReceiveType = CustomerReceiveType.TAKE_OUT
            ),
            businessHour = BusinessHourDto(
                weekdayOpenAt = LocalTime.parse("10:30:30"),
                weekdayCloseAt = LocalTime.parse("20:50:00"),
                weekendOpenAt = LocalTime.parse("12:00:00"),
                weekendCloseAt = LocalTime.MAX,
                holidayOpenYn = YnType.N
            ),
            deliveryAreas = listOf(
                DeliveryAreaDto(
                    type = DeliveryAreaType.RADIUS,
                    radius = "122.20"
                )
            ),
            regularHolidays = listOf(
                RegularHolidayDto(
                    week = WeekType.FIFTH_WEEK,
                    day = DayType.MONDAY
                )
            )
        )
}