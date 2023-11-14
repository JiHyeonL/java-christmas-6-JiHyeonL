package christmas.dto;

import christmas.constant.DiscountEvent;

import java.util.Map;

public class DiscountDetails {
    private Map<DiscountEvent, Integer> discountAmount;

    public DiscountDetails(Map<DiscountEvent, Integer> discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void addDiscountEvent(DiscountEvent event, int price) {
        discountAmount.put(event, price);
    }

    public int findDiscountPriceByEvent(DiscountEvent event) {
        return discountAmount.get(event);
    }
}
