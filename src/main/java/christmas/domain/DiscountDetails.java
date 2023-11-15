package christmas.dto;

import christmas.constant.DiscountEvent;
import christmas.constant.PlannerMessage;

import java.util.Map;

public class DiscountDetails {
    private Map<DiscountEvent, Integer> discountAmount;

    public DiscountDetails(Map<DiscountEvent, Integer> discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int findDiscountPriceByEvent(DiscountEvent event) {
        return discountAmount.get(event);
    }

    public String makeEventBenefitDetail() {
        StringBuilder eventFormat = new StringBuilder();
        for (Map.Entry<DiscountEvent, Integer> event : discountAmount.entrySet()) {
            if (event.getValue() != 0) {
                eventFormat.append(PlannerMessage.makeEventBenefitFormat(event.getKey(), event.getValue()))
                        .append("\n");
            }
        }
        if (eventFormat.length() == 0) {
            return PlannerMessage.OUTPUT_NO_EVENT.getMessage();
        }

        eventFormat.deleteCharAt(eventFormat.length() - 1);
        return eventFormat.toString();
    }

    public int calculateTotalBenefit() {
        int total = 0;
        for (int price : discountAmount.values()) {
            total += price;
        }
        return total;
    }

    public int calculateBenefitForExpectedPayment() {
        int total = 0;
        for (Map.Entry<DiscountEvent, Integer> event : discountAmount.entrySet()) {
            if (!event.getKey().equals(DiscountEvent.GIVEAWAY)) {
                total += event.getValue();
            }
        }
        return total;
    }
}
