package christmas.constant;

import java.time.LocalDate;

public enum GiveawayEvent {
    CHAMPAGNE("샴페인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25),
            120000);

    private final String gift;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int minimumOrderAmount;

    GiveawayEvent(String gift, LocalDate startDate, LocalDate endDate, int minimumOrderAmount) {
        this.gift = gift;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public boolean canReceiveGift(int beforeDiscountAmount) {
        if (beforeDiscountAmount >= minimumOrderAmount) {
            return true;
        }
        return false;
    }

    public String getGift() {
        return gift;
    }
}
