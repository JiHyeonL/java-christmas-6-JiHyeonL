package christmas.constant;

public enum PlannerMessage {
    ANNOUNCE_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUSET_MENU_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ANNOUNCE_EVENT("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    TITLE_MENU_ORDER("<주문 메뉴>"),
    TITLE_BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>"),
    TITLE_GIVEAWAY_MENU("<증정 메뉴>"),
    TITLE_BENEFIT_DETAIL("<혜택 내역>"),
    TITLE_BENEFIT_AMOUNT("<총혜택 금액>"),
    OUTPUT_BENEFIT_AMOUNT("%,d원"),
    TITLE_EXPECTED_PAYMENT("<할인 후 예상 결제 금액>"),
    TITLE_EVENT_BADGE("<12월 이벤트 배지>"),
    OUTPUT_MENU_COUNT("%s %d개"),
    OUTPUT_COST("%,d원"),
    OUTPUT_EVENT_DETAIL("%s: %d원");

    private final String message;

    PlannerMessage(String message) {
        this.message = message;
    }

}
