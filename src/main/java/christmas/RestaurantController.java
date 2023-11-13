package christmas;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.view.InputView;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static christmas.view.OutputView.printWelcome;

public class RestaurantController {
    private VisitDate visitDate;
    private Order order;
    public void runPlanner() {
        printWelcome();
        inputDateRetryHandler();
        inputOrderRetryHandler();
    }

    private void inputDateRetryHandler() {
        while (true) {
            try {
                int rawDate = InputView.readDate();
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
                List<String> rawOrder = InputView.readOrder();
                order = new Order(rawOrder);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
