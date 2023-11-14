package christmas;

import christmas.constant.*;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.CalculateEventDto;
import christmas.dto.DiscountDetails;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class RestaurantController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private VisitDate visitDate;
    private Order order;
    private CalculateEventDto calculateEventDto;
    private DiscountDetails discountDetails;
    private EventBadge eventBadge;

    public void runPlanner() {
        outputView.writeWelcome();
        dateInputRetryHandler();
        orderInputRetryHandler();
        outputView.writeAnnounceEventBenefit(visitDate);

        outputView.writeOrder(order.OrderOutputFormat());

        calculateEventDto = new CalculateEventDto(order.calculateAmount());
        outputView.writeBeforeDiscountAmount(calculateEventDto.getBeforeDiscountAmount());

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
        int dessertCount = order.countByCategory(Category.DESSERT);
        int mainCount = order.countByCategory(Category.MAIN);
        calculateEventDto.setDessertCount(dessertCount);
        calculateEventDto.setMainCount(mainCount);

        if (calculateEventDto.getBeforeDiscountAmount() >= 10000) {
            Map<DiscountEvent, Integer> discountResult =
                    visitDate.getCalculatedDiscount(calculateEventDto);
            discountDetails = new DiscountDetails(discountResult);
        }

        Map<DiscountEvent, Integer> discountResult =
                visitDate.getCalculatedDiscount(calculateEventDto);
        discountDetails = new DiscountDetails(discountResult);

        int giveawayPrice = discountDetails.findDiscountPriceByEvent(DiscountEvent.GIVEAWAY);
        outputView.writeGiveAwayMenu(giveawayPrice);

        String event = discountDetails.makeEventBenefitDetail();
        outputView.writeEventBenefit(event);

        int totalBenefit = discountDetails.calculateTotalBenefit();
        outputView.writeTotalBenefit(totalBenefit);

        int benefitForExpectedPayment = discountDetails.calculateBenefitForExpectedPayment();
        outputView.writeExpectedPayment(calculateEventDto.getBeforeDiscountAmount(), benefitForExpectedPayment);

        String badge = eventBadge.chooseBadgeNameByBenefit(totalBenefit);
        outputView.writeEventBadge(badge);
    }

}
