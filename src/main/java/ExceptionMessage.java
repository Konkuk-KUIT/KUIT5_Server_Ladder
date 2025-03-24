public enum ExceptionMessage {
    POSITION_INVALID("유효하지 않은 좌표입니다."),
    LINE_UNREPEATABLE("연속된 다리는 생성할 수 없습니다."),
    NUMBER_OF_PERSON_OUT_OF_BOUNDS("시작 안원은 1 이상으로 입력해야 합니다."),
    START_INDEX_OUT_OF_BOUNDS("시작 지점 좌표가 유효하지 않습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
