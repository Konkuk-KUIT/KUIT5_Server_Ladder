import util.ExceptionMsg;

public class NaturalNumber {
    private final int num;
    public NaturalNumber(int num) {
        if (num <= 0){
            throw new IllegalArgumentException(ExceptionMsg.MORE_THAN_ZERO.getMessage());
        }
        this.num = num;
    }

    public NaturalNumber(double num) {
        throw new IllegalArgumentException(ExceptionMsg.INPUT_CANNOT_DOUBLE_TYPE.getMessage());
    }

    public int getNum() {
        return num;
    }
}
