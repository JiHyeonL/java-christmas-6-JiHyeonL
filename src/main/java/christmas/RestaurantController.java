package christmas;

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

    public void runPlanner() {
        outputView.printWelcome();
        inputDateRetryHandler();
        inputOrderRetryHandler();
        outputView.printAnnounceEventBenefit();

        outputView.printOrder(order);
    }

    private void inputDateRetryHandler() {
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

    private void inputOrderRetryHandler() {
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

}
