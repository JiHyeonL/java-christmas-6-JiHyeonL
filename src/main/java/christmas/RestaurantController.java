package christmas;

import christmas.constant.GiveawayEvent;
import christmas.constant.PlannerMessage;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class RestaurantController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private VisitDate visitDate;
    private Order order;
    private int beforeDiscountAmount;

    public void runPlanner() {
        outputView.writeWelcome();
        dateInputRetryHandler();
        orderInputRetryHandler();
        outputView.writeAnnounceEventBenefit(visitDate);

        outputView.writeOrder(order.OrderOutputFormat());

        beforeDiscountAmount = order.calculateAmount();
        outputView.writeBeforeDiscountAmount(beforeDiscountAmount);

        allEventOutputHandler();
    }

    private void dateInputRetryHandler() {
        while (true) {
            try {
                int rawDate = inputView.readDate();
                visitDate = new VisitDate(rawDate);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void orderInputRetryHandler() {
        while (true) {
            try {
                List<String> rawOrder = inputView.readOrder();
                order = new Order(rawOrder);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void allEventOutputHandler() {
        boolean isGiveAway = false;
        boolean isEvent = false;

        if (beforeDiscountAmount >= 10000) {
            isGiveAway = GiveawayEvent.CHAMPAGNE.canReceiveGift(beforeDiscountAmount);

        }
        outputView.writeGiveAwayMenu(isGiveAway, GiveawayEvent.CHAMPAGNE.getGift());


    }

}
