package christmas;

import christmas.constant.*;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.dto.CalculateEventDto;
import christmas.domain.DiscountDetails;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class RestaurantController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private VisitDate visitDate;
    private Order order;
    private CalculateEventDto calculateEventDto;
    private DiscountDetails discountDetails;

    public void runPlanner() {
        outputView.writeWelcome();
        dateInputRetryHandler();
        orderInputRetryHandler();
        outputView.writeAnnounceEventBenefit(visitDate);

        outputView.writeOrder(order.OrderOutputFormat());

        calculateEventDto = new CalculateEventDto(order.calculateAmount());
        outputView.writeBeforeDiscountAmount(calculateEventDto.getBeforeDiscountAmount());

        setEventCalculate();
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

    private void setEventCalculate() {
        boolean isEventActive = true;
        int dessertCount = order.countByCategory(Category.DESSERT);
        int mainCount = order.countByCategory(Category.MAIN);
        calculateEventDto.setDessertCount(dessertCount);
        calculateEventDto.setMainCount(mainCount);

        if (calculateEventDto.getBeforeDiscountAmount() < MagicNumber.MIN_EVENT_ACTIVE_BENEFIT.getNumber()) {
            isEventActive = false;
        }
        calculateEventDto.setIsEventActive(isEventActive);

        Map<DiscountEvent, Integer> discountResult =
                visitDate.getCalculatedDiscount(calculateEventDto);
        discountDetails = new DiscountDetails(discountResult);
    }

    private void allEventOutputHandler() {
        int giveawayPrice = discountDetails.findDiscountPriceByEvent(DiscountEvent.GIVEAWAY);
        outputView.writeGiveAwayMenu(giveawayPrice);

        String event = discountDetails.makeEventBenefitDetail();
        outputView.writeEventBenefit(event);

        int totalBenefit = discountDetails.calculateTotalBenefit();
        outputView.writeTotalBenefit(totalBenefit);

        int benefitForExpectedPayment = discountDetails.calculateBenefitForExpectedPayment();
        outputView.writeExpectedPayment(calculateEventDto.getBeforeDiscountAmount(), benefitForExpectedPayment);

        String badge = EventBadge.chooseBadgeNameByBenefit(totalBenefit);
        outputView.writeEventBadge(badge);
    }

}
