package christmas.view;

import christmas.constant.PlannerMessage;
import christmas.domain.Order;


public class OutputView {
    public void printWelcome() {
        PlannerMessage.ANNOUNCE_WELCOME.printMessage();
    }

    public void printAnnounceEventBenefit() {
        PlannerMessage.ANNOUNCE_EVENT_BENEFIT.printMessage();
    }
    public void printMenu(Order order) {
        order.printOrder();
    }
}
