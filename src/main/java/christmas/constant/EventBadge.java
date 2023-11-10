package christmas.constant;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int cost;

    EventBadge(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
