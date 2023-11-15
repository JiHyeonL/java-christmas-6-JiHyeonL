package christmas.domain;

import christmas.constant.Category;
import christmas.constant.ErrorMessage;
import christmas.constant.Menu;
import christmas.constant.PlannerMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> details;

    public Order(List<String> order) {
        Map<String, Integer> validOrder = validateAndParseMap(order);
        this.details = parseStringNameToMenu(validOrder);
    }

    public String OrderOutputFormat() {
        StringBuilder menu = new StringBuilder();
        for (Map.Entry<Menu, Integer> order : details.entrySet()) {
            menu.append(PlannerMessage.makeMenuFormat(order.getKey(), order.getValue()));
        }
        menu.deleteCharAt(menu.length() - 1);

        return menu.toString();
    }

    public int calculateAmount() {
        int amount = 0;
        for (Map.Entry<Menu, Integer> order : details.entrySet()) {
            amount += Menu.calculateOrderPriceByMenu(order.getKey(), order.getValue());
        }

        return amount;
    }

    public int countByCategory(Category category) {
        int allCount = 0;
        for (Map.Entry<Menu, Integer> order : details.entrySet()) {
            if (order.getKey().getCategory().equals(category)) {
                allCount += order.getValue();
            }
        }

        return allCount;
    }

    private Map<String, Integer> validateAndParseMap(List<String> order) {
        OrderExceptionWithMapFormat validOrder = new OrderExceptionWithMapFormat(order);

        return validOrder.getValidOrder();
    }

    private Map<Menu, Integer> parseStringNameToMenu(Map<String, Integer> validOrder) {
        Map<Menu, Integer> finalOrder = new HashMap<>();

        for (Map.Entry<String, Integer> order : validOrder.entrySet()) {
            Menu menu = Menu.findMenuByName(order.getKey());
            if (menu == null) {
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
            }
            finalOrder.put(menu, order.getValue());
        }

        return finalOrder;
    }
}
