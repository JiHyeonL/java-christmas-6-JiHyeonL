package christmas.dto;

public class CalculateEventDto {
    private int beforeDiscountAmount;
    private int date;
    private int dessertCount;
    private int mainCount;
    private boolean isEventActive;

    public CalculateEventDto(int beforeDiscountAmount) {
        this.beforeDiscountAmount = beforeDiscountAmount;
    }

    public void setDessertCount(int dessertCount) {
        this.dessertCount = dessertCount;
    }

    public void setMainCount(int mainCount) {
        this.mainCount = mainCount;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setIsEventActive(boolean isEventActive) {
        this.isEventActive = isEventActive;
    }

    public int getBeforeDiscountAmount() {
        return beforeDiscountAmount;
    }

    public int getDate() {
        return date;
    }

    public int getDessertCount() {
        return dessertCount;
    }

    public int getMainCount() {
        return mainCount;
    }

    public boolean getIsEventActive() {
        return isEventActive;
    }
}
