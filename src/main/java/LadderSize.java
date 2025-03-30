public class LadderSize {
    private static final double MAX_LINE_RATION = 0.3;
    private static final int MIN_ROW = 1;
    private static final int MIN_PERSON = 2;

    // 행과 열, 최대 라인 수 계산까지 캡슐화
    private final int numberOfRow;
    private final int numberOfPerson;

    public LadderSize(int numberOfRow, int numberOfPerson) {
        if (numberOfRow < MIN_ROW) {
            throw new IllegalArgumentException(ErrorMessage.MIN_ROW_TOO_SMALL.getMessage());
        }
        if (numberOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException(ErrorMessage.MIN_PERSON_TOO_FEW.getMessage());
        }
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getMaxLines(){
        return (int) (numberOfRow * numberOfPerson * MAX_LINE_RATION);
    }
}
