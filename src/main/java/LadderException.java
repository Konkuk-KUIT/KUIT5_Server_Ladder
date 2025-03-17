public enum LadderException {
    SAME_NUMBER("같은 번호로 라인을 그릴 수는 없습니다."),
    OUT_OF_LENGTH_RANGE("사다리의 길이 범위 외의 숫자는 입력할 수 없습니다."),
    OUT_OF_NUMBER_RANGE("사다리의 번호 범위 외의 숫자는 입력할 수 없습니다.");

    private final String message;

    LadderException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
