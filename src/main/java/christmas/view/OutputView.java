package christmas.view;

import christmas.constant.PlannerMessage;
import christmas.domain.Order;
import christmas.domain.VisitDate;


public class OutputView {
    public void writeWelcome() {
        PlannerMessage.ANNOUNCE_WELCOME.printMessage();
    }

    public void writeAnnounceEventBenefit(VisitDate visitDate) {
        System.out.println(visitDate.announceEventBenefitWithDate());
    }

    public void writeOrder(String order) {
        System.out.println(PlannerMessage.makeOrderOutputDetail(order));
    }

    public void writeBeforeDiscountAmount(int cost) {
        System.out.println(PlannerMessage.makeBeforeDiscountAmountDetail(cost));
    }

}
