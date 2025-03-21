public class NaturalNumber {

    private final int number;

    private NaturalNumber(int number) {
        this.number = number;
    }

    public static NaturalNumber of(int number) {
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_OF_POSITION.getErrorMessage());
        }
    }

    private static boolean isNaturalNumber(int number) {
        return number > 0;
    }

    public int getNumber() {
        return number;
    }

}
