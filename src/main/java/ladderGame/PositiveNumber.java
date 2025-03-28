package ladderGame;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        validatePositive(number);
        this.number = number;
    }

    private void validatePositive(int number) {
        if (number < 1)
            throw new IllegalArgumentException(ExceptionCode.NOT_POSITIVE_INPUT.getMessage());
    }

    public int getNumber() {
        return number;
    }
}
