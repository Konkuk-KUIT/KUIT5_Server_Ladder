public class NaturalNumber {
    private final int number;

    public NaturalNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException("자연수(1 이상)이어야 합니다.");
        }
    }

    private static boolean isNaturalNumber(int number) {
        if (number > 0) {
            return true;
        }
        return false;
    }

    public int getValue(){
        return number;
    }
}