package christmas.view;

import christmas.constant.PlannerMessage;

import static christmas.constant.PlannerMessage.ANNOUNCE_WELCOME;

public class OutputView {
    public static void printWelcome() {
        ANNOUNCE_WELCOME.printMessage();
    }
    public static void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
}
