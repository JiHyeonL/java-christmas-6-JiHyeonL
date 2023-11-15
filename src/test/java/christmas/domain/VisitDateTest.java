package christmas.domain;

import christmas.constant.DiscountEvent;
import christmas.dto.CalculateEventDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class VisitDateTest {
    private VisitDate visitDate;

    @Test
    void 할인금액_계산() {
        CalculateEventDto eventParameter = new CalculateEventDto(11500);
        eventParameter.setDessertCount(0);
        eventParameter.setMainCount(0);
        eventParameter.setIsEventActive(true);
        visitDate = new VisitDate(21);

        Map<DiscountEvent, Integer> result = visitDate.getCalculatedDiscount(eventParameter);
        Map<DiscountEvent, Integer> answer = new HashMap<>();
        answer.put(DiscountEvent.CHRISTMAS_D_DAY, -1000 - 100*20);
        answer.put(DiscountEvent.WEEKDAY, 0);
        answer.put(DiscountEvent.WEEKEND, 0);
        answer.put(DiscountEvent.SPECIAL, 0);
        answer.put(DiscountEvent.GIVEAWAY, 0);

        assertThat(result).isEqualTo(answer);
    }
}