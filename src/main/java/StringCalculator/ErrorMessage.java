package StringCalculator;

public enum ErrorMessage {
    NO_POSITIVE("음수는 입력될 수 없습니다."),
    NO_INTEGER("정수가 아닌 값은 입력될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
