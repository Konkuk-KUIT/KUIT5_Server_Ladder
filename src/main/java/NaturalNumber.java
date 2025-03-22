public class NaturalNumber {
    private final int value;

    private NaturalNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static NaturalNumber of(int value) {
        return new NaturalNumber(value);
    }

    private void validate(int value) {
        if(value <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
