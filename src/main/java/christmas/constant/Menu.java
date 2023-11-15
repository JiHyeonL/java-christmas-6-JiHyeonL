package christmas.constant;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    MUSHROOM_SOUP(Category.APPETIZER, "양송이수프", 6000),
    TAPAS(Category.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(Category.APPETIZER, "시저샐러드", 8000),
    T_BONE_STEAK(Category.MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(Category.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(Category.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(Category.MAIN, "크리스마스파스타", 25000),
    CHOCOLATE_CAKE(Category.DESSERT, "초코케이크", 15000),
    ICE_CREAM(Category.DESSERT, "아이스크림", 5000),
    ZERO_COLA(Category.BEVERAGE, "제로콜라", 3000),
    RED_WINE(Category.BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(Category.BEVERAGE, "샴페인", 25000);

    private final Category category;
    private final String name;
    private final int price;

    Menu(Category category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static boolean isInMenu(String dishName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(dishName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBeverage(String dishName) {
        List<Menu> menuInBeverage = findByCategoryName(Category.BEVERAGE);
        for (Menu beverage : menuInBeverage) {
            if (beverage.name.equals(dishName)) {
                return true;
            }
        }
        return false;
    }

    public static List<Menu> findByCategoryName(Category name) {
        List<Menu> menuInCategory = new ArrayList<>();
        for (Menu menu : Menu.values()) {
            if(menu.category.equals(name)) {
                menuInCategory.add(menu);
            }
        }

        return menuInCategory;
    }

    public static Menu findMenuByName(String menuName) {
        Menu result = null;
        for (Menu menu : Menu.values()) {
            if(menu.name.equals(menuName)) {
                result =  menu;
                break;
            }
        }
        
        return result;
    }

    public static int calculateOrderPriceByMenu(Menu menu, int count) {
        return menu.price * count;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
