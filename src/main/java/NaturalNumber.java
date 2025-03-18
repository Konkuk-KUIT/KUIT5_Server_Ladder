import exception.ExceptionMessage;

public class NaturalNumber {
    private final int naturalNumber;

    private NaturalNumber(int naturalNumber) {

        this.naturalNumber = naturalNumber;
    }
    public static NaturalNumber of(int naturalNumber) {
        if (naturalNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER.getMessage());
        }
        return new NaturalNumber(naturalNumber);
    }
    public int getNaturalNumber() {
        return naturalNumber;
    }
}