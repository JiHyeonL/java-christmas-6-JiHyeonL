package christmas.constant;

public enum GiveawayEvent {
    CHAMPAGNE(Menu.CHAMPAGNE, 120000);

    private final Menu gift;
    private final int minimumOrderAmount;

    GiveawayEvent(Menu gift, int minimumOrderAmount) {
        this.gift = gift;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public int calculateGiveawayAmount(int beforeDiscountAmount) {
        if (beforeDiscountAmount >= minimumOrderAmount) {
            return -gift.getPrice();
        }
        return 0;
    }
}
