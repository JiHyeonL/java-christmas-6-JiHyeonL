package christmas.constant;

import java.time.LocalDate;

public enum DiscountEvent {
    CHRISTMAS_D_DAY(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25),
            1000),
    WEEKDAY(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            2023),
    WEEKEND(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            2023),
    SPECIAL(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31),
            1000);

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int discountCost;

    DiscountEvent(LocalDate startDate, LocalDate endDate, int discountCost) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountCost = discountCost;
    }

}
