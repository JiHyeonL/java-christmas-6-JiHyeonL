package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderExceptionWithMapFormatTest {
    private OrderExceptionWithMapFormat orderExceptionWithMapFormat;

    @Test
    void 중복_메뉴() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스-1개");
        rawOrder.add("양송이수프-2개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴판에_없는_메뉴() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스-1개");
        rawOrder.add("새로운스프-2개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_개수_0개() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스-0개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_형식_다름1() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스-3");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_형식_다름2() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프1개");
        rawOrder.add("타파스-3");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_형식_다름3() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스- 3개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_형식_다름4() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-1개");
        rawOrder.add("타파스--3개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 메뉴_최대_20개_ok() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("양송이수프-17개");
        rawOrder.add("타파스-3개");
    }

    @Test
    void 메뉴_21개_no() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("바비큐립-1개");
        rawOrder.add("타파스--20개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

    @Test
    void 음료만_주문불가() {
        List<String> rawOrder = new ArrayList<>();
        rawOrder.add("제로콜라-1개");
        rawOrder.add("레드와인-2개");

        assertThrows(IllegalArgumentException.class, () -> {
            orderExceptionWithMapFormat = new OrderExceptionWithMapFormat(rawOrder);
        });
    }

}