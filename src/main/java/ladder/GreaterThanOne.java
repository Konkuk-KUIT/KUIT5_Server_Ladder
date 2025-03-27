package ladder;

import static ladder.ExceptionMessage.*;

// 2 이상 값만 허용하는 검증용 객체
public class GreaterThanOne {

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
