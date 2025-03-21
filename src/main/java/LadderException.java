public enum LadderException {
    SAME_NUMBER("같은 번호로 라인을 그릴 수는 없습니다."),
    OUT_OF_ROW_LENGTH_RANGE("사다리의 길이 범위 외의 숫자는 입력할 수 없습니다."),
    OUT_OF_COLUMN_LENGTH_RANGE("사다리의 번호 범위 외의 숫자는 입력할 수 없습니다."),
    INVALID_LINE_SPACING("라인의 시작과 끝 위치는 반드시 한 칸이어야 합니다."),
    LINE_POSITION_CONFLICT("기존 라인과 이어지거나 이미 라인이 존재하는 곳에 라인을 생성할 수 없습니다."),
    INVALID_NUMBER("0 이하의 값을 입력할 수 없습니다.");

    private final String message;

    LadderException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
