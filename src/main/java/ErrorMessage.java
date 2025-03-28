public enum ErrorMessage {
    INVALID_DRAW_ROWCOL("요청한 사다리 라인의 위치가 적합하지 않습니다."),
    INVALID_SELECT_RUN_COL("유효한 사다리 줄을 선택해야 합니다."),
    ALREADY_EXIST_LINE("이미 존재하는 사다리 라인입니다."),
    NO_CONTINUOUS_LINE("연속된 사다리 라인을 추가할 수 없습니다."),
    LEFT_MOVE_NOT_ALLOWED("왼쪽으로 이동할 수 없는 위치입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
