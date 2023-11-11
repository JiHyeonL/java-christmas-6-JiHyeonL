package christmas.domain;

import christmas.constant.ErrorMessage;

public class VisitDate {
    private final int date;

    VisitDate(int date) {
        validate(date);
        this.date = date;
    }

    private void validate(int date) {
        checkInRange(date);
    }

    private void checkInRange(int date) {
        if (date < 1 && date > 31) {
            ErrorMessage.DATE.throwErrorWithMessage();
        }
    }
}
