package christmas.constant;

import org.w3c.dom.ls.LSOutput;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String errorMessage(){
        return PREFIX.message + " " + this.message;
    }
}
