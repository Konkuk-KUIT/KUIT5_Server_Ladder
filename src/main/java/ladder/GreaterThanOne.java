package ladder;

import static ladder.ExceptionMessage.*;

public class GreaterThanOne { // 사다리의 행과 열이 2이상이어야 하므로, 그것을 검증해주는 클래스

    private final int number;

    public GreaterThanOne(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static GreaterThanOne from(int number) {
        return new GreaterThanOne(number);
    }

    private void validate(int number) {
        if (!isGreaterThanOne(number)) {
            throw new IllegalArgumentException(INVALID_LADDER_NUMBER.getMessage());
        }
    }

    private static boolean isGreaterThanOne(int number) {
        return number > 1;
    }
}
