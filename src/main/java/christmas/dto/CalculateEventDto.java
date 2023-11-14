package christmas.dto;

import christmas.domain.VisitDate;

public class CalculateEventDto {
    private int beforeDiscountAmount;
    private int date;
    private int dessertCount;
    private int mainCount;

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
}
