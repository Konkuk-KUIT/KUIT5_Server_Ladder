package common.exception;

public enum ExceptionMessage {
    INVALID_POSITION("유효하지 않은 위치입니다."),
    ALREADY_HAS_LINE("이미 선이 그려진 위치입니다."),
    INVALID_START_POSITION("잘못된 시작 위치입니다."),
    NOT_NATURAL_NUMBER("자연수(1 이상)이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
