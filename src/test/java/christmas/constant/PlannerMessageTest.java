package christmas.constant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlannerMessageTest {
    private PlannerMessage plannerMessage;

    @Test
    void 증정이벤트_0일경우_없음반환() {
        String result = plannerMessage.makeGiveawayMenuDetail(0);
        assertThat(result).contains("<증정 메뉴>","없음");
    }

    @Test
    void 증정이벤트_샴페인_반환() {
        String result = plannerMessage.makeGiveawayMenuDetail(-120000);
        assertThat(result).contains("<증정 메뉴>","샴페인 1개");
    }
}