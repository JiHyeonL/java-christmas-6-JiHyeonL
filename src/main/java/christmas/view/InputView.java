package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.ErrorMessage;
import christmas.constant.PlannerMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int readDate() {
        PlannerMessage.REQUEST_VISIT_DATE.printMessage();
        String rawDate = Console.readLine();
        return parseStringToInt(rawDate);
    }

    public static List<String> readOrder() {
        PlannerMessage.REQUEST_MENU_ORDER.printMessage();
        String rawOrder = Console.readLine();
        return parseStringToList(rawOrder);
    }

    private static int parseStringToInt(String rawDate) {
        try {
            return Integer.parseInt(rawDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE.errorMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE.errorMessage());
        }
    }

    private static List<String> parseStringToList(String rawOrder) {
        try {
            if (rawOrder.endsWith(",")) {
                throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
            }
            return Arrays.asList(rawOrder.split( ",") );
        } catch (NullPointerException e){
            throw new IllegalArgumentException(ErrorMessage.ORDER.errorMessage());
        }
    }



}
