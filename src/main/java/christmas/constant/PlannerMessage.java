package christmas.constant;

import christmas.dto.DiscountDetails;

import java.util.Map;

public enum PlannerMessage {
    ANNOUNCE_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ANNOUNCE_EVENT_BENEFIT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    TITLE_MENU_ORDER("\n<주문 메뉴>"),
    TITLE_BEFORE_DISCOUNT_AMOUNT("\n<할인 전 총주문 금액>"),
    TITLE_GIVEAWAY_MENU("\n<증정 메뉴>"),
    TITLE_BENEFIT_DETAIL("\n<혜택 내역>"),
    TITLE_TOTAL_BENEFIT("\n<총혜택 금액>"),
    TITLE_EXPECTED_PAYMENT("\n<할인 후 예상 결제 금액>"),
    TITLE_EVENT_BADGE("\n<12월 이벤트 배지>"),
    OUTPUT_ORDER("%s %d개"),
    OUTPUT_PRICE("%,d원"),
    OUTPUT_EVENT_DETAIL("%s: %,d원"),
    OUTPUT_NO_EVENT("없음");

    private final String message;

    PlannerMessage(String message) {
        this.message = message;
    }

    public static String makeAnnounceEventBenefitDetail(int date) {
        return String.format(ANNOUNCE_EVENT_BENEFIT.message, date);
    }
    public static String makeMenuFormat(Menu menu, int count) {
        return String.format(OUTPUT_ORDER.message, menu.getName(), count);
    }

    public static String makeOrderOutputDetail(String orderFormat) {
        return TITLE_MENU_ORDER.message + "\n" + orderFormat;
    }

    public static String makeBeforeDiscountAmountDetail(int price) {
        return TITLE_BEFORE_DISCOUNT_AMOUNT.message
                + "\n" + String.format(OUTPUT_PRICE.message, price);
    }

    public static String makeGiveawayMenuDetail(int giveawayPrice) {
        String eventResult = OUTPUT_NO_EVENT.message;
        if (giveawayPrice != 0) {
            eventResult = String.format(OUTPUT_ORDER.message, Menu.CHAMPAGNE.getName(), 1);
        }
        return TITLE_GIVEAWAY_MENU.message
                + "\n" + eventResult;
    }

    public static String makeEventBenefitFormat(DiscountEvent event, int price ) {
        return String.format(OUTPUT_EVENT_DETAIL.message, event.getName(), price);
    }

    public static String makeEventBenefitDetail(String event) {
        return TITLE_BENEFIT_DETAIL.message
                + "\n" + event;
    }

    public static String makeTotalBenefitDetail(int price) {
        return TITLE_TOTAL_BENEFIT.message
                + "\n" + String.format(OUTPUT_PRICE.message, price);
    }

    public static String makeExpectedPaymentDetail(int beforeDiscountAmount, int totalBenefit) {
        return TITLE_EXPECTED_PAYMENT.message
                + "\n" + String.format(OUTPUT_PRICE.message,
                beforeDiscountAmount + totalBenefit);
    }

    public static String makeEventBadgeDetail(String badgeResult) {
        return TITLE_EVENT_BADGE.message
                + "\n" + badgeResult;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
