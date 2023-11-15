package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantControllerTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 이벤트_비활성화_출력() {
        assertSimpleTest(() -> {
            run("3", "양송이수프-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "양송이수프 1개",
                    "<할인 전 총주문 금액>",
                    "6,000원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "없음",
                    "<총혜택 금액>",
                    "0원",
                    "<할인 후 예상 결제 금액>",
                    "6,000원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

        @Test
        void 이벤트_활성화_출력() {
            assertSimpleTest(() -> {
                run("25", "바비큐립-3,아이스크림-1,제로콜라-1");
                assertThat(output()).contains(
                        "<주문 메뉴>",
                        "바비큐립 3개",
                        "아이스크림 1개",
                        "제로콜라 1개",
                        "<할인 전 총주문 금액>",
                        "170,000원",
                        "<증정 메뉴>",
                        "샴페인 1개",
                        "<혜택 내역>",
                        "크리스마스 디데이 할인: -3,400원",
                        "평일 할인: -2,023원",
                        "특별 할인: -1,000원",
                        "증정 이벤트: -25,000원",
                        "<총혜택 금액>",
                        "-31,423원",
                        "<할인 후 예상 결제 금액>",
                        "163,577원",
                        "<12월 이벤트 배지>",
                        "산타"
                );
            });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}