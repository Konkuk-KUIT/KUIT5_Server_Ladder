public class NaturalNumber {
    private int number;

    public NaturalNumber(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (number <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NATURAL_NUMBER_CANNOT_BE_NEGATIVE_OR_ZERO.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
