import common.exception.ExceptionMessage;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static boolean isNaturalNumber(int number) {
        if (number > 0) {
            return true;
        }
        return false;
    }

    public int getValue(){
        return number;
    }
}