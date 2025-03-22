package StringCalculator;

import static StringCalculator.ErrorMessage.NO_INTEGER;
import static StringCalculator.ErrorMessage.NO_POSITIVE;

public class Positive {
    private int number;

    public Positive(String value) {
        this(parseValue(value));
    }

    public Positive(int number) {
        validNumber(number);
        this.number = number;
    }

    private static void validNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(NO_INTEGER.getMessage());
        }
    }

    private static int parseValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NO_POSITIVE.getMessage());
        }
    }

    public Positive add(Positive other) {
        return new Positive(this.number + other.number);
    }
    public int getNumber() {
        return number;
    }
}
