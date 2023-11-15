package christmas.constant;

public enum EventBadge {
    SANTA("산타", -20000),
    TREE("트리", -10000),
    STAR("별", -5000);

    private final String name;
    private final int cost;

    EventBadge(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public static String chooseBadgeNameByBenefit(int totalBenefit) {
        for (EventBadge badge : EventBadge.values()) {
            if (totalBenefit <= badge.cost) {
                return badge.name;
            }
        }
        return PlannerMessage.OUTPUT_NO_EVENT.getMessage();
    }
}
