public enum ExceptionMessage {
    NOT_NATURAL_NUMBER("자연수가 입력되어야 합니다."),
    INVALID_DRAW_LINE("라인 생성이 불가능한 위치입니다."),
    INVALID_DRAW_LEVEL("라인 생성이 불가능한 높이입니다."),
    ALREADY_EXIST_POSITION("이미 선점된 위치입니다."),
    INVALID_RUN_LINE("선택할 수 없는 번호입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
