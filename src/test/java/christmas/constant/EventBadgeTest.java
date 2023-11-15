package christmas.constant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {
    private EventBadge eventBadge;

    @Test
    void 배지_별_6000원일때() {
        String badge = eventBadge.chooseBadgeNameByBenefit(-6000);
        assertThat(badge).isEqualTo("별");
    }

    @Test
    void 배지_트리_11000원일때() {
        String badge = eventBadge.chooseBadgeNameByBenefit(-11000);
        assertThat(badge).isEqualTo("트리");
    }

    @Test
    void 배지_산타_20000원일때() {
        String badge = eventBadge.chooseBadgeNameByBenefit(-20000);
        assertThat(badge).isEqualTo("산타");
    }
}