package christmas.constant;

import java.time.LocalDate;

public enum GiveawayEvent {
    CHAMPAGNE(Menu.CHAMPAGNE,
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25),
            120000);

    private final Menu gift;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int minimumOrderAmount;

    GiveawayEvent(Menu gift, LocalDate startDate, LocalDate endDate, int minimumOrderAmount) {
        this.gift = gift;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public int calculateGiveawayAmount(int beforeDiscountAmount) {
        if (beforeDiscountAmount >= minimumOrderAmount) {
            return -gift.getPrice();
        }
        return 0;
    }

    public Menu getGift() {
        return gift;
    }
}
