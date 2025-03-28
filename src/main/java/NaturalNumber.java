import exception.ExceptionMessage;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private static void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public int getValue(){
        return number;
    }
}