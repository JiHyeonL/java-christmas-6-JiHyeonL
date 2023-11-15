package christmas.constant;

public enum MagicNumber {
    ORDER_ELEMENT_COUNT(2),
    MAX_ORDER_COUNT(20),
    MIN_DATE(1),
    MAX_DATE(31),
    MIN_EVENT_ACTIVE_BENEFIT(10000);

    int number;
    MagicNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
