package ladder;

public enum ErrorMessage {
    NO_NEGATIVE_ZERO("참여 인원은 1명 이상이어야 합니다."),
    NO_OUTSIDE("유효하지 않은 위치입니다."),
    CANTDRAWPOSITION("사다리를 그릴 수 없는 위치입니다");

    private final String Message;

    ErrorMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
