public enum ErrorMessage {
    INVALID_POSITION("유효하지 않은 위치입니다."),
    DUPLICATE_LINE("더 이상 라인을 놓을 수 없는 위치입니다."),
    INVALID_LADDER_SIZE("사다리는 최소 1줄, 사람은 최소 2명 이상이어야 합니다."),
    INVALID_START_POSITION("startPosition이 사다리 범위를 벗어났습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
