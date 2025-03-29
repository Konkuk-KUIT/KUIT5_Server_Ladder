public class NonNegativeNumber {
    private final int value;

    public NonNegativeNumber(int value){
        if(value<0){
            throw new IllegalArgumentException(LadderError.NON_NEGATIVE_REQUIRED.getMessage());
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
