package christmas.domain;

import christmas.constant.DiscountEvent;
import christmas.constant.ErrorMessage;
import christmas.constant.MagicNumber;
import christmas.constant.PlannerMessage;
import christmas.dto.CalculateEventDto;

import java.util.HashMap;
import java.util.Map;

public class VisitDate {
    private final int date;

    public VisitDate(int date) {
        validate(date);
        this.date = date;
    }

    public String announceEventBenefitWithDate() {
        return PlannerMessage.makeAnnounceEventBenefitDetail(date);
    }

    public Map<DiscountEvent, Integer> getCalculatedDiscount(CalculateEventDto eventParameter) {
        Map<DiscountEvent, Integer> result = new HashMap<>();
        eventParameter.setDate(date);

        for (DiscountEvent event : DiscountEvent.values()) {
            int price = event.calculateDiscountAmount(eventParameter);
            result.put(event, price);
        }

        return result;
    }

    private void validate(int date) {
        checkInRange(date);
    }

    private void checkInRange(int date) {
        if (date < MagicNumber.MIN_DATE.getNumber() || date > MagicNumber.MAX_DATE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DATE.errorMessage());
        }
    }
}
