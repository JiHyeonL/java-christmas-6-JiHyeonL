package christmas.constant;

import christmas.dto.CalculateEventDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public enum DiscountEvent {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25)) {
        @Override
        public int calculateDiscountAmount(CalculateEventDto eventParameter) {
            if (!eventParameter.getIsEventActive()) {
                return 0;
            }
            if (isCanDiscountChristmasEvent(eventParameter.getDate())) {
                return -1000 + -100 * (eventParameter.getDate() - 1);
            }
            return 0;
        }
        private boolean isCanDiscountChristmasEvent(int date) {
            return date <= CHRISTMAS_D_DAY.endDate.getDayOfMonth();
        }
    },

    WEEKDAY("평일 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)) {
        @Override
        public int calculateDiscountAmount(CalculateEventDto eventParameter) {
            if (!eventParameter.getIsEventActive()) {
                return 0;
            }
            if (isCanDiscountWeekdayEvent(eventParameter.getDate()))
                return eventParameter.getDessertCount() * -2023;
            return 0;
        }
        private boolean isCanDiscountWeekdayEvent(int date) {
            LocalDate specificDate = LocalDate.of(2023, 12, date);
            DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
            if (dayOfWeek.compareTo(DayOfWeek.THURSDAY) <= 0) {
                return true;
            }
            return dayOfWeek == DayOfWeek.SUNDAY;
        }
    },

    WEEKEND("주말 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)) {
        @Override
        public int calculateDiscountAmount(CalculateEventDto eventParameter) {
            if (!eventParameter.getIsEventActive()) {
                return 0;
            }
            if (isCanDiscountWeekendEvent(eventParameter.getDate())) {
                return eventParameter.getMainCount() * -2023;
            }
            return 0;
        }
        private boolean isCanDiscountWeekendEvent(int date) {
            LocalDate specificDate = LocalDate.of(2023, 12, date);
            DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                return true;
            }
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                return true;
            }
            return false;
        }
    },
    SPECIAL("특별 할인",
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)) {
        @Override
        public int calculateDiscountAmount(CalculateEventDto eventParameter) {
            if (!eventParameter.getIsEventActive()) {
                return 0;
            }
            if (isCanDiscountSpecialEvent(eventParameter.getDate())) {
                return -1000;
            }
            return 0;
        }
        private boolean isCanDiscountSpecialEvent(int date) {
            List<Integer> starDate = List.of(3, 10, 17, 24, 25, 31);
            if (starDate.contains(date)) {
                return true;
            }
            return false;
        }
    },
   GIVEAWAY("증정 이벤트",
           LocalDate.of(2023, 12, 1),
           LocalDate.of(2023, 12, 31)) {
       @Override
       public int calculateDiscountAmount(CalculateEventDto eventParameter) {
           if (!eventParameter.getIsEventActive()) {
               return 0;
           }
           return GiveawayEvent.CHAMPAGNE.calculateGiveawayAmount(eventParameter.getBeforeDiscountAmount());
       }
   };

    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    DiscountEvent(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract int calculateDiscountAmount(CalculateEventDto eventParameter);

    public String getName() {
        return name;
    }
}
