package christmas.constant;

import java.time.LocalDate;

public enum DiscountEvent {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25),
            1000),
    WEEKDAY("평일 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            2023),
    WEEKEND("주말 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            2023),
    SPECIAL("특별 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            1000);

    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int discountCost;

    DiscountEvent(String name, LocalDate startDate, LocalDate endDate, int discountCost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountCost = discountCost;
    }

}
