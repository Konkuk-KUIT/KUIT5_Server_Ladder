public class NaturalNumber {

    private final int number;

    private NaturalNumber(int number) {
        this.number = number;
    }

    private static void validNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LadderException.INVALID_NUMBER.getMessage());
        }
    }

    public static NaturalNumber of(int number) {
        validNaturalNumber(number);
        return new NaturalNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
