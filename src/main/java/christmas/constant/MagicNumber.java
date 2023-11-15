package christmas.constant;

public enum MagicNumber {
    ORDER_ELEMENT_COUNT(2),
    MAX_ORDER_COUNT(20);

    int number;
    MagicNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
