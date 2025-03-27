public class NonNegativeNumber {
    private int number;

    public NonNegativeNumber(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE_NUMBER_CANNOT_BE_NEGATIVE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
