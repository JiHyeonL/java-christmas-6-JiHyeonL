package christmas.domain;

import christmas.constant.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;



    @Test
    void 주문결과_출력문자열() {
        List<String> orderList = List.of("초코케이크-1","크리스마스파스타-3");
        order = new Order(orderList);
        String result = order.OrderOutputFormat();

        assertThat(result).contains("초코케이크 1개");
        assertThat(result).contains("크리스마스파스타 3개");
    }

    @Test
    void 주문총액_계산() {
        List<String> orderList = List.of("초코케이크-1","크리스마스파스타-3");
        order = new Order(orderList);
        int result = order.calculateAmount();

        assertThat(result).isEqualTo(15000 + 25000*3);
    }

    @Test
    void 메인개수_계산() {
        List<String> orderList = List.of(
                "초코케이크-1", "크리스마스파스타-3", "해산물파스타-1",
                "티본스테이크-2", "양송이수프-4", "아이스크림-1");
        order = new Order(orderList);
        int result = order.countByCategory(Category.MAIN);

        assertThat(result).isEqualTo(3+1+2);
    }

    @Test
    void 디저트개수_계산() {
        List<String> orderList = List.of(
                "초코케이크-1", "크리스마스파스타-3", "해산물파스타-1",
                "티본스테이크-2", "아이스크림-5");
        order = new Order(orderList);
        int result = order.countByCategory(Category.DESSERT);

        assertThat(result).isEqualTo(1+5);
    }
}