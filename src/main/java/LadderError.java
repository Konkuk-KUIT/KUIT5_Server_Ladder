public enum LadderError {
    INVALID_POSITION("잘못된 위치입니다."),
    CONTINUOUS_LINE("선을 연속으로 그을 수 없습니다"),
    INVALID_HEIGHT_OR_PEOPLE("사람 수와 사다리 높이는 자연수여야 합니다"),
    NON_NEGATIVE_REQUIRED("0 이상이어야 합니다.");

    private final String message;

    LadderError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
