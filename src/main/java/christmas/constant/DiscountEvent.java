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

    private final LocalDate eventStartDate;
    private final LocalDate eventEndDate;
    private final int discountCost;

    DiscountEvent(LocalDate eventStartDate, LocalDate eventEndDate, int discountCost) {
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.discountCost = discountCost;
    }

}
