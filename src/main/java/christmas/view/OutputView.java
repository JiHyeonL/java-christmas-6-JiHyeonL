package christmas.view;

import christmas.constant.PlannerMessage;
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

    public void writeBeforeDiscountAmount(int amount) {
        System.out.println(PlannerMessage.makeBeforeDiscountAmountDetail(amount));
    }

    public void writeGiveAwayMenu(int price) {
        System.out.println(PlannerMessage.makeGiveawayMenuDetail(price));
    }

    public void writeEventBenefit(String event) {
        System.out.println(PlannerMessage.makeEventBenefitDetail(event));
    }

    public void writeTotalBenefit(int discountPrice) {
        System.out.println(PlannerMessage.makeTotalBenefitDetail(discountPrice));
    }

    public void writeExpectedPayment(int beforeDiscountAmount, int totalBenefit) {
        System.out.println(PlannerMessage.makeExpectedPaymentDetail(beforeDiscountAmount, totalBenefit));
    }

    public void writeEventBadge(String badgeResult) {
        System.out.println(PlannerMessage.makeEventBadgeDetail(badgeResult));
    }
}
