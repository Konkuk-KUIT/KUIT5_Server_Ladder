// 사다리를 생성할 때 0 이상의 값으로 생성되는지 확인하는 클래스

public class GreaterThanZero {
    private final int number;

    public GreaterThanZero(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 값만 허용됩니다.");
        }
        this.number = number;
    }

    public static GreaterThanZero from(int number) {
        return new GreaterThanZero(number);
    }

    public int getNumber() {
        return number;
    }
}
