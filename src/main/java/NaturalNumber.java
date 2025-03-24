public class NaturalNumber {
    private final int value;

    public NaturalNumber(int value) {
        if(value <= 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
