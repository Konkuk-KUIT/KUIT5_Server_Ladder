public enum ErrorMessage {
    INVALID_DRAW_LINE_ROW("사다리를 그릴 수 없는 행입니다"),
    INVALID_NUMBER_OF_PERSON("참여 인원은 1명 이상이어야 합니다."),
    INVALID_COL("유효하지 않은 열입니다."),
    INVALID_DRAW_LINE_COL("사다리를 그릴 수 없는 열입니다");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
