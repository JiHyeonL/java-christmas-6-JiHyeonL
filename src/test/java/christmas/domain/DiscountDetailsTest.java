package christmas.domain;

import christmas.constant.DiscountEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountDetailsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private DiscountDetails discountDetails;
    private Map<DiscountEvent, Integer> discountAmount;
    @BeforeEach
    void setUp() {
        discountAmount = new HashMap<>();
    }

    @Test
    void 혜택내역_반환_3개만() {
        discountAmount.put(DiscountEvent.CHRISTMAS_D_DAY, -1100);
        discountAmount.put(DiscountEvent.WEEKDAY, 0);
        discountAmount.put(DiscountEvent.WEEKEND, 0);
        discountAmount.put(DiscountEvent.SPECIAL, -1000);
        discountAmount.put(DiscountEvent.GIVEAWAY, -25000);

        discountDetails = new DiscountDetails(discountAmount);
        String result = discountDetails.makeEventBenefitDetail();
        assertThat(result).contains("증정 이벤트: -25,000원");
        assertThat(result).contains("특별 할인: -1,000원");
        assertThat(result).contains("크리스마스 디데이 할인: -1,100원");
    }

    @Test
    void 혜택내역_아예없어서_없음반환() {
        discountAmount.put(DiscountEvent.CHRISTMAS_D_DAY, 0);
        discountAmount.put(DiscountEvent.WEEKDAY, 0);
        discountAmount.put(DiscountEvent.WEEKEND, 0);
        discountAmount.put(DiscountEvent.SPECIAL, 0);
        discountAmount.put(DiscountEvent.GIVEAWAY, 0);

        discountDetails = new DiscountDetails(discountAmount);
        String result = discountDetails.makeEventBenefitDetail();
        assertThat(result).contains("없음");
    }

    @Test
    void 총혜택_계산() {
        discountAmount.put(DiscountEvent.CHRISTMAS_D_DAY, -1100);
        discountAmount.put(DiscountEvent.WEEKDAY, 0);
        discountAmount.put(DiscountEvent.WEEKEND, 0);
        discountAmount.put(DiscountEvent.SPECIAL, -1000);
        discountAmount.put(DiscountEvent.GIVEAWAY, -25000);
        discountDetails = new DiscountDetails(discountAmount);

        int price = discountDetails.calculateTotalBenefit();
        assertThat(price).isEqualTo(-1100-1000-25000);
    }

    @Test
    void 할인금액_계산_증정메뉴가격_제외() {
        discountAmount.put(DiscountEvent.CHRISTMAS_D_DAY, -1100);
        discountAmount.put(DiscountEvent.WEEKDAY, 0);
        discountAmount.put(DiscountEvent.WEEKEND, 0);
        discountAmount.put(DiscountEvent.SPECIAL, -1000);
        discountAmount.put(DiscountEvent.GIVEAWAY, -25000);
        discountDetails = new DiscountDetails(discountAmount);

        int price = discountDetails.calculateBenefitForExpectedPayment();
        assertThat(price).isEqualTo(-1100-1000);
    }

}