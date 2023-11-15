package christmas.constant;

import christmas.dto.CalculateEventDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountEventTest {

    private DiscountEvent discountEvent;
    private CalculateEventDto eventDto = new CalculateEventDto(11500);

    @Test
    void 크리스마스_12월_25일_할인가격() {
        eventDto.setDate(25);
        int price = discountEvent.CHRISTMAS_D_DAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(-3400);
    }

    @Test
    void 크리스마스_해당_안되는_날짜() {
        eventDto.setDate(30);
        int price = discountEvent.CHRISTMAS_D_DAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(0);
    }

    @Test
    void 평일할인_일요일_할인적용_디저트_3개() {
        eventDto.setDate(3);
        eventDto.setDessertCount(3);
        int price = discountEvent.WEEKDAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(-2023*3);
    }

    @Test
    void 평일할인_금요일_할인미적용() {
        eventDto.setDate(1);
        eventDto.setDessertCount(3);
        int price = discountEvent.WEEKDAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(0);
    }

    @Test
    void 주말할인_금요일_할인적용_메뉴_10개() {
        eventDto.setDate(1);
        eventDto.setMainCount(10);
        int price = discountEvent.WEEKEND.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(10 *  -2023);
    }

    @Test
    void 주말할인_일요일_할인미적용() {
        eventDto.setDate(10);
        eventDto.setMainCount(10);
        int price = discountEvent.WEEKEND.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(0);
    }

    @Test
    void 특별할인_24일_할인() {
        eventDto.setDate(24);
        int price = discountEvent.SPECIAL.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(-1000);
    }

    @Test
    void 특별할인_18일_미할인() {
        eventDto.setDate(18);
        int price = discountEvent.SPECIAL.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(0);
    }

    @Test
    void 증정이벤트_12만원_해당() {
        eventDto = new CalculateEventDto(120000);
        int price = discountEvent.GIVEAWAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(-25000);
    }

    @Test
    void 증정이벤트_11만원_미해당() {
        eventDto = new CalculateEventDto(110000);
        int price = discountEvent.GIVEAWAY.calculateDiscountAmount(eventDto);
        assertThat(price).isEqualTo(0);
    }
}