public enum ExceptionMessage {
    NATURAL_NUMBER_CANNOT_BE_NEGATIVE_OR_ZERO("자연수만 입력할 수 있습니다."),
    NON_NEGATIVE_NUMBER_CANNOT_BE_NEGATIVE("음수는 입력할 수 없습니다."),
    POSITION_INVALID("유효하지 않은 좌표입니다."),
    LINE_UNREPEATABLE("연속된 다리는 생성할 수 없습니다."),
    LINE_ALREADY_EXISTS("이미 다리가 생성된 좌표입니다."),
    START_INDEX_OUT_OF_BOUNDS("시작 지점 좌표가 유효하지 않습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
