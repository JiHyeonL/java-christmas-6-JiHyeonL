package christmas.domain;

import christmas.constant.ErrorMessage;
import christmas.constant.Menu;
import christmas.constant.PlannerMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> details;

    public Order(List<String> order) {
        Map<String, Integer> validOrder = validateAndParseMap(order);
        this.details = parseStringNameToMenu(validOrder);
    }

    public void printOrder() {
        PlannerMessage.TITLE_MENU_ORDER.printMessage();

        for (Map.Entry<Menu, Integer> order : details.entrySet()) {
            PlannerMessage.printOrderMenu(order.getKey(), order.getValue());
        }
    }

    private Map<String, Integer> validateAndParseMap(List<String> order) {
        Map<String, Integer> orderDetail = parseStringToMapWithCheckDuplicate(order);
        checkInMenu(orderDetail);
        checkOrderGreaterThanOne(orderDetail);
        checkOrderCountMaxLimit(orderDetail);
        checkOrderMenuOnlyBeverage(orderDetail);
        checkCountGreaterThanOne(orderDetail);

        return orderDetail;
    }

    private Map<String, Integer> parseStringToMapWithCheckDuplicate(List<String> order) {
        Map<String, Integer> orderDetail = new HashMap<>();

        for (String detail : order) {
            List<String> menuAndCount = parseStringToList(detail);
            String menu = checkNotNull(menuAndCount.get(0));
            String count = checkNotNull(menuAndCount.get(1));

            if (orderDetail.containsKey(menu)) {
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
            }
            orderDetail.put(menu, parseStringToInt(count));
        }

        return orderDetail;
    }

    private List<String> parseStringToList(String detail) {
        List<String> parseDetail;
        try {
            parseDetail = Arrays.asList(detail.split("-"));
            if (parseDetail.size() != 2) {
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
            }
            return parseDetail;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private int parseStringToInt(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private String checkNotNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
        return input;
    }

    private void checkInMenu(Map<String, Integer> orderDetail) {
        for (String dish : orderDetail.keySet()) {
            if (Menu.isInMenu(dish) == false)
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private void checkOrderGreaterThanOne(Map<String, Integer> orderDetail) {
        if (orderDetail.size() < 1) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private void checkOrderCountMaxLimit(Map<String, Integer> orderDetail) {
        int countSum = 0;
        for (int count : orderDetail.values()) {
            countSum += count;
        }

        if (countSum > 20) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private void checkOrderMenuOnlyBeverage(Map<String, Integer> orderDetail) {
        boolean onlyBeverage = true;
        for (String dish : orderDetail.keySet()) {
            if (!Menu.isBeverage(dish)) {
                onlyBeverage = false;
                break;
            }
        }

        if (onlyBeverage == true) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }

    private void checkCountGreaterThanOne(Map<String, Integer> orderDetail) {
        for (int count : orderDetail.values()) {
            if (count < 1) {
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
            }
        }
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
