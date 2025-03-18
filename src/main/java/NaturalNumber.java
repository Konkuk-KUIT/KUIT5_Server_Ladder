import exception.ExceptionMessage;

public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber(int naturalNumber) {
        if (naturalNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER.getMessage());
        }
        this.naturalNumber = naturalNumber;
    }
    public int getNaturalNumber() {
        return naturalNumber;
    }
}