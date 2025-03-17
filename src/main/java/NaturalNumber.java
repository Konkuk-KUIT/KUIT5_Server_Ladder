public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber(int naturalNumber) {
        if (naturalNumber < 1) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
        this.naturalNumber = naturalNumber;
    }
    public int getNaturalNumber() {
        return naturalNumber;
    }
}